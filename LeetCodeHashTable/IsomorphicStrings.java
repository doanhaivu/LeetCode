package LeetCode.LeetCodeHashTable;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> aMap = new HashMap<>();
        Set<Character> aSet = new HashSet<>();
        Character tmp;
        for (int i = 0; i < s.length(); i++) {
            if (!aMap.containsKey(s.charAt(i))) {
                if (aSet.add(t.charAt(i)))
                    aMap.put(s.charAt(i), t.charAt(i));
                else return false;
            }
            else {
                tmp = aMap.get(s.charAt(i));
                if (tmp != t.charAt(i))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isIsomorphic("egg", "add"), is(true));
        assertThat(isIsomorphic("foo", "bar"), is(false));
        assertThat(isIsomorphic("paper", "title"), is(true));
        assertThat(isIsomorphic("ab", "aa"), is(false));
    }
}
