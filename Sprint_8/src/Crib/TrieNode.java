package Crib;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private final Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }
}
