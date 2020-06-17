/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

package LeetCode.LeetCodeArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,-2,4};
        //System.out.println(maxProduct(nums));

        nums = new int[] {-2,0,-1, 2};
        System.out.println(maxProd(nums));

        nums = new int[] {-4,-3};
        //System.out.println(maxProduct(nums));

        nums = new int[] {0,2};
        //System.out.println(maxProduct(nums));

        nums = new int[] {-2,3,-4};
        //System.out.println(maxProduct(nums));

        nums = new int[] {3,-1,4};
        //System.out.println(maxProduct(nums));

        nums = new int[] {-1,-2,-9,-6};
        //System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxhere = 1;
        int minhere = 1;

        for (int i = 0; i < nums.length; i++) {
            int tmpmax = maxhere*nums[i];
            int tmpmin = minhere*nums[i];
            maxhere = Math.max(nums[i], Math.max(tmpmax, tmpmin));
            minhere = Math.min(nums[i], Math.min(tmpmax, tmpmin));
            max = Math.max(max, maxhere);

            System.out.println("tmpmax: " + tmpmax + " tmpMin: " + tmpmin + " maxhere: " + maxhere + " minhere: " +minhere);
        }

        return max;
    }

    public static int maxProd(int[] nums) {
        //-2        0       -1      2
        //-2        0       0       0    tmpmax
        //-2        0       0       -2    tmpmin
        //-2        0       0       2    maxhere
        //-2        0      -1       -2   minhere

        int max = Integer.MIN_VALUE;
        int maxhere = 1;
        int minhere = 1;
        int tmpmax = 1;
        int tmpmin = 1;
        for (int i = 0; i < nums.length; i++) {
            tmpmax = maxhere*nums[i];
            tmpmin = minhere*nums[i];
            maxhere = Math.max(nums[i], Math.max(tmpmax, tmpmin));
            minhere = Math.min(nums[i], Math.min(tmpmax, tmpmin));
            max = Math.max(max, maxhere);
            System.out.println("tmpmax: " + tmpmax + " tmpMin: " + tmpmin + " maxhere: " + maxhere + " minhere: " +minhere);
        }
        return max;
    }

    @org.junit.jupiter.api.Test
    void maxProductTest() {
        int[] nums = new int[] {2,3,-2,4};
        assertEquals(6, maxProduct(nums));

        nums = new int[] {-2,0,-1, 2};
        //assertEquals(2, maxProduct(nums));

        nums = new int[] {-4,-3};
        //assertEquals(12, maxProduct(nums));

        nums = new int[] {0,2};
        //assertEquals(2, maxProduct(nums));

        nums = new int[] {-2,3,-4};
        ///assertEquals(24, maxProduct(nums));

        nums = new int[] {3,-1,4};
        //assertEquals(4, maxProduct(nums));

        nums = new int[] {2,-5,-2,-4,3};
        //assertEquals(24, maxProduct(nums));

        nums = new int[] {-1,-2,-9,-6};
        //assertEquals(108, maxProduct(nums));

        nums = new int[] {1,2,-1,-2,2,1,-2,1,4,-5,4};
        //assertEquals(1280, maxProduct(nums));
    }

}
