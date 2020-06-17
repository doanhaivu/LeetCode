/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order of the
 * remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */

/**
 * https://leetcode.com/problems/longest-common-subsequence/discuss/598557/Summary-of-4-different-solutions
 */

package LeetCode.LeetCodeDP;

import Common.Utilities;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestCommonSubsequence {

    @Test
    public void test() {
        String text1 = "abcde";
        String text2 = "ace";
        assertThat(longestCommonSubsequence(text1, text2), is(3));

        text1 = "abc";
        text2 = "abc";
        assertThat(longestCommonSubsequence(text1, text2), is(3));

        text1 = "abc";
        text2 = "def";
        assertThat(longestCommonSubsequence(text1, text2), is(0));

        text1 = "ezupkr";
        text2 = "ubmrapg";
        assertThat(longestCommonSubsequence(text1, text2), is(2));

        text1 = "oxcpqrsvwf";
        text2 = "shmtulqrypy";
        assertThat(longestCommonSubsequence(text1, text2), is(2));

        text1 = "bsbininm";
        text2 = "jmjkbkjkv";
        assertThat(longestCommonSubsequence(text1, text2), is(1));

        text1 = "ezupkr";
        text2 = "ubmrapg";
        assertThat(longestCommonSubsequence(text1, text2), is(2));

        text1 = "a";
        text2 = "ab";
        assertThat(longestCommonSubsequence(text1, text2), is(1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0 || text1 ==null || text2 == null)
            return 0;
        int[][] arr = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                arr[i][j] = -1;
            }
        }
        int ret = lcs(text1, text2, 0, 0, arr);
        Utilities.print2DArr(arr);
        return ret;
    }

    public int lcs(String text1, String text2, int i, int j, int[][] arr) {
        if (text1.length() == i || text2.length() == j)
            return 0;
        if (arr[i][j] != -1)
            return arr[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return arr[i][j] = 1 + lcs(text1, text2, i+1, j+1, arr);
        } else {
            return arr[i][j] = Math.max(lcs(text1, text2, i+1, j, arr), lcs(text1, text2, i, j+1, arr));
        }
    }
}
