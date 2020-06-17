/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
 * https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
 */

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 */
package LeetCode.LeetCodeBinary;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SumOfTwoIntegers {

    @Test
    public void test() {
        assertThat(getSum(1, 2), is(3));
        assertThat(getSum(-2, 3), is(1));
    }
// 1 + 3
    //0000  0000    0000    0000    0000    0000    0000    0001    a
    //0000  0000    0000    0000    0000    0000    0000    0011    b

    //0000  0000    0000    0000    0000    0000    0000    0010    carry

    //0000  0000    0000    0000    0000    0000    0000    0010    a
    //0000  0000    0000    0000    0000    0000    0000    0010    b

    //0000  0000    0000    0000    0000    0000    0000    0100    carry

    //0000  0000    0000    0000    0000    0000    0000    0000    a
    //0000  0000    0000    0000    0000    0000    0000    0100    b

    //0000  0000    0000    0000    0000    0000    0000    0000    carry

    //0000  0000    0000    0000    0000    0000    0000    0100    a
    //0000  0000    0000    0000    0000    0000    0000    0000    b

// 1 + 2
    //0000  0000    0000    0000    0000    0000    0000    0001    a
    //0000  0000    0000    0000    0000    0000    0000    0010    b

    //0000  0000    0000    0000    0000    0000    0000    0000    carry

    //0000  0000    0000    0000    0000    0000    0000    0011    sum

    public int getSum(int a, int b) {
        if(a == 0) {
            return b;
        }

        if(b == 0) {
            return a;
        }

        int carry = 0;

        while(b != 0) {

            // If both bits are 1, we set the bit to the left (<<1) to 1 -- this is the carry step
            carry = (a & b) << 1;

            // If both bits are 1, this will give us 0 (we will have a carry from the step above)
            // If only 1 bit is 1, this will give us 1 (there is nothing to carry)
            a = a ^ b;

            b = carry;
        }

        return a;
    }
}
