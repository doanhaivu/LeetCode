package LeetCode.LeetCodeLinkedList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyDoublyLinkedList {
    ListNode<Integer> head;

    public MyDoublyLinkedList() {

    }

    public void init(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //if (i == 0)
            //    addAtHead(nums[i]);
            //else
            //    addAtTail(nums[i]);
        }
    }

    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1. */
    public int get(int index) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            if (count == index) {
                return (int)tmp.val;
            }
            tmp = tmp.next;
            count++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = head.next;

            head.next = newNode;
            head.val = val;
        } else {
            head = new ListNode(val);
        }
    }

    public void print() {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println("NULL");
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        ListNode newNode = new ListNode(val);
        tmp.next = newNode;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0)
            return;
        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        ListNode tmp = head;
        ListNode prev = null;
        int count = 0;
        while (tmp != null) {
            if (count == index) {
                ListNode newNode = new ListNode(val);
                newNode.next = tmp;
                prev.next = newNode;
                return;
            }

            count++;
            prev = tmp;
            tmp = tmp.next;
        }

        if (index == count) {
            addAtTail(val);
            return;
        }
    }

    public void deleteAtHead() {
        head = head.next;
    }

    public void deleteAtTail() {
        ListNode tmp = head;
        ListNode prev = null;
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
        }
        if (prev != null)
            prev.next = null;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0)
            return;
        if (index == 0) {
            deleteAtHead();
            return;
        }

        ListNode tmp = head;
        ListNode prev = null;
        int count = 0;
        while (tmp != null) {
            if (count == index) {
                prev.next = tmp.next;
                return;
            }

            count++;
            prev = tmp;
            tmp = tmp.next;
        }

        //if (index == count) {
        //    deleteAtTail();
        //    return;
        //}
    }


}
