/**
 * https://leetcode.com/problems/jump-game/
 */

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */

package LeetCode.LeetCodeDP;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JumpGame {

    State[] memoiz;

    enum State {
        GOOD, BAD, UNKNOWN
    }

    @Test
    public void test() {
        int[] nums = new int[] {2,3,1,1,4};
        assertThat(canJump(nums), is(true));

        nums = new int[] {3,2,1,0,4};
        assertThat(canJump(nums), is(false));

        nums = new int[] {0};
        assertThat(canJump(nums), is(true));
    }

    /**
     * https://leetcode.com/articles/jump-game/
     *
     * Once we have our code in the bottom-up state, we can make one final, important observation.
     * From a given position, when we try to see if we can jump to a GOOD position,
     * we only ever use one - the first one (see the break statement).
     * In other words, the left-most one.
     * If we keep track of this left-most GOOD position as a separate variable,
     * we can avoid searching for it in the array.
     * Not only that, but we can stop using the array altogether.
     */

    /**
     * This solution is not as simple as the one mentioned in the article
     * Just a slight modification of the bottom-up approach
     */

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int index = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (j == nums.length - 1) {
                    index = i;
                    break;
                } else if ( j == index) {
                    index = i;
                    break;
                }
            }
        }

        return index >= 0 && index <= nums[0];
    }

    /**
     * bottom-up
     */
    public boolean canJump2(int[] nums) {
        memoiz = new State[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memoiz[i] = State.UNKNOWN;
        }
        memoiz[nums.length-1] = State.GOOD;

        //return canJumpFrom(0, nums);
        for (int i = nums.length-2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i+1; j <= furthestJump; j++) {
                if (memoiz[j] == State.GOOD) {
                    memoiz[i] = State.GOOD;
                    break;
                }
            }
        }
        return memoiz[0] == State.GOOD;
    }

    /**
     * not used in bottom-up
     */
    public boolean canJumpFrom(int index, int[] nums) {
        if (memoiz[index] != State.UNKNOWN) {
            return memoiz[index] == State.GOOD?true:false;
        }

        int furthestTarget = Math.min(index + nums[index], nums.length-1);

        for (int nextTarget = index+1; nextTarget <= furthestTarget; nextTarget++) {
            if (canJumpFrom(nextTarget, nums)) {
                memoiz[index] = State.GOOD;
                return true;
            }
        }
        memoiz[index] = State.BAD;
        return false;
    }


    public boolean canJumpFrom2(int index, int[] nums) {
        System.out.println("Jump from: " + index);

        if (index >= (nums.length-1)) return true;

        int furthestJump = Math.min(index + nums[index], nums.length-1);

        for (int nextPost = furthestJump; nextPost > index; nextPost--) {
            if (canJumpFrom2(nextPost, nums))
                return true;
        }
        return false;
    }
}