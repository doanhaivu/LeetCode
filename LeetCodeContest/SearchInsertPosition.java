package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        int mid = (high+low)/2;
        while (low <= high) {
            if (nums[mid] == target)
                return mid;
            else {
                if (nums[mid] > target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            mid = (high+low)/2;
        }

        //System.out.println("Insert after: " + mid);
        return low;
    }


    @Test
    public void test() {
        int[] nums = new int[] {1,3,5,6};
        int target = 5;
        assertThat(searchInsert(nums, target), is(2));
        assertThat(searchInsert(nums, 1), is(0));
        assertThat(searchInsert(nums, 3), is(1));
        assertThat(searchInsert(nums, 6), is(3));
        //assertThat(searchInsert(nums, 9), is(-1));

        nums = new int[] {1,3,5,6};
        target = 2;
        assertThat(searchInsert(nums, target), is(1));

        nums = new int[] {1,3,5,6};
        target = 7;
        assertThat(searchInsert(nums, target), is(4));

        nums = new int[] {1,3,5,6};
        target = 0;
        assertThat(searchInsert(nums, target), is(0));
    }
}
