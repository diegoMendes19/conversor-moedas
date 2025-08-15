# Conversor de Moedas em Java

Este projeto foi desenvolvido como parte de um desafio técnico. Ele realiza **conversões de moedas em tempo real** utilizando a API [ExchangeRate API](https://api.exchangerate-api.com), fornecendo taxas de câmbio atualizadas e um menu interativo no console.

---

## Funcionalidades
- Conversão entre pelo menos 6 pares de moedas:
  - USD → BRL
  - BRL → USD
  - ARS → BRL
  - BRL → ARS
  - CLP → BRL
  - BRL → CLP
- Taxas de câmbio obtidas **em tempo real** via API.
- Menu interativo no console para o usuário escolher a conversão.
- Entrada de valores pelo teclado e exibição do resultado formatado.

---

## Tecnologias Utilizadas
- **Java 17+**
- **HttpClient / HttpRequest / HttpResponse**
- **Gson** para manipulação de JSON
- **Scanner** para entrada do usuário

---

## Como Executar

1. Clonar o repositório.
2. Importar o projeto no IntelliJ ou Eclipse.
3. Adicionar a biblioteca **Gson** ao classpath.
4. Executar a classe `ConversorMoedas`.

---

## Exemplo de Uso

=== Conversor de Moedas ===

USD -> BRL

BRL -> USD

ARS -> BRL

BRL -> ARS

CLP -> BRL

BRL -> CLP

Sair
Escolha uma opção: 1
Digite o valor para conversão: 100
Resultado: 100.00 USD = 520.00 BRL

---

## Autor
Diego Mendes
