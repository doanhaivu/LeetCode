/**
 * https://leetcode.com/problems/climbing-stairs/
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ClimbingStairs {
    @Test
    public void test() {
        //assertThat(climbStairs(2), is(2));
        //assertThat(climbStairs(3), is(3));
        assertThat(climbMemoization(2), is(2));
        assertThat(climbMemoization(3), is(3));
    }

    public int climbStairs(int n) {
        return climbRecur(0, n);
    }

    public int climbRecur(int current, int n) {
        if (current >= n)
            return 0;
        if (current == n -1)
            return 1;
        if (current == n -2)
            return 2;
        return climbRecur(current+1, n) + climbRecur(current+2,n);
     }

     public int climbMemoization(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (i == 2)
                arr[i] = 2;
            else
                arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
     }
}
