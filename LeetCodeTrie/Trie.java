package LeetCode.LeetCodeTrie;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    @Test
    public void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        assertThat(trie.search("apple"), is(true));
        assertThat(trie.search("app"), is(false));
        assertThat(trie.startsWith("app"), is(true));
        trie.insert("app");
        assertThat(trie.search("app"), is(true));
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        TrieNode prev;
        int i = 0;
        for (; i < word.length(); i++) {
            prev = tmp;
            tmp = tmp.children.get(word.charAt(i));
            if (tmp == null) {
                tmp = new TrieNode();
                prev.children.put(word.charAt(i), tmp);
            }
        }
        tmp.isWord = true;
        tmp.thisChar = word.charAt(i-1);
        tmp.thisPrefix = word.substring(0,i);
    }

    public void insert(String prefix, int value) {
        TrieNode tmp = root;
        TrieNode prev;
        int i = 0;
        for (; i < prefix.length(); i++) {
            prev = tmp;
            tmp = tmp.children.get(prefix.charAt(i));
            if (tmp == null) {
                tmp = new TrieNode();
                prev.children.put(prefix.charAt(i), tmp);
            }
        }
        tmp.value = value;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.children.get(word.charAt(i));
            if (tmp == null)
                return false;
        }
        return tmp.isWord;
    }

    public boolean searchWithRegularExpression(String word) {
        return searchRecur(root, word);
    }

    //Lesson learnt: The recursion call inside the loop(note #1) and the return condition outside of the loop (note #2)
    public boolean searchRecur(TrieNode tmp, String word) {
        //System.out.println("Searching at: " + tmp.thisChar + " with word: " + word );

        for (int i = 0; i < word.length(); i++) {
            Character aChar = word.charAt(i);
            if (aChar.equals('.')) {
                if (tmp.children.size() > 0) {
                    for(TrieNode aTrie:tmp.children.values()) {
                        //note #1: if true then return, else do another recursion call
                        if(searchRecur(aTrie, word.substring(i+1)))
                            return true;
                    }
                    //note #2: all the recursion call failed then return fail, no need to continue the else below (note #3)
                    return false;
                } else return false;
            } else {//note #3
                tmp = tmp.children.get(aChar);
                if (tmp == null)
                    return false;
            }
        }
        return tmp.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            tmp = tmp.children.get(prefix.charAt(i));
            if (tmp == null)
                return false;
        }
        return true;
    }

    public int sum(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmp != null)
                tmp = tmp.children.get(prefix.charAt(i));
        }

        return sumRecur(tmp);
    }

    public int sumRecur(TrieNode aNode) {
        if (aNode == null) return 0;
        int tmpSum = 0;
        for (TrieNode tmp:aNode.children.values()) {
            tmpSum += sumRecur(tmp);
        }
        return aNode.value + tmpSum;
    }

    public String replaceWords(String sentence) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            TrieNode tmp = root;
            for (int j = 0; j < words[i].length(); j++) {
                tmp = tmp.children.get(words[i].charAt(j));
                if (tmp == null)
                    break;
                if(tmp.isWord) {
                    words[i] = tmp.thisPrefix;
                    break;
                }

            }
        }

        String ret = "";
        for (int i = 0; i < words.length; i++) {
            ret += words[i];
            if (i != words.length-1) ret += " ";
        }
        return ret;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
