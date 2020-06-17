/**
 * https://leetcode.com/problems/coin-change/
 */

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoinChange {

    @Test
    public void test() {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        assertThat(coinChange(coins, amount), is(3));

        coins = new int[] {2};
        amount = 3;
        assertThat(coinChange(coins, amount), is(-1));

        coins = new int[] {2};
        amount = 1;
        assertThat(coinChange(coins, amount), is(-1));

        coins = new int[] {186,419,83,408};
        amount = 6249;
        assertThat(coinChange(coins, amount), is(20));

        coins = new int[] {1,2,5,10};
        amount = 18;
        assertThat(coinChange(coins, amount), is(4));


    }

    public int coinChange(int[] coins, int amount) {
        HashMap<String, Integer> aMap = new HashMap<>();
        Arrays.sort(coins);
        return coinChange(0, coins, amount, aMap);
    }


    public int coinChange(int index, int[] coins, int amount, Map<String, Integer> amap) {
        if (amount == 0)
            return 0;
        if (amap.containsKey(Integer.toString(amount)))
            return amap.get(Integer.toString(amount));

        if (index >= 0 && amount > 0 && index < coins.length) {

            int div = amount / coins[index];
            int minCost = Integer.MAX_VALUE;

            for (int i = 0; i <= div; i++) {

                if (amount >= i*coins[index]) {

                    Integer tmp = amount - i*coins[index];
                    int res = coinChange(index + 1, coins, tmp, amap);

                    if (res != -1)
                        minCost = Math.min(minCost, res + i);
                }
            }

            minCost = (minCost == Integer.MAX_VALUE)? -1:minCost;
            amap.put(Integer.toString(amount), minCost);
            return minCost;
        }

        return -1;
    }
}
