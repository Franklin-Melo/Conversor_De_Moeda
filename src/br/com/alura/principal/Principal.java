package br.com.alura.principal;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; // Variável para controlar o loop
        while (continuar) {


            System.out.println("#################################################");
            System.out.println();
            System.out.println("Seja bem-vindo ao Conversor de Moeda!:");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair ");
            System.out.println("Escolha uma opção válida: ");
            System.out.println();
            System.out.println("###################################################");
            System.out.println();
            int opcao = scanner.nextInt();

            try {
                ConverterMoeda converter = new ConverterMoeda();
                double valorConvertido = 0;


                switch (opcao) {
                    case 1:
                        System.out.println("Informe o valor em USD:");
                        double valorUSD = scanner.nextDouble();
                        valorConvertido = converter.conversao("USD", "ARS", valorUSD);
                        System.out.println("Valor em ARS: " + valorConvertido);
                        break;
                    case 2:
                        System.out.println("Informe o valor em ARS:");
                        double valorARS = scanner.nextDouble();
                        valorConvertido = converter.conversao("ARS", "USD", valorARS);
                        System.out.println("Valor em USD: " + valorConvertido);
                        break;
                    case 3:
                        System.out.println("Informe o valor em USD:");
                        double valorUSDParaBRL = scanner.nextDouble();
                        valorConvertido = converter.conversao("USD", "BRL", valorUSDParaBRL);
                        System.out.println("Valor em BRL: " + valorConvertido);
                        break;
                    case 4:
                        System.out.println("Informe o valor em BRL:");
                        double valorBRL = scanner.nextDouble();
                        valorConvertido = converter.conversao("BRL", "USD", valorBRL);
                        System.out.println("Valor em USD: " + valorConvertido);
                        break;
                    case 5:
                        System.out.println("Informe o valor em USD:");
                        double valorUSDParaCop = scanner.nextDouble();
                        valorConvertido = converter.conversao("USD", "COP", valorUSDParaCop);
                        System.out.println("Valor em COP: " + valorConvertido);
                        break;
                    case 6:
                        System.out.println("Informe o valor em COP:");
                        double valorCOP = scanner.nextDouble();
                        valorConvertido = converter.conversao("COP", "USD", valorCOP);
                        System.out.println("Valor em USD: " + valorConvertido);
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao buscar a taxa de conversão: " + e.getMessage());
            }
        }
        scanner.close();
    }
}




