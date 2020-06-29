package LeetCode.LeetCodeHeap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i:nums) {
            aMap.put(i, aMap.getOrDefault(i,0) +1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> aMap.get(n1) - aMap.get(n2));
        for (int i:aMap.keySet()) {
            heap.add(i);
            if (heap.size() > k)
                heap.poll();
        }

        int[] ret = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ret[i] = heap.poll();
        }
        return ret;
    }

    @Test
    public void test() {
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] expected = new int[] {1,2};

        assertThat(topKFrequent(nums, k), is(expected));

        nums = new int[] {1};
        k = 1;
        expected = new int[] {1};

        assertThat(topKFrequent(nums, k), is(expected));
    }
}
