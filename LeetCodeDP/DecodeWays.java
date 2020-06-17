/**
 * https://leetcode.com/problems/decode-ways/
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DecodeWays {

    @Test
    public void test() {
        String s = "12";
        assertThat(numDecodings(s), is(2));

        s = "226";
        assertThat(numDecodings(s), is(3));

        s = "0";
        assertThat(numDecodings(s), is(0));
    }

    public int numDecodings(String s) {
        HashMap<String, String> aMap = new HashMap<>();

        int i = 1;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            aMap.put(Integer.toString(i), new String(new char[] {alphabet}));
            i++;
        }

        if (s.length() == 0) return 0;

        HashMap<String, Integer> tmpMap = new HashMap<>();

        return decode(s, aMap, tmpMap);
    }

    public int decode(String s,  HashMap<String, String> aMap, HashMap<String, Integer> tmpMap) {
        if (tmpMap.containsKey(s))
            return tmpMap.get(s);
        if (s.length() == 1) {
            if (aMap.containsKey(s))
                return 1;
            else return 0;
        }

        int count = 0;

        String s1 = s.substring(0, 1);
        String s2 = s.substring(0, 2);

        if (aMap.containsKey(s1)) {
            String newString1 = s.substring(1);
            if (newString1.length() == 0)
                count += 1;
            else count += decode(newString1, aMap, tmpMap);
        }

        if (aMap.containsKey(s2)) {
            String newString2 = s.substring(2);
            if (newString2.length() == 0)
                count += 1;
            else
                count += decode(newString2, aMap, tmpMap);
        }

        tmpMap.put(s, count);
        return count;
    }

    /**
     * More Reference
     *
     * https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
     * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
     * https://leetcode.com/problems/decode-ways/discuss/30522/Java-2ms-DP-solution-with-detailed-explanation-and-inline-comments
     *
     */
}
