package LeetCode.LeetCodeHashTable;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1) return true;
        int tmp = 0;
        int mod = 0;
        Set<Integer> aSet = new HashSet<>();
        while (aSet.add(n)) {
            while (n > 0) {
                mod = n%10;
                n = n / 10;
                System.out.print(" div: " + mod);
                tmp += mod * mod;
            }
            System.out.println();
            System.out.println("tmp:" + tmp);
            if (tmp == 1)
                return true;
            n = tmp;
            tmp = 0;
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(isHappy(19), is(true));
    }
}
