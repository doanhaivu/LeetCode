/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */

/**
 * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 */

package LeetCode.LeetCodeDP;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestIncreasingSubsequence {

    @Test
    public void test() {
        int[] nums = new int[] {10,9,2,5,3,7,101,1,18,19};
        assertThat(lengthOfLIS(nums), is(5));

        nums = new int[] {2, 2};
        //assertThat(lengthOfLIS(nums), is(1));

        nums = new int[] {};
        //assertThat(lengthOfLIS(nums), is(0));

        nums = new int[] {3,1,2};
        //assertThat(lengthOfLIS(nums), is(2));
    }

    public int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public int lengthOfLIS2(int[] nums) {
        return LongestIncreasingSubsequenceLength(nums, nums.length);
    }

    public int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
        if (size <= 1)
            return size;

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] tailTbl = new int[nums.length];
        tailTbl[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tailTbl[0]) {
                tailTbl[0] = nums[i];
            } else if (nums[i] > tailTbl[len-1]) {
                tailTbl[len] = nums[i];
                len++;
            } else {
                int index = CeilIndex(tailTbl, -1, len-1, nums[i]);
                tailTbl[index] = nums[i];
            }
        }
        return len;
    }
}

/**
 * Example 1
 */

/**
 * 10,9,2,5,3,7,101,1,18,19
 *
 * 1. If A[i] is smallest among all end
 *    candidates of active lists, we will start
 *    new active list of length 1.
 * 2. If A[i] is largest among all end candidates of
 *   active lists, we will clone the largest active
 *   list, and extend it by A[i].
 *
 * 3. If A[i] is in between, we will find a list with
 *   largest end element that is smaller than A[i].
 *   Clone and extend this list by A[i]. We will discard all
 *   other lists of same length as that of this modified list.
 *
 * A[0] = 10
 * 	10
 * A[1] = 9
 * 	9
 * A[2] = 2
 * 	2
 * A[3] = 5
 * 	2
 * 	2, 5
 * A[4] = 3
 * 	2
 * 	2, 3
 * A[5] = 7
 * 	2
 * 	2, 3
 * 	2, 3, 7
 * A[6] = 101
 * 	2
 * 	2, 3
 * 	2, 3, 7,
 * 	2, 3, 7, 101
 * A[7] = 1
 * 	1
 * 	2, 3
 * 	2, 3, 7,
 * 	2, 3, 7, 101
 * A[7] = 18
 * 	1
 * 	2, 3
 * 	2, 3, 7
 * 	2, 3, 7, 18
 * A[7] = 19
 * 	1
 * 	2, 3
 * 	2, 3, 7
 * 	2, 3, 7, 18
 * 	2, 3, 7, 18, 19
 */

/**
 * Example 2
 */
/**
 * {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}
 *
 * A[0] = 0. Case 1. There are no active lists, create one.
 * 0.
 * -----------------------------------------------------------------------------
 * A[1] = 8. Case 2. Clone and extend.
 * 0.
 * 0, 8.
 * -----------------------------------------------------------------------------
 * A[2] = 4. Case 3. Clone, extend and discard.
 * 0.
 * 0, 4.
 * 0, 8. Discarded
 * -----------------------------------------------------------------------------
 * A[3] = 12. Case 2. Clone and extend.
 * 0.
 * 0, 4.
 * 0, 4, 12.
 * -----------------------------------------------------------------------------
 * A[4] = 2. Case 3. Clone, extend and discard.
 * 0.
 * 0, 2.
 * 0, 4. Discarded.
 * 0, 4, 12.
 * -----------------------------------------------------------------------------
 * A[5] = 10. Case 3. Clone, extend and discard.
 * 0.
 * 0, 2.
 * 0, 2, 10.
 * 0, 4, 12. Discarded.
 * -----------------------------------------------------------------------------
 * A[6] = 6. Case 3. Clone, extend and discard.
 * 0.
 * 0, 2.
 * 0, 2, 6.
 * 0, 2, 10. Discarded.
 * -----------------------------------------------------------------------------
 * A[7] = 14. Case 2. Clone and extend.
 * 0.
 * 0, 2.
 * 0, 2, 6.
 * 0, 2, 6, 14.
 * -----------------------------------------------------------------------------
 * A[8] = 1. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 2. Discarded.
 * 0, 2, 6.
 * 0, 2, 6, 14.
 * -----------------------------------------------------------------------------
 * A[9] = 9. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 2, 6.
 * 0, 2, 6, 9.
 * 0, 2, 6, 14. Discarded.
 * -----------------------------------------------------------------------------
 * A[10] = 5. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 1, 5.
 * 0, 2, 6. Discarded.
 * 0, 2, 6, 9.
 * -----------------------------------------------------------------------------
 * A[11] = 13. Case 2. Clone and extend.
 * 0.
 * 0, 1.
 * 0, 1, 5.
 * 0, 2, 6, 9.
 * 0, 2, 6, 9, 13.
 * -----------------------------------------------------------------------------
 * A[12] = 3. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 1, 3.
 * 0, 1, 5. Discarded.
 * 0, 2, 6, 9.
 * 0, 2, 6, 9, 13.
 * -----------------------------------------------------------------------------
 * A[13] = 11. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 1, 3.
 * 0, 2, 6, 9.
 * 0, 2, 6, 9, 11.
 * 0, 2, 6, 9, 13. Discarded.
 * -----------------------------------------------------------------------------
 * A[14] = 7. Case 3. Clone, extend and discard.
 * 0.
 * 0, 1.
 * 0, 1, 3.
 * 0, 1, 3, 7.
 * 0, 2, 6, 9. Discarded.
 * 0, 2, 6, 9, 11.
 * ----------------------------------------------------------------------------
 * A[15] = 15. Case 2. Clone and extend.
 * 0.
 * 0, 1.
 * 0, 1, 3.
 * 0, 1, 3, 7.
 * 0, 2, 6, 9, 11.
 * 0, 2, 6, 9, 11, 15. <-- LIS List
 * ----------------------------------------------------------------------------
 */
