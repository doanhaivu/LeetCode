package LeetCode.LeetCodeGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PacificAtlanticWaterFlow {

    int n, m;
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;

        n = matrix.length;
        m = matrix[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        LinkedList<Integer> aQueue = new LinkedList<>();
        LinkedList<Integer> pQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = true;
                    pQueue.offer(getKey(i, j, m));
                }
                if (i == n-1 || j == m-1) {
                    atlantic[i][j] = true;
                    aQueue.offer(getKey(i, j, m));

                }
            }
        }

        atlantic[0][m-1] = true;
        aQueue.offer(getKey(0, m-1, m));
        pacific[n-1][0] = true;
        pQueue.offer(getKey(n-1, 0, m));

        expandTheOcean(aQueue, atlantic, matrix);
        expandTheOcean(pQueue, pacific, matrix);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ret.add(Arrays.asList(i,j));
                }
            }
        }

        return ret;
    }

    public int getKey(int i, int j, int m) {
        return i*m + j;
    }

    public void expandTheOcean(LinkedList<Integer> aQueue, boolean[][] ocean, int[][] matrix) {
        int key;
        int tmpI;
        int tmpJ;
        while (!aQueue.isEmpty()) {
            key = aQueue.pop();
            tmpI = key/m;
            tmpJ = key%m;

            for(int[] d:dir){
                int x = tmpI+d[0];
                int y = tmpJ+d[1];

                if (x < 0 || x >= n || y < 0 || y >= m || ocean[x][y] || matrix[x][y] < matrix[tmpI][tmpJ])
                    continue;
                ocean[x][y] = true;
                aQueue.offer(getKey(x,y,m));
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0,4));
        expected.add(Arrays.asList(1,3));
        expected.add(Arrays.asList(1,4));
        expected.add(Arrays.asList(2,2));
        expected.add(Arrays.asList(3,0));
        expected.add(Arrays.asList(3,1));
        expected.add(Arrays.asList(4,0));

        int[][] matrix = new int[][]{{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};

        assertThat(pacificAtlantic(matrix), is(expected));

        matrix = new int[][]{};
        assertThat(pacificAtlantic(matrix), is(new ArrayList<>()));

        //[[0,3],[1,0],[1,1],[1,2],[1,3],[2,0],[2,1],[2,2],[2,3],[3,0],[3,2],[3,3]]
        //[[0,3],[1,0],[1,1],[1,2],[1,3],[2,0],[2,1],[2,2],[2,3],[3,0],[3,1],[3,2],[3,3]]

        matrix = new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(0,3));
        expected.add(Arrays.asList(1,0));
        expected.add(Arrays.asList(1,1));
        expected.add(Arrays.asList(1,2));
        expected.add(Arrays.asList(1,3));
        expected.add(Arrays.asList(2,0));
        expected.add(Arrays.asList(2,1));
        expected.add(Arrays.asList(2,2));
        expected.add(Arrays.asList(2,3));
        expected.add(Arrays.asList(3,0));
        expected.add(Arrays.asList(3,1));
        expected.add(Arrays.asList(3,2));
        expected.add(Arrays.asList(3,3));

        assertThat(pacificAtlantic(matrix), is(expected));
    }
}
