package LeetCode.LeetCodeString;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s.length()==0)
            return 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i,j+1)))
                    ret++;
            }
        }

        return ret;
    }

    public boolean isPalindrome(String s) {
        //System.out.println(s);
        int i = 0;
        int j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "abc";
        assertThat(countSubstrings(s), is(3));

        s = "aaa";
        assertThat(countSubstrings(s), is(6));
    }
}
