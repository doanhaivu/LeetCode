package LeetCode.LeetCodeTrie;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReplaceWords {
    public Trie thisTrie;

    public String replaceWords(List<String> dict, String sentence) {
        for(String aString:dict) {
            thisTrie.insert(aString);
        }
        return thisTrie.replaceWords(sentence);
    }

    @Test
    public void test() {
        ReplaceWords rw = new ReplaceWords();
        rw.thisTrie = new Trie();

        String[] dict = new String[] {"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        assertThat(rw.replaceWords(Arrays.asList(dict) , sentence), is(expected) );
    }
}
