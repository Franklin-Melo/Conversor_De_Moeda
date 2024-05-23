package br.com.alura.principal;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoeda {


    private static final String apiKey = "f1d63fb06ff4980256964447";
    private static final String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
    private JsonObject conversionRates;

    public ConverterMoeda() throws IOException, InterruptedException {
        BuscarTaxaDeConversao();
    }

    private void BuscarTaxaDeConversao() throws IOException, InterruptedException {
        String url = endereco;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        this.conversionRates = jsonObject.getAsJsonObject("conversion_rates");

    }

    public double conversao(String moedaOrigem, String moedaAlvo, double valor) {

        if (conversionRates.has(moedaOrigem) && conversionRates.has(moedaAlvo)) {
            double taxaOrigemParaUSD = conversionRates.get(moedaOrigem).getAsDouble();
            double taxaUSDParaAlvo = conversionRates.get(moedaAlvo).getAsDouble();
            return (valor / taxaOrigemParaUSD) * taxaUSDParaAlvo;
        } else {
            throw new IllegalArgumentException("Moeda não encontrada: " + moedaOrigem + " ou " + moedaAlvo);
        }
    }

}
