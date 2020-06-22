package LeetCode.LeetCodeQueueAndStack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyQueue {

    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int p_start;
    private int p_end;

    public MyQueue() {
        data = new ArrayList<Integer>();
        //p_start = -1;
        p_end = -1;
    }

    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int x) {
        data.add(x);
        p_end++;
        return true;
    }

    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (p_end >= 0) {
            data.remove(p_start);
            p_end--;
            return true;
        } else return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return data.get(p_start);
    }

    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_end < 0;
    }

    @Test
    public void test() {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.Front());
        }
    }
}
