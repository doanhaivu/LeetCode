package LeetCode.LeetCodeString;

import Common.Utilities;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s.length() <= 1)
            return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        int retStart=0;
        int retEnd=0;
        int length = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
                if (dp[j][i]) {
                    if (i-j+1 > length) {
                        length = i-j+1;
                        retStart = j;
                        retEnd = i;
                    }
                }
            }
        }

        return s.substring(retStart, retEnd+1);
    }

    @Test
    public void test() {
        String s = "babad";
        assertThat(longestPalindrome(s), is("bab"));

        s = "cbbd";
        assertThat(longestPalindrome(s), is("bb"));
    }
}
