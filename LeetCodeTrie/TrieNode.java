package LeetCode.LeetCodeTrie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public String thisPrefix;
    public Character thisChar;
    public boolean isWord;
    public int value;
}
