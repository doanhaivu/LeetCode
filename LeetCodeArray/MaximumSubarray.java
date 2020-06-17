/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */


package LeetCode.LeetCodeArray;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int residual = 0;
        for (int i = 0; i < nums.length; i++) {
            residual += nums[i];
            if (residual > sum)
                sum = residual;
            if (residual < 0)
                residual = 0;
        }
        return sum;
    }

    public static int method1(int[] arr) {
        //-2    1   -3  4   -1  2   1   -5  4
        //-2    1   1   4   4   5   6   6   6
        //0     1   0   4   3   5   6   1   5
        int sum = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i];
            if (tmp > sum)
                sum = tmp;
            if (tmp < 0)
                tmp = 0;
        }
        return sum;

    }
}
