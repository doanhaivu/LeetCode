/**
 * https://leetcode.com/problems/two-sum/
 */

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

package LeetCode.LeetCodeArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TwoSum {

    @Test
    public void test() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[] {0, 1};

        assertThat(twoSum(nums, target), is(expected));

        nums = new int[] {-1,-2,-3,-4,-5};
        target = -8;
        expected = new int[] {0, 2};
        //assertThat(twoSum(nums, target), is(expected));

        nums = new int[] {3,2,4};
        target = 6;
        expected = new int[] {1, 2};
        assertThat(twoSum(nums, target), is(expected));
    }

    public int[] twoSum(int[] cost, int money) {
        Map<Integer, ArrayList<Integer>> aMap = new HashMap<>();

        int[] ret = new int[2];
        ArrayList<Integer> tmp;
        for (int i = 0; i < cost.length; i++) {
            if (aMap.containsKey(cost[i])) {
                tmp = aMap.get(cost[i]);
            } else {
                tmp = new ArrayList<>();
            }
            tmp.add(i);
            aMap.put(cost[i], tmp);
        }
        Iterator<Integer> anIt = aMap.keySet().iterator();

        int firstIndex = 0;
        int secondIndex = 0;
        ArrayList<Integer> firstIndexes;
        ArrayList<Integer> secondIndexes;
        int aValue;
        while(anIt.hasNext()) {
            aValue = anIt.next();
            if (aMap.containsKey(money-aValue)) {
                firstIndexes = aMap.get(aValue);
                secondIndexes = aMap.get(money-aValue);
                for (Integer i:firstIndexes) {
                    for (Integer j:secondIndexes) {
                        if (i != j) {
                            firstIndex = i < j?i:j;
                            secondIndex = i < j?j:i;
                            break;
                        }
                    }
                }

            }

        }
        ret[0] = firstIndex;
        ret[1] = secondIndex;

        System.out.println(ret[0] +" "+ ret[1]);
        return ret;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j)
                {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    public int[] twoSum3(int[] nums, int target) {
        quickSort(nums, 0, nums.length-1);
        int[] ret = new int[2];
        for (int i = 0; i < nums.length-2; i++) {
            int val = target - nums[i];
            int index = binarySearch(nums, val, i+1, nums.length-1);
            if (index != -1) {
                ret[0] = i;
                ret[1] = index;
                break;
            }
        }
        return ret;
    }

    public int binarySearch(int[] nums, int val, int low, int high) {
        int index = -1;
        int start = low;
        int end = high;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == val)
                return mid;
            if (nums[mid] < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return index;
    }

    public void quickSort(int[] nums, int start, int end) {
        int index = partition(nums, start, end);
        if (start < index-1) {
            quickSort(nums, start, index-1);
        }
        if (index < end) {
            quickSort(nums, index, end);
        }
    }

    public int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int pivot = arr[(start+end)/2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
