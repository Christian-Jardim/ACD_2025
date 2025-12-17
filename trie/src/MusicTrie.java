import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class MusicTrie {
    private TrieNode root;

    public MusicTrie() {
        root = new TrieNode();
    }

    /*public void insert(String music) {
        TrieNode current = root;
        // converte para minúsculo para criar o caminho na árvore
        String normalizedMusic = music.toLowerCase();

        for (char ch : normalizedMusic.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
        current.realName = music;
    }*/


    public void insertSmart(String fullText) {
        if (fullText == null || fullText.isEmpty()) return;

        insertCleaned(fullText, fullText);

        // nome da Música (Pós-Hífen)
        if (fullText.contains(" - ")) {
            String songOnly = fullText.substring(fullText.indexOf(" - ") + 3);
            insertCleaned(songOnly, fullText);
        }
    }

    // Limpa a chave (tira simbolos) mas mantém o originalData intacto
    private void insertCleaned(String rawKey, String originalData) {
        String key = rawKey.trim();

        key = key.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

        if (!key.isEmpty()) {
            insertCore(key, originalData);
        }
    }

    // Inserção real na árvore
    private void insertCore(String key, String originalName) {
        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
        current.realName = originalName;
    }



    public List<String> autoComplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;

        // Remove caracteres especiais da busca também, para casar com as chaves limpas
        String normalizedPrefix = prefix.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

        // Navega até o nó do prefixo
        for (char ch : normalizedPrefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return results; // Prefixo não existe
            }
            current = current.children.get(ch);
        }

        // Coleta recursivamente
        collectAllWords(current, results);
        return results;
    }

    private void collectAllWords(TrieNode node, List<String> results) {
        if (node.isEndOfWord) {
            // Evita adicionar a mesma música duas vezes na lista de sugestões
            if (!results.contains(node.realName)) {
                results.add(node.realName);
            }
        }

        for (TrieNode child : node.children.values()) {
            collectAllWords(child, results);
        }
    }



    public void deleteSmart(String fullText) {
        // deleta a chave completa
        deleteCleaned(fullText);

        // deleta a parte pós-hífen
        if (fullText.contains(" - ")) {
            String songOnly = fullText.substring(fullText.indexOf(" - ") + 3);
            deleteCleaned(songOnly);
        }
    }

    private void deleteCleaned(String rawKey) {
        String key = rawKey.trim().replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        if (!key.isEmpty()) {
            deleteCore(root, key, 0);
        }
    }

    private boolean deleteCore(TrieNode current, String key, int index) {
        if (index == key.length()) {
            if (!current.isEndOfWord) {
                return false; // A palavra n existia
            }
            current.isEndOfWord = false;
            current.realName = null;

            // Se não tem filhos, esse nó pode ser deletado pelo pai
            return current.children.isEmpty();
        }

        char ch = key.charAt(index);
        TrieNode node = current.children.get(ch);

        if (node == null) {
            return false; // Caminho não existe
        }

        boolean shouldDeleteChild = deleteCore(node, key, index + 1);

        if (shouldDeleteChild) {
            current.children.remove(ch);

            // Retorna true (pode deletar este nó também) se: 1. Não é fim de outra palavra E 2. Não tem mais filhos
            return !current.isEndOfWord && current.children.isEmpty();
        }

        return false;
    }



    public void printAll() {
        // Set para evitar duplicatas (já que a mesma música aponta para vários caminhos)
        Set<String> uniqueMusics = new HashSet<>();
        collectUniqueWords(root, uniqueMusics);

        if (uniqueMusics.isEmpty()) {
            System.out.println("  (O banco de dados está vazio)");
        } else {
            //lista para poder ordenar alfabeticamente
            List<String> sortedList = new ArrayList<>(uniqueMusics);
            Collections.sort(sortedList);

            System.out.println("=== LISTA DE MÚSICAS (" + sortedList.size() + ") ===");
            for (String music : sortedList) {
                System.out.println("- " + music);
            }
        }
    }

    private void collectUniqueWords(TrieNode node, Set<String> uniqueMusics) {
        if (node.isEndOfWord && node.realName != null) {
            uniqueMusics.add(node.realName);
        }
        for (TrieNode child : node.children.values()) {
            collectUniqueWords(child, uniqueMusics);
        }
    }

    public void printVisual() {
        if (root.children.isEmpty()) {
            System.out.println("(Árvore vazia)");
            return;
        }
        System.out.println("ROOT");
        printVisualRecursive(root, "", true);
    }

    private void printVisualRecursive(TrieNode node, String prefix, boolean isTail) {
        // pega todas as chaves (letras) deste nó e ordena alfabeticamente
        List<Character> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys);

        // itera sobre cada filho
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            boolean isLastChild = (i == keys.size() - 1);
            TrieNode child = node.children.get(ch);

            // Monta a string visual
            System.out.print(prefix + (isLastChild ? "└── " : "├── ") + ch);

            // Se for fim de palavra, mostra qual música está ancorada aqui
            if (child.isEndOfWord) {
                System.out.print("  [MUSIC: " + child.realName + "]");
            }
            System.out.println();

            printVisualRecursive(child, prefix + (isLastChild ? "    " : "│   "), isLastChild);
        }
    }
}