package LeetCode.LeetCodeInterval;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return intervals;

        quickSort(intervals, 0, intervals.length-1);

        ArrayList<Integer> removeIndex = new ArrayList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i+1][1]) ;
                intervals[i+1] = intervals[i];
                removeIndex.add(i);
            }
        }

        int retLength = intervals.length - removeIndex.size();
        int[][] ret = new int[retLength][intervals[0].length];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (removeIndex.contains(i))
                continue;
            ret[count] = intervals[i];
            count++;
        }

        return ret;
    }


    public void quickSort(int[][] input, int start, int end) {
        int index = partition(input, start, end);

        if (start < index-1)
            quickSort(input, start, index-1);
        if (index < end)
            quickSort(input, index, end);
    }

    public int partition(int[][] input, int start, int end) {

        int pivotValue = input[(start+end)/2][0];

        int i = start;
        int j = end;
        while (i <= j) {
            while (input[i][0] < pivotValue)
                i++;
            while (input[j][0] > pivotValue)
                j--;
            if (i <= j) {
                int[] a = input[i];
                input[i] = input[j];
                input[j] = a;
                i++;
                j--;
            }
        }
        return i;
    }

    @Test
    public void testMerge() {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = new int[][]{{1,6},{8,10},{15,18}};

        //System.out.println(Arrays.deepToString(nums));
        //quickSort(nums, 0, nums.length-1);
        //int[][] ret = merge(nums);
        //System.out.println(Arrays.deepToString(ret));

        assertThat(merge(nums), is(expected));


        nums = new int[][]{{1,4},{1,5}};
        expected = new int[][]{{1,5}};

        //System.out.println(Arrays.deepToString(nums));
        //int[][] ret = merge(nums);
        //System.out.println(Arrays.deepToString(ret));

        assertThat(merge(nums), is(expected));

        nums = new int[][]{};
        expected = new int[][]{};

        assertThat(merge(nums), is(expected));
    }
}
