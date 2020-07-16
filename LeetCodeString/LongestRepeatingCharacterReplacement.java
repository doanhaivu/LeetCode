package LeetCode.LeetCodeString;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestRepeatingCharacterReplacement {

    /**
     * Solution Tag: Sliding Window
     */
    //TODO time and space complexity
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int max = 0;
        int sameCount = 0;
        int numToChange;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            sameCount = Math.max(sameCount, count[s.charAt(right) - 'A']);
            numToChange = right-left+1-sameCount;
            if (numToChange > k) {
                count[s.charAt(left)- 'A']--;
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(characterReplacement("ABAB", 2), is(4));
        assertThat(characterReplacement("AABABBA", 1), is(4));
    }
}
