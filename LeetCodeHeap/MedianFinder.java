package LeetCode.LeetCodeHeap;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MedianFinder {
    Queue<Integer> maxHeap = new PriorityQueue<>();
    Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }

        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else return minHeap.peek();
    }

    @Test
    public void test() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        assertThat(obj.findMedian(), is(1.5));
        obj.addNum(3);
        assertThat(obj.findMedian(), is(2.0));
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
