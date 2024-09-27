  # Currency Converter

## Descrição

O **Currency Converter** é uma aplicação de console em Java que permite ao usuário uma moeda para outra em tempo real, utilizando a API ExchangeRate. O programa oferece um menu com seis opções de conversão, exibe o histórico das últimas conversões realizadas e faz o registro de logs com timestamps, utilizando a biblioteca `java.time`.

## Funcionalidades

- **Conversão em Tempo Real**: Obtém taxas de câmbio atualizadas em tempo real por meio da API [ExchangeRate API](https://exchangerate-api.com/).
- **6 Opções de Conversão de Moedas**: Oferece seis pares de conversão padrão, como USD para BRL, EUR para BRL, entre outros.
- **Histórico de Conversões**: Armazena as últimas cinco conversões realizadas pelo usuário, que podem ser visualizadas no menu.
- **Logs com Timestamp**: Registra o horário exato de cada conversão realizada.

## Tecnologias Utilizadas

- **Java 11** ou superior
- **Gson**: Utilizado para parsing de JSON (conversão da resposta da API).
- **ExchangeRate API**: API externa para obter taxas de câmbio em tempo real.
- **java.time.LocalDateTime**: Para registrar a data e hora de cada conversão.

## Requisitos

- **Java 11+**
- **Gson**

## Como Configurar e Executar

### 1. Configuração do Ambiente

1. **Baixar Dependências**:
   - Faça o download da biblioteca [Gson](https://github.com/google/gson/releases) e coloque o arquivo `gson.jar` na pasta `lib` do projeto.

2. **Compilar o Projeto**:
   - No terminal, vá para o diretório do projeto e compile todas as classes:
     ```bash
     javac -d bin -cp lib/gson.jar src/com/converter/*.java
     ```

3. **Criar o Manifesto**:
   - Crie um arquivo `manifest.txt` com o seguinte conteúdo:
     ```plaintext
     Main-Class: com.converter.Main
     ```

4. **Criar o Jar Executável**:
   - Para criar o arquivo `.jar` com todas as dependências, execute os seguintes comandos:
     ```bash
     mkdir temp
     cd temp
     jar xf ../lib/gson.jar
     cd ..
     jar cfm CurrencyConverter.jar manifest.txt -C bin . -C temp .
     ```

5. **Executar o Arquivo `.jar`**:
   - Para rodar o .jar execute o seguinte comando:
     ```bash
     java -jar CurrencyConverter.jar
     ```

### 2. Uso da Aplicação

https://github.com/user-attachments/assets/134dd662-ae50-4a2e-930e-2eda31f57fb0
