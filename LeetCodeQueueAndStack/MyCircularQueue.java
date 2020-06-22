package LeetCode.LeetCodeQueueAndStack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MyCircularQueue {
    public int[] data;
    public int front = 0;
    public int rear = -1;
    public int QUEUE_LENGTH = 0;
    public int itemCount = 0;

    public MyCircularQueue() {
    }

    //public MyCircularQueue(int k) {
    //    QUEUE_LENGTH = k;
    //    data = new int[QUEUE_LENGTH];
    //}

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        itemCount++;
        if (rear < QUEUE_LENGTH-1)
            rear++;
        if (rear == QUEUE_LENGTH-1 && front != 0) {
            rear = 0;
            data[rear] = value;
        }
        else {
            data[rear] = value;
        }

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        front++;
        if (front >= QUEUE_LENGTH)
            front = 0;
        itemCount--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        System.out.println("==========FRONT==========");
        System.out.println(Arrays.toString(data));
        System.out.println("front: " + front + " rear: " + rear + " itemCount: " + itemCount);
        return data[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        System.out.println("==========REAR==========");
        System.out.println(Arrays.toString(data));
        System.out.println("front: " + front + " rear: " + rear + " itemCount: " + itemCount);
        if (isEmpty()) return -1;
        return data[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return itemCount == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return itemCount >= (QUEUE_LENGTH);
    }

    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(); // set the size to be 3
        circularQueue.QUEUE_LENGTH = 3;
        circularQueue.data = new int[circularQueue.QUEUE_LENGTH];

        assertThat(circularQueue.enQueue(2), is(true));
        assertThat(circularQueue.Rear(), is(2));
        assertThat(circularQueue.Front(), is(2));
        assertThat(circularQueue.deQueue(), is(true));
        assertThat(circularQueue.Front(), is(-1));
        assertThat(circularQueue.deQueue(), is(false));
        assertThat(circularQueue.Front(), is(-1));
        assertThat(circularQueue.enQueue(4), is(true));
        assertThat(circularQueue.enQueue(2), is(true));
        assertThat(circularQueue.enQueue(2), is(true));
        assertThat(circularQueue.enQueue(3), is(false));

    }
}
