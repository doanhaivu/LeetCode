/**
 * https://leetcode.com/problems/house-robber-ii/
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HouseRobberII {

    @Test
    public void test() {
        int[] nums = new int[] {2,3,2};
        assertThat(rob(nums), is(3));

        nums = new int[] {1,2,3,1};
        assertThat(rob(nums), is(4));

        nums = new int[] {6,6,4,8,4,3,3,10};
        assertThat(rob(nums), is(27));
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> aMap = new HashMap<>();
            int[] aNewArr = transform(i, nums);

            int tmp = Math.max(rb(0, aNewArr, aMap, 0), rb(1, aNewArr, aMap, 1));

            if (tmp > sum)
                sum = tmp;
        }
        return sum;
    }

    public int rb(int index, int[] nums, Map<Integer, Integer> aMap, int origin) {
        if (aMap.containsKey(index)) {
            return aMap.get(index);
        }

        int sum = 0;
        int nlength = nums.length;

        if (origin == 0)
            nlength = nums.length-1;

        for (int i = index+2; i < nlength; i++) {
            int tmp = rb(i, nums, aMap, origin);
            if (tmp > sum)
                sum = tmp;
        }

        aMap.put(index, sum+nums[index]);
        return sum + nums[index];
    }

    public int[] transform(int index, int[] nums) {
        int[] ret = new int[nums.length];
        int stopIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+index >= nums.length) {
                stopIndex = i;
                break;
            }
            ret[i] = nums[i+index];
        }

        int anotherIndex = 0;
        for (int i = stopIndex; i < ret.length; i++) {
            ret[i] = nums[anotherIndex];
            anotherIndex++;
        }
        return ret;
    }

    @Test
    public void testTransform() {
        int[] nums = new int[] {0, 1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
            int[] ret = transform(i, nums);
            System.out.println(Arrays.toString(ret));
        }
    }
}
