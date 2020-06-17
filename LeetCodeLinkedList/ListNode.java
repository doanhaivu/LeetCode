package LeetCode.LeetCodeLinkedList;

public class ListNode<T> {
    T val;
    ListNode<T> next;
    ListNode<T> prev;
    ListNode() {}
    ListNode(T val) { this.val = val; }
    ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
}
