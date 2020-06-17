package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        //System.out.println(Arrays.deepToString(costs));
        int[][] clone = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            clone[i][0] = costs[i][0];
            clone[i][1] = costs[i][1];
            clone[i][2] = costs[i][1]-costs[i][0];
            if (clone[i][2] < 0) clone[i][2] *= -1;
        }
        //System.out.println(Arrays.deepToString(clone));
        quickSort(clone, 0, clone.length-1);
        //System.out.println(Arrays.deepToString(clone));
        int countA = 0;
        int countB = 0;
        int ret = 0;
        int eachSide = costs.length/2;
        for (int i = clone.length-1; i >= 0 ; i--) {

            if (clone[i][0] <= clone[i][1] && countA < eachSide) {
                ret += clone[i][0];
                countA++;
            } else if (clone[i][0] >= clone[i][1] && countB < eachSide) {
                ret += clone[i][1];
                countB++;
            } else if (countA >= eachSide) {
                ret += clone[i][1];
                countB++;
            } else if (countB >= eachSide) {
                ret += clone[i][0];
                countA++;
            }
            //System.out.println("A: " + countA + " B: " + countB + " " + Arrays.toString(clone[i]));
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

        int pivotValue = input[(start+end)/2][2];

        int i = start;
        int j = end;
        while (i <= j) {
            while (input[i][2] < pivotValue)
                i++;
            while (input[j][2] > pivotValue)
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
    public void testTwoCitySchedCost() {
        int[][] nums = new int[][] {{10,20}, {30,200}, {400,50}, {30,20}};
        //assertThat(twoCitySchedCost(nums), is(110));

        nums = new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        assertThat(twoCitySchedCost(nums), is(1859));

        nums = new int[][] {{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        assertThat(twoCitySchedCost(nums), is(3671));
    }

}
