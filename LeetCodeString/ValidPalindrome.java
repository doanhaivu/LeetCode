package LeetCode.LeetCodeString;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        //System.out.println(s.length());

        int i = 0;
        int j = s.length()-1;
        while (i <= j) {
            //System.out.println("i: " + i + " : " + s.charAt(i) + " j: " + j +  " : " + s.charAt(j));
            while (!isLetterOrDigit(s.charAt(i)) && i < s.length()-1)
                i++;
            while (!isLetterOrDigit(s.charAt(j)) && j > 0)
                j--;
            if (i <= j) {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                    i++;
                    j--;
                    continue;
                } else return false;
            }
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    @Test
    public void test() {
        //assertThat(isPalindrome("A man, a plan, a canal: Panama"), is(true));
        //assertThat(isPalindrome("race a car"), is(false));
        //assertThat(isPalindrome("abz cba"), is(false));
        //assertThat(isPalindrome(" "), is(true));
        assertThat(isPalindrome(".,"), is(true));
    }
}
