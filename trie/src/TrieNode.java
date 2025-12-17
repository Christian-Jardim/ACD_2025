import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    String realName;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
        this.realName = null;
    }
}