/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
package LeetCode.LeetCodeArray;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    @org.junit.jupiter.api.Test
    void testFindMin() {
        int[] nums = new int[] {8,9,10,11,12,1,2,3,4,5,6,7};
        Assertions.assertEquals(1, findMin(nums));

        nums = new int[] {4,5,6,7,0,1,2};
        Assertions.assertEquals(0, findMin(nums));

        nums = new int[] {2, 1};
        Assertions.assertEquals(1, findMin(nums));

        nums = new int[] {1, 2};
        Assertions.assertEquals(1, findMin(nums));

        nums = new int[] {1, 2, 3, 4 ,5};
        Assertions.assertEquals(1, findMin(nums));

        nums = new int[] {4, 5, 6, 0, 1, 2, 3};
        Assertions.assertEquals(0, findMin(nums));

    }

    @org.junit.jupiter.api.Test
    void testSearch() {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        //Assertions.assertEquals(4, search(nums, 0));

        nums = new int[] {4,5,6,7,0,1,2};
        //Assertions.assertEquals(-1, search(nums, 3));

        nums = new int[] {4,5,6,7,0,1,2};
        //Assertions.assertEquals(1, search(nums, 5));

        nums = new int[] {1};
        //Assertions.assertEquals(0, search(nums, 1));

        nums = new int[] {5, 1, 3};
        Assertions.assertEquals(2, search(nums, 3));

        nums = new int[] {1, 3};
        Assertions.assertEquals(0, search(nums, 1));
    }

    public int findMin(int nums[]) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);
        int low = 0;
        int high = nums.length-1;
        int mid = low + (high-low)/2;
        while (low <= high) {
            if (mid == nums.length-1)
                return nums[0];
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } else {
                if (nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            mid = low + (high-low)/2;
        }
        return nums[mid+1];
    }

    public int binarySearch(int nums[], int target, int start, int end) {
        int index = -1;
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target)
                return mid;
            else {
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }

    public int search(int nums[], int target) {
        int index = -1;
        int low = 0;
        int high = nums.length-1;
        int mid = low + (high-low)/2;
        if (nums.length == 1)
            return nums[0]==target?0:-1;
        System.out.println(Arrays.toString(nums));

        while (low <= high) {
            System.out.println("Mid: " + mid + " Low: " + low + " High: " + high);
            if (mid == nums.length-1){
                break;//index = -1
            }
            if (nums[mid] > nums[mid+1]) {
                index = mid + 1;
                break;
            }
            else {
                if (nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            mid = low + (high-low)/2;
        }
        if (index != -1) {
            if (nums[index] == target)
                return index;
            else {
                if (nums[0] > target) {
                    return binarySearch(nums, target, index+1, nums.length-1);
                } else {
                    return binarySearch(nums, target, 0, index-1);
                }
            }
        }
        else {
            return binarySearch(nums, target, 0, nums.length-1);
        }
    }
}
