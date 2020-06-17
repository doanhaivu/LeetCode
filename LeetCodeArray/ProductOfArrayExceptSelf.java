/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 */
/** SOLUTION
 * Given numbers [2, 3, 4, 5], regarding the third number 4,
 * the product of array except 4 is 2*3*5 which consists of two parts:
 * left 2*3 and right 5.
 * The product is left*right. We can get lefts and rights:
 *
 * Numbers:     2    3    4     5
 * Lefts:            2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5
 * Let’s fill the empty with 1:
 *
 * Numbers:     2    3    4     5
 * Lefts:       1    2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5     1
 * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
 *
 * We store lefts in result array.
 * If we allocate a new array for rights.
 * The space complexity is O(n).
 * To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
 */

package LeetCode.LeetCodeArray;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        int[] ret = productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        // num: 1       2       3       4

        int tmp = 1;
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            tmp *= nums[i-1];
            ret[i] = tmp;
        }
        // ret: 1       1       1*2     1*2*3
        // ret: 2*3*4   1*3*4   1*2*4   1*2*3

        tmp = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            tmp *= nums[i+1];
            ret[i] *= tmp;
        }
        return ret;
    }
}
