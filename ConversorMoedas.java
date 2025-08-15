import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoedas {

    // URL da API com a moeda base como parâmetro
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. USD -> BRL");
            System.out.println("2. BRL -> USD");
            System.out.println("3. ARS -> BRL");
            System.out.println("4. BRL -> ARS");
            System.out.println("5. CLP -> BRL");
            System.out.println("6. BRL -> CLP");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                continuar = false;
                System.out.println("Encerrando o programa...");
                continue;
            }

            System.out.print("Digite o valor para conversão: ");
            double valor = scanner.nextDouble();

            try {
                switch (opcao) {
                    case 1 -> converter("USD", "BRL", valor);
                    case 2 -> converter("BRL", "USD", valor);
                    case 3 -> converter("ARS", "BRL", valor);
                    case 4 -> converter("BRL", "ARS", valor);
                    case 5 -> converter("CLP", "BRL", valor);
                    case 6 -> converter("BRL", "CLP", valor);
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao realizar conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void converter(String moedaOrigem, String moedaDestino, double valor) throws Exception {
        // Criando o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criando a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + moedaOrigem))
                .build();

        // Enviando e obtendo a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse do JSON usando Gson
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        // Pegando as taxas do JSON
        double taxa = jsonObject.getAsJsonObject("rates").get(moedaDestino).getAsDouble();

        // Fazendo a conversão
        double resultado = valor * taxa;

        System.out.printf("%.2f %s = %.2f %s%n", valor, moedaOrigem, resultado, moedaDestino);
    }
}

Adiciona código do Conversor de Moedas
