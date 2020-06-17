/**
 * https://leetcode.com/problems/unique-paths/
 */

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 */

package LeetCode.LeetCodeDP;

import Common.Utilities;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UniquePaths {

    @Test
    public void test() {
        assertThat(uniquePaths(3, 2), is(3));
        assertThat(uniquePaths(7, 3), is(28));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[][] arr = new int[m][n];

        arr[m-1][n-1] = 0;

        arr[m-2][n-2] = 2;

        for (int i = m-2; i >=0; i--) {
            arr[i][n-1] = 1;
        }

        for (int j = n-2; j >=0; j--) {
            arr[m-1][j] = 1;
        }

        //Utilities.print2DArr(arr);

        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >=0; j--) {
                arr[i][j] = arr[i+1][j] + arr[i][j+1];
            }
        }

        //Utilities.print2DArr(arr);

        return arr[0][0];
    }

}
