package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortColors {

    public int[] sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    int partition(int arr[], int left, int right) {
        int i = left;
        int j = right;
        int tmp;
        int pivot = arr[(left+right)/2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                i++;
                j--;
            }
        }
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1 ) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[] {2,1,2,0,1,1,1,1};
        int[] expected = new int[] {0,1,1,1,1,1,2,2};

        //sortColors(nums);
        assertThat(sortColors(nums), is(expected));
    }
}
