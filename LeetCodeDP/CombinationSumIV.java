/**
 * https://leetcode.com/problems/combination-sum-iv/
 */

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CombinationSumIV {
    @Test
    public void test() {
        int[] nums = new int[] {1, 2, 3};
        int target = 4;

        assertThat(combinationSum4(nums, target), is(7));

        nums = new int[] {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        target = 10;
        assertThat(combinationSum4(nums, target), is(9));
    }

    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> aMap = new HashMap<>();
        return cs(nums, target, aMap);
    }

    public int cs(int[] nums, int target, Map<Integer, Integer> aMap) {
        if (aMap.containsKey(target))
            return aMap.get(target);
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += cs(nums, target - nums[i], aMap);
        }
        aMap.put(target, count);
        return count;
    }

    /**
     * Time limit exceeded
     * The difference between this solution and the above solution is the exit condition is placed
     * inside the for loop, which is not a good idea since it can't simply return when
     * the condition is reached.
     *
     * Lesson learnt: exit condition for recursive function should be outside of the loop
     */

    public int combinationSum4_2(int[] nums, int target) {
        int ret = 0;
        int[] arr = new int[nums.length];

        canChange(nums, target, arr);

        for (int j = 0; j < arr.length; j++) {
            ret += arr[j];
        }
        System.out.println(Arrays.toString(arr));
        return ret;
    }


    public void canChange(int[] nums, int amount, int[] arr) {
        for (int i = 0; i < nums.length; i++) {

            int remain = amount - nums[i];

            //System.out.println("Amount: " + amount + " Remain: " + remain);

            if (remain == 0) {
                arr[i]++;
            } else if (remain > 0) {
                canChange(nums, remain, arr);
            }
        }
    }

    /*
    public boolean canChange(int index,int[] nums, int amount, int[] arr) {
        if (index >= nums.length)
            return false;

        int div = amount / nums[index];

        System.out.println("nums[index]: " + nums[index] + " amount: " + amount);

        if (div > 0) {
            for (int j = 0; j <= div; j++) {
                int multi = j * nums[index];
                int remain = amount - multi;

                if (remain == 0) {
                    return true;
                } else if (remain > 0) {
                    if(canChange(index+1, nums, remain, arr))
                        arr[index] += 1;
                }
            }
        }
        return false;
    }*/
}
