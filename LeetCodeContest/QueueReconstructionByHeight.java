package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        int[][] ret = new int[people.length][people[0].length];
        return ret;
    }

    @Test
    public void testReconstructQueue() {
        int[][] nums = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] expected = new int[][] {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};

        assertThat(reconstructQueue(nums), is(expected));
    }
}
