package LeetCode.LeetCodeTrie;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WordDictionary {
    public Trie thisTrie;

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        thisTrie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return thisTrie.searchWithRegularExpression(word);
    }

    @Test
    public void test() {
        WordDictionary wd = new WordDictionary();
        wd.thisTrie = new Trie();

        wd.addWord("a");
        wd.addWord("a");

        assertThat(wd.search("."), is(true));
        assertThat(wd.search("a"), is(true));
        assertThat(wd.search("aa"), is(false));
        assertThat(wd.search("a"), is(true));
        assertThat(wd.search(".a"), is(false));
        assertThat(wd.search("a."), is(false));

        wd = new WordDictionary();
        wd.thisTrie = new Trie();

        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");

        assertThat(wd.search("a"), is(false));
        assertThat(wd.search(".at"), is(false));

        wd.addWord("bat");

        assertThat(wd.search(".at"), is(true));
        assertThat(wd.search("an."), is(true));
        assertThat(wd.search("a.d."), is(false));
        assertThat(wd.search("b."), is(false));
        assertThat(wd.search("a.d"), is(true));
        assertThat(wd.search("."), is(false));
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
