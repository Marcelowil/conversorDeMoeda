import conexao.ExchangeAPI;
import exibicao.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 7){
            System.out.println(Menu.exibirMenu());
            opcao = scanner.nextInt();
            System.out.println("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();
            ExchangeAPI exchange = new ExchangeAPI();
            switch(opcao){
                case 1 -> System.out.println(exchange.converterMoeda("USD", "ARS", valor));
                case 2 -> System.out.println(exchange.converterMoeda("ARS", "USD", valor));
                case 3 -> System.out.println(exchange.converterMoeda("USD", "BRL", valor));
                case 4 -> System.out.println(exchange.converterMoeda("BRL", "USD", valor));
                case 5 -> System.out.println(exchange.converterMoeda("USD", "COP", valor));
                case 6 -> System.out.println(exchange.converterMoeda("COP", "USD", valor));
                case 7 -> {
                    break;
                }
                default -> System.out.println("Selecione uma opção válida");
            }
        }
        scanner.close();
    }
}