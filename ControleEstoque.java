Claro, aqui está o código sem os comentários:

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
    private static Map<String, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Exibir Estoque");
            System.out.println("4 - Sair");
            int opcao = scanner.nextInt();

            if (opcao == 4) {
                System.out.println("Saindo do programa...");
                break;
            }

            if (opcao == 1) {
                adicionarProduto(scanner);
            } else if (opcao == 2) {
                venderProduto(scanner);
            } else if (opcao == 3) {
                exibirEstoque();
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();

        if (estoque.containsKey(nome)) {
            quantidade += estoque.get(nome);
        }

        estoque.put(nome, quantidade);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void venderProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade a ser vendida:");
        int quantidade = scanner.nextInt();

        if (estoque.containsKey(nome)) {
            int estoqueAtual = estoque.get(nome);
            if (estoqueAtual >= quantidade) {
                estoque.put(nome, estoqueAtual - quantidade);
                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque!");
            }
        } else {
            System.out.println("Produto não encontrado em estoque!");
        }
    }

    private static void exibirEstoque() {
        System.out.println("Estoque atual:");
        for (String produto : estoque.keySet()) {
            int quantidade = estoque.get(produto);
            System.out.println(produto + ": " + quantidade);
        }
    }
}
```