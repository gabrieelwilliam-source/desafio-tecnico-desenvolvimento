import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

class Produto {
    private final int codigo;
    private final String descricao;
    private int estoque;

    public Produto(int codigo, String descricao, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public boolean retirarEstoque(int quantidade) {
        if (quantidade > estoque) {
            return false;
        }

        estoque -= quantidade;
        return true;
    }
}

class Movimentacao {
    private final String id;
    private final String descricao;
    private final String tipo;
    private final int quantidade;

    public Movimentacao(String descricao, String tipo, int quantidade) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

public class ControleEstoque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = carregarProdutos();

        System.out.println("=== CONTROLE DE ESTOQUE ===");
        listarProdutos(produtos);

        System.out.print("\nDigite o código do produto: ");
        int codigoProduto = scanner.nextInt();

        Produto produto = buscarProduto(produtos, codigoProduto);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            scanner.close();
            return;
        }

        System.out.println("\n1 - Entrada");
        System.out.println("2 - Saída");
        System.out.print("Escolha o tipo de movimentação: ");
        int opcao = scanner.nextInt();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            scanner.close();
            return;
        }

        System.out.print("Descrição da movimentação: ");
        String descricaoMovimentacao = scanner.nextLine();

        Movimentacao movimentacao;

        if (opcao == 1) {
            produto.adicionarEstoque(quantidade);
            movimentacao = new Movimentacao(descricaoMovimentacao, "ENTRADA", quantidade);
        } else if (opcao == 2) {
            if (!produto.retirarEstoque(quantidade)) {
                System.out.println("Estoque insuficiente para realizar a saída.");
                scanner.close();
                return;
            }

            movimentacao = new Movimentacao(descricaoMovimentacao, "SAÍDA", quantidade);
        } else {
            System.out.println("Tipo de movimentação inválido.");
            scanner.close();
            return;
        }

        System.out.println("\n=== MOVIMENTAÇÃO REALIZADA ===");
        System.out.println("ID: " + movimentacao.getId());
        System.out.println("Produto: " + produto.getDescricao());
        System.out.println("Tipo: " + movimentacao.getTipo());
        System.out.println("Descrição: " + movimentacao.getDescricao());
        System.out.println("Quantidade movimentada: " + movimentacao.getQuantidade());
        System.out.println("Estoque final: " + produto.getEstoque());

        scanner.close();
    }

    private static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(101, "Caneta Azul", 150));
        produtos.add(new Produto(102, "Caderno Universitário", 75));
        produtos.add(new Produto(103, "Borracha Branca", 200));
        produtos.add(new Produto(104, "Lápis Preto HB", 320));
        produtos.add(new Produto(105, "Marcador de Texto Amarelo", 90));

        return produtos;
    }

    private static Produto buscarProduto(List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }

        return null;
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("\nProdutos disponíveis:");

        for (Produto produto : produtos) {
            System.out.printf(
                "%d - %s | Estoque: %d%n",
                produto.getCodigo(),
                produto.getDescricao(),
                produto.getEstoque()
            );
        }
    }
}
