package LeetCode.LeetCodeString;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        Map<Character, Integer> aMap = new HashMap<>();
        int length = 0;
        for (int i = 0; i < s.length()-1; i++) {
            aMap.clear();
            aMap.put(s.charAt(i), i);
            for (int j = i+1; j < s.length(); j++) {
                if (!aMap.containsKey(s.charAt(j))) {
                    aMap.put(s.charAt(j), j);
                    if (j-i>length) {
                        length = j-i;
                    }
                }
                else {
                    //aMap.clear();
                    break;
                }
            }
        }
        return length+1;
    }

    @Test
    public void test() {
        String s = "abcabcbb";

        assertThat(lengthOfLongestSubstring(s), is(3));

        s = "bbbbb";
        assertThat(lengthOfLongestSubstring(s), is(1));

        s = "pwwkew";
        assertThat(lengthOfLongestSubstring(s), is(3));

        s = "";
        assertThat(lengthOfLongestSubstring(s), is(0));

        s = "a";
        assertThat(lengthOfLongestSubstring(s), is(1));

        s = "ab";
        assertThat(lengthOfLongestSubstring(s), is(2));

        s = "bb";
        assertThat(lengthOfLongestSubstring(s), is(1));

        s = "jxdlnaaij";
        assertThat(lengthOfLongestSubstring(s), is(6));
    }
}
