import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE = "musicas.txt";

    public static void main(String[] args) {
        MusicTrie trie = new MusicTrie();
        Scanner scanner = new Scanner(System.in);

        carregarDados(trie);

        boolean running = true;
        while (running) {
            System.out.println("1. Buscar Música (Auto-complete)");
            System.out.println("2. Inserir Nova Música");
            System.out.println("3. Deletar Música");
            System.out.println("4. Listar Todas as Músicas (Lista Plana)");
            System.out.println("5. Visualizar Estrutura da Árvore (Trie View)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    realizarBusca(trie, scanner);
                    break;
                case "2":
                    System.out.print("Digite o nome completo (Banda - Música): ");
                    String novaMusica = scanner.nextLine();
                    trie.insertSmart(novaMusica);
                    break;
                case "3":
                    System.out.print("Digite o nome da música para remover: ");
                    String musicaRemover = scanner.nextLine();
                    trie.deleteSmart(musicaRemover);
                    break;
                case "4":
                    trie.printAll();
                    break;
                case "5":
                    trie.printVisual();
                    break;
                case "6":
                    System.out.println("Encerrando sistema...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void realizarBusca(MusicTrie trie, Scanner scanner) {
        System.out.print("\nDigite sua busca (prefixo): ");
        String termo = scanner.nextLine();

        List<String> resultados = trie.autoComplete(termo);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            System.out.println("Sugestões encontradas (" + resultados.size() + "):");
            for (String s : resultados) {
                System.out.println("   -> " + s);
            }
        }
    }

    private static void carregarDados(MusicTrie trie) {
        System.out.println("Carregando base de dados...");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String linha;
            int count = 0;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    trie.insertSmart(linha);
                    count++;
                }
            }
            System.out.println(count + " músicas carregadas com sucesso!.");
        } catch (IOException e) {
            System.out.println(FILE + " não encontrado ou vazio. Iniciando vazia.");
        }
    }
}