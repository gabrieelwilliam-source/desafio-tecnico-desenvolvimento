# Desafio Técnico de Desenvolvimento

Este repositório contém a resolução de três exercícios de programação, cada um implementado em uma linguagem diferente.

## Estrutura

```text
desafio-tecnico-desenvolvimento/
├── desafio-01-javascript/
│   └── index.js
├── desafio-02-java/
│   └── ControleEstoque.java
├── desafio-03-csharp/
│   └── Program.cs
└── README.md
```

## Desafio 1 — Comissão de vendedores

**Linguagem:** JavaScript / Node.js

O programa percorre os registros de vendas e calcula a comissão de cada vendedor seguindo as regras:

- vendas abaixo de R$ 100,00: sem comissão;
- vendas abaixo de R$ 500,00: comissão de 1%;
- vendas a partir de R$ 500,00: comissão de 5%.

Ao final, o programa exibe o total de comissão acumulado por vendedor.

### Como executar

É necessário ter o Node.js instalado.

```bash
cd desafio-01-javascript
node index.js
```

## Desafio 2 — Movimentação de estoque

**Linguagem:** Java

O programa permite selecionar um produto do estoque e registrar uma movimentação de entrada ou saída.

Cada movimentação possui:

- identificador único gerado com UUID;
- descrição;
- tipo da movimentação;
- quantidade movimentada.

Após a operação, o programa informa a quantidade final do produto em estoque. Também há validação para impedir saída maior que o estoque disponível.

### Como executar

É necessário ter o JDK instalado.

```bash
cd desafio-02-java
javac ControleEstoque.java
java ControleEstoque
```

## Desafio 3 — Juros por atraso

**Linguagem:** C#

O programa recebe:

- valor da dívida;
- data de vencimento.

A partir da data atual, calcula os dias de atraso e aplica a taxa de 2,5% ao dia. Como o enunciado não especifica capitalização composta, foi utilizado cálculo simples diário:

```text
juros = valor × 0,025 × dias de atraso
```

Se a data ainda não estiver vencida, o valor de juros é zero.

### Como executar

Com o .NET SDK instalado, coloque o arquivo `Program.cs` em um projeto console e execute:

```bash
dotnet run
```

## Tecnologias utilizadas

- JavaScript / Node.js
- Java
- C# / .NET
