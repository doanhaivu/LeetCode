/**
 * https://leetcode.com/problems/house-robber/
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HouseRobber {

    @Test
    public void test() {
        int[] nums = new int[] {1,2,3,1};
        assertThat(rob(nums), is(4));

        nums = new int[] {2,7,9,3,1};
        assertThat(rob(nums), is(12));

        nums = new int[] {2,1,1,2};
        assertThat(rob(nums), is(4));

        nums = new int[] {1,3,1,3,100};
        assertThat(rob(nums), is(103));

        nums = new int[] {4,1,2,7,5,3,1};
        assertThat(rob(nums), is(14));
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        HashMap<Integer, Integer> aMap = new HashMap<>();

        return Math.max(rb(0, nums, aMap), rb(1, nums, aMap));
    }

    public int rb(int index, int[] nums, Map<Integer, Integer> aMap) {
        if (aMap.containsKey(index)) {
            return aMap.get(index);
        }

        int sum = 0;

        for (int i = index+2; i < nums.length; i++) {
            int tmp = rb(i, nums, aMap);
            if (tmp > sum)
                sum = tmp;
        }

        aMap.put(index, sum+nums[index]);

        return sum + nums[index];
    }

    /**
     * Nice solution
     * http://www.crazyforcode.com/house-robber-dynamic-programming/
     */

    public int steal(int[] num) {
        if(num==null || num.length==0){
            return 0;
        }
        int[] dp= new int[num.length+1];
        dp[0]=0;
        dp[1]=num[0];
        for(int i=2; i<=num.length;i++){
            dp[i] =Math.max(dp[i-1],num[i-1]+dp[i-2]);
        }
        return dp[num.length];
    }

    /**
     * Nice solution O(N)
     * https://leetcode.com/problems/house-robber/discuss/55695/JAVA-DP-Solution-O(n)-runtime-and-O(1)-space-with-inline-comment
     */

    public int robON(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

    /**
     * Nice solution
     * https://leetcode.com/problems/house-robber/discuss/55693/C-1ms-O(1)space-very-simple-solution
     */
    /*
    #define max(a, b) ((a)>(b)?(a):(b))
    int rob(int num[], int n) {
        int a = 0;
        int b = 0;

        for (int i=0; i<n; i++)
        {
            if (i%2==0)
            {
                a = max(a+num[i], b);
            }
            else
            {
                b = max(a, b+num[i]);
            }
        }

        return max(a, b);
    }*/
}
