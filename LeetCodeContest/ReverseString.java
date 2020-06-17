package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReverseString {
    public char[] reverseString(char[] s) {
        char tmp;
        int j = s.length-1;
        for (int i = 0; i < s.length; i++) {
            if (i > j)
                break;
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            j--;
        }
        return s;
    }

    @Test
    public void testReverseString() {
        char[] input = new char[] {'h','e','l','l','o'};
        char[] expected = new char[] {'o','l','l','e','h'};

        assertThat(reverseString(input), is(expected));

        input = new char[] {'H','a','n','n','a','h'};
        expected = new char[] {'h','a','n','n','a','H'};

        assertThat(reverseString(input), is(expected));
    }
}
