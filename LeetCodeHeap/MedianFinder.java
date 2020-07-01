package LeetCode.LeetCodeHeap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MedianFinder {
    Queue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> larger = new PriorityQueue<>();
    boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (even) {
            larger.offer(num);
            smaller.offer(larger.poll());
        } else {
            smaller.offer(num);
            larger.offer(smaller.poll());
        }

        even = !even;

        System.out.println("=================================");
        System.out.println(Arrays.toString(smaller.toArray()));
        System.out.println(Arrays.toString(larger.toArray()));
    }

    public double findMedian() {
        if (even) {
            return (smaller.peek() + larger.peek())/2.0;
        } else return smaller.peek();
    }

    @Test
    public void test() {
        MedianFinder obj = new MedianFinder();
        /*obj.addNum(1);
        obj.addNum(2);
        assertThat(obj.findMedian(), is(1.5));
        obj.addNum(3);
        assertThat(obj.findMedian(), is(2.0));
*/
        obj = new MedianFinder();
        obj.addNum(41);
        obj.addNum(35);
        obj.addNum(62);
        obj.addNum(4);
        obj.addNum(97);
        obj.addNum(108);
        assertThat(obj.findMedian(), is(51.5));
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
