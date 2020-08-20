package LeetCode.LeetCodeGraph;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BattleshipsInABoard {
    int[][] horizontal = new int[][] {{0, 1}, {0, -1}};
    int[][] vertical = new int[][] {{1, 0}, {-1, 0}};
    int n;
    int m;
    public int countBattleships(char[][] board) {
        if (board.length == 0)
            return 0;
        n = board.length;
        m = board[0].length;
        int ret = 0;
        boolean[][] marker = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' && !marker[i][j]) {
                    marker[i][j] = true;
                    if (mark(i, j, board, marker))
                        ret++;
                }
            }
        }
        //Utilities.print2DArr(marker);
        return ret;
    }

    public boolean mark(int i, int j, char[][] board, boolean[][] marker) {
        LinkedList<Integer> aQueue = new LinkedList<>();
        aQueue.offer(getKey(i, j, m));
        boolean horizontalFlag = false;
        boolean verticalFlag = false;
        while (!aQueue.isEmpty()) {
            int aKey = aQueue.pop();
            int tmpI = aKey / m;
            int tmpJ = aKey % m;

            for (int[] arr:horizontal) {
                int dx = tmpI+arr[0];
                int dy = tmpJ+arr[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if (board[dx][dy] == 'X' && !marker[dx][dy]) {
                    horizontalFlag = true;
                    marker[dx][dy] = true;
                    aQueue.offer(getKey(dx, dy, m));
                }
            }

            for (int[] arr:vertical) {
                int dx = tmpI+arr[0];
                int dy = tmpJ+arr[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if (board[dx][dy] == 'X' && !marker[dx][dy]) {
                    verticalFlag = true;
                    marker[dx][dy] = true;
                    aQueue.offer(getKey(dx, dy, m));
                }
            }
        }
        if (horizontalFlag && verticalFlag)
            return false;
        else return true;
    }

    public int getKey(int i, int j, int m) {
        return i*m+j;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        assertThat(countBattleships(board), is(2));

        board = new char[][]{{'.','.','.','X'},{'X','X','X','X'},{'.','.','.','X'}};
        assertThat(countBattleships(board), is(0));
    }
}
