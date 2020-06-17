/**
 * https://leetcode.com/problems/contains-duplicate/
 */
/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */


package LeetCode.LeetCodeArray;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args){

        int[] nums = new int[] {1,2,3,1};
        System.out.println(containsDuplicate(nums));

        nums = new int[] {1,2,3,4};
        System.out.println(containsDuplicate(nums));

        nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> aMap = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (!aMap.containsKey(nums[i]))
                aMap.put(nums[i], true);
            else
                return true;
        }
        return false;
    }
}
