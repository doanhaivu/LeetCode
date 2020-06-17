/**
 * https://leetcode.com/problems/container-with-most-water/
 */


package LeetCode.LeetCodeArray;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContainerWithMostWater {

    @Test
    public void test(){
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        //assertThat(maxArea(height), is(49));

        height = new int[] {2,3,4,5,18,17,6};
        assertThat(maxArea(height), is(17));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        int tmp;

        while (i < j) {
            if (height[i] < height[j]) {
                tmp  = height[i]*(j-i);
                i++;
            }
            else {
                tmp  = height[j]*(j-i);
                j--;
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int tmp;
        int area = 0;
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = 1; j < height.length; j++) {
                tmp = Math.min(height[i], height[j]);
                area = (j-i)*tmp;
                if (area > max)
                    max = area;
            }
        }
        return max;
    }

}
