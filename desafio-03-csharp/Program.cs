using System;
using System.Globalization;

class Program
{
    static void Main()
    {
        Console.WriteLine("=== CÁLCULO DE JUROS POR ATRASO ===\n");

        Console.Write("Digite o valor da dívida: R$ ");
        string? valorInformado = Console.ReadLine();

        if (!decimal.TryParse(
                valorInformado,
                NumberStyles.Number,
                new CultureInfo("pt-BR"),
                out decimal valor))
        {
            Console.WriteLine("Valor inválido.");
            return;
        }

        Console.Write("Digite a data de vencimento (dd/MM/yyyy): ");
        string? dataInformada = Console.ReadLine();

        if (!DateTime.TryParseExact(
                dataInformada,
                "dd/MM/yyyy",
                CultureInfo.InvariantCulture,
                DateTimeStyles.None,
                out DateTime dataVencimento))
        {
            Console.WriteLine("Data inválida.");
            return;
        }

        DateTime dataAtual = DateTime.Today;

        if (dataVencimento >= dataAtual)
        {
            Console.WriteLine("\nA dívida ainda não está vencida.");
            Console.WriteLine("Dias de atraso: 0");
            Console.WriteLine("Juros: R$ 0,00");
            Console.WriteLine($"Valor total: R$ {valor:N2}");
            return;
        }

        int diasAtraso = (dataAtual - dataVencimento).Days;
        const decimal taxaDiaria = 0.025m;

        decimal juros = valor * taxaDiaria * diasAtraso;
        decimal valorTotal = valor + juros;

        Console.WriteLine("\n=== RESULTADO ===");
        Console.WriteLine($"Valor original: R$ {valor:N2}");
        Console.WriteLine($"Data de vencimento: {dataVencimento:dd/MM/yyyy}");
        Console.WriteLine($"Data atual: {dataAtual:dd/MM/yyyy}");
        Console.WriteLine($"Dias de atraso: {diasAtraso}");
        Console.WriteLine("Taxa diária: 2,5%");
        Console.WriteLine($"Valor dos juros: R$ {juros:N2}");
        Console.WriteLine($"Valor total atualizado: R$ {valorTotal:N2}");
    }
}
