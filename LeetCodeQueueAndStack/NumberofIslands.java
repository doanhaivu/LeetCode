package LeetCode.LeetCodeQueueAndStack;

import Common.Utilities;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        LinkedList<Integer> aQueue = new LinkedList<>();
        aQueue.offer(getKey(i,j, grid[0].length));

        int key;
        int tmpX;
        int tmpY;

        while (!aQueue.isEmpty()) {
            key = aQueue.pop();
            tmpX = key/grid[0].length;
            tmpY = key%grid[0].length;

            if (tmpX+1 < grid.length) {
                if (grid[tmpX+1][tmpY] == '1' && !visited[tmpX+1][tmpY]) {
                    visited[tmpX+1][tmpY] = true;
                    aQueue.offer(getKey(tmpX+1,tmpY, grid[0].length));
                }
            }

            if (tmpX-1 >= 0) {
                if (grid[tmpX-1][tmpY] == '1' && !visited[tmpX-1][tmpY]) {
                    visited[tmpX-1][tmpY] = true;
                    aQueue.offer(getKey(tmpX-1,tmpY, grid[0].length));
                }
            }

            if (tmpY+1 < grid[0].length) {
                if (grid[tmpX][tmpY+1] == '1' && !visited[tmpX][tmpY+1]) {
                    visited[tmpX][tmpY+1] = true;
                    aQueue.offer(getKey(tmpX,tmpY+1, grid[0].length));
                }
            }

            if (tmpY-1 >= 0) {
                if (grid[tmpX][tmpY-1] == '1' && !visited[tmpX][tmpY-1]) {
                    visited[tmpX][tmpY-1] = true;
                    aQueue.offer(getKey(tmpX,tmpY-1, grid[0].length));
                }
            }

            /*
            for (int l = tmpX; l < grid.length; l++) {
                for (int m = tmpY; m < grid[0].length; m++) {
                    if (grid[l][m] == '1' && !visited[l][m]) {
                        visited[l][m] = true;
                        aQueue.offer(getKey(l,m, grid[0].length));
                    } else if (grid[l][m] == '0')
                        break;
                }
            }*/
        }
    }

    public int getKey(int i, int j, int m) {
        return i*m + j;
    }

    @Test
    public void test() {
        char[][] grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_1.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(1));

        grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_2.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(3));

        grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_3.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(0));

        grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_4.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(3));

        grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_5.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(4));

        grid = Utilities.create2DArr("src/LeetCode/LeetCodeQueueAndStack/islands/island_6.txt");
        Utilities.print2DArr(grid);
        assertThat(numIslands(grid), is(1));
    }
}
