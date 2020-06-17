package LeetCode.LeetCodeLinkedList;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyLinkedList {

    ListNode<Integer> head;

    public MyLinkedList() {

    }

    public void init(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                addAtHead(nums[i]);
            else
                addAtTail(nums[i]);
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

    public ListNode getNode(int index) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            if (count == index) {
                return tmp;
            }
            tmp = tmp.next;
            count++;
        }
        return null;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = head.next;

            head.next = newNode;
            head.val = (Integer)val;
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

    public void printCycle() {
        ListNode tmp = head;
        ListNode doubleMove = head;
        while (tmp != null && doubleMove.next != null) {
            System.out.print(tmp.val + ":" + doubleMove.val + "->");
            tmp = tmp.next;
            doubleMove = doubleMove.next.next;
            if (doubleMove.val == tmp.val) {
                //System.out.println("aa");
                break;
            }
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

    public boolean hasCycle() {
        ListNode singleMove = head;
        ListNode doubleMove = head;

        while (singleMove != null && doubleMove.next != null) {
            singleMove = singleMove.next;
            doubleMove = doubleMove.next.next;
            if (doubleMove == null)
                return false;
            if (singleMove.val == doubleMove.val) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle() {
        ListNode tmp = head;
        int index = 0;
        Map<ListNode, Integer> aMap = new HashMap<>();
        while (tmp != null) {
            if (aMap.containsKey(tmp)) {
                return getNode(index);
            }
            aMap.put(tmp, index);
            index++;
            tmp = tmp.next;
        }
        return null;
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
    }

    public void setCycle(int index) {
        if (index < 0)
            return;
        ListNode aNode = getNode(index);

        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = aNode;
    }

    public boolean checkIntersection(ListNode nodeA, ListNode nodeB) {
        //System.out.println("=================");
        ListNode tmpA = nodeA;
        ListNode tmpB = nodeB;
        while (tmpA != null && tmpB != null) {
            //System.out.println(tmpA.val + " " + tmpB.val);
            if (tmpA != tmpB)
                return false;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null ) {
            while (tmpB != null) {
                if (tmpA == tmpB) {
                    if (checkIntersection(tmpA, tmpB))
                        return tmpA;
                    else tmpB = tmpB.next;
                } else
                    tmpB = tmpB.next;
            }
            tmpB = headB;
            tmpA = tmpA.next;
        }
        return null;
    }

    public int getLength() {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public void removeNthFromEnd(int n) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int indexToRemove = count - n;

        tmp = head;
        int index = 0;
        while (tmp != null) {
            if (index == indexToRemove)
                deleteAtIndex(index);
            index++;
            tmp = tmp.next;
        }
    }

    public ListNode reverseList() {
        ListNode tmp = head;
        if (tmp == null) return null;

        ListNode newNode = new ListNode(tmp.val);
        tmp = tmp.next;

        while (tmp != null) {
            ListNode tmpNewNode = new ListNode();
            tmpNewNode.val = tmp.val;
            tmpNewNode.next = newNode;

            newNode = tmpNewNode;
            tmp = tmp.next;
        }

        return newNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode tmp = head;
        if (tmp == null) return null;

        ListNode newNode = new ListNode(tmp.val);
        tmp = tmp.next;

        while (tmp != null) {
            ListNode tmpNewNode = new ListNode();
            tmpNewNode.val = tmp.val;
            tmpNewNode.next = newNode;

            newNode = tmpNewNode;
            tmp = tmp.next;
        }

        return newNode;
    }

    public ListNode removeElements(int val) {
        ListNode tmp = head;
        ListNode prev = null;

        while (tmp != null) {
            if (tmp.val == (Integer)val) {
                if (prev != null) {
                    prev.next = tmp.next;
                    tmp = tmp.next;
                    continue;
                }
                else {
                    head = head.next;
                    tmp = tmp.next;
                    continue;
                }
            }
            prev = tmp;
            tmp = tmp.next;
        }
        return head;
    }

    public ListNode oddEvenList() {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode tmp = head.next;
        int count = 1;
        while ((odd != null && odd.next != null) && (even != null && even.next != null)) {
            if (count % 2 == 0) {
                even.next = odd.next;
                even = even.next;
            } else {
                odd.next = even.next;
                odd = odd.next;
            }
            count++;
        }
        odd.next = null;
        even.next = null;
        odd.next = tmp;
        return head;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean evenFlag = false;
        while (fast.next != null) {
            if (fast.next.next == null) {
                evenFlag = true;
                fast = fast.next;
            }
            else
                fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tmp;
        if (evenFlag)
            tmp = reverseList(slow);
        else tmp = reverseList(slow.next);

        ListNode checker = head;
        while (tmp != null) {
            if (tmp.val != checker.val)
                return false;
            tmp = tmp.next;
            checker = checker.next;
        }
        return true;
    }

    public void removeByNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void testRemoveByNode() {
        int[] nums = new int[] {1,2,6,3,4,5};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);

        ListNode<Integer> tmp = obj.head;
        while (tmp != null) {
            if (tmp.val == 3)
                break;
            tmp = tmp.next;
        }

        obj.print();
        obj.removeByNode(tmp);
        obj.print();
    }

    @Test
    public void testIsPalindrome2() {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);
        obj.isPalindrome();//assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,2,3,4,5,6,7,8};
        obj = new MyLinkedList();
        obj.init(nums);
        obj.isPalindrome();//assertThat(obj.isPalindrome(), is(false));


    }

    @Test
    public void testIsPalindrome() {
        int[] nums = new int[] {1,2};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(true));

        nums = new int[] {1,2,2,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(true));

        nums = new int[] {1,0,0};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,2,2,1,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,2,2,1,1,3};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,0,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(true));

        nums = new int[] {1,1,2,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(false));

        nums = new int[] {1,1,2,1,1};
        obj = new MyLinkedList();
        obj.init(nums);
        assertThat(obj.isPalindrome(), is(true));
    }

    @Test
    public void testOddEvenList() {
        int nums[] = new int[] {};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.oddEvenList();
        obj.print();

        nums = new int[] {1,2,3,4,5,6,7,8,9};
        obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.oddEvenList();
        obj.print();

        nums = new int[] {1,2,3,4,5,6,7,8};
        obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.oddEvenList();
        obj.print();
    }

    @Test
    public void testRemoveElements() {
        int[] nums = new int[] {1,2,6,3,4,5,6};
        MyLinkedList obj = new MyLinkedList();

        obj.init(nums);
        obj.print();
        obj.removeElements(6);
        obj.print();

        nums = new int[] {1,1};
        obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.removeElements(1);
        obj.print();


        nums = new int[] {1,2,2,1};
        obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.removeElements(2);
        obj.print();
    }

    @Test
    public void testReverseList() {
        int[] nums = new int[] {1,2,3,4,5};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);
        obj.print();
        obj.head = obj.reverseList();
        obj.print();
    }

    @Test
    public void testRemoveNthFromEnd() {
        int[] nums = new int[] {1,2,3,4,5};
        int n = 2;

        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);

        //bj.removeNthFromEnd(obj.head, n);
        //obj.print();

        nums = new int[] {1};
        n = 1;
        obj = new MyLinkedList();
        obj.init(nums);

        obj.removeNthFromEnd(n);
        obj.print();
    }

    @Test
    public void testDetectCycle() {
        int[] nums = new int[] {-1,-7,7,-4,19,6,-9,-5,-2,-5};
        MyLinkedList obj = new MyLinkedList();
        obj.init(nums);

        int pos = 6;

        System.out.println(obj.hasCycle());
        obj.print();

        obj.setCycle(pos);
        System.out.println(obj.detectCycle().val);
        obj.printCycle();
    }

    @Test
    public void testIntersection() {
        int[] numsA = new int[] {4,1,8,4,5};
        int[] numsB = new int[] {5,0,1,8,4,5};
        MyLinkedList objA = new MyLinkedList();
        MyLinkedList objB = new MyLinkedList();
        objA.init(numsA);
        objB.init(numsB);

        ListNode ret = getIntersectionNode(objA.head, objB.head);
        System.out.println(ret == null?null:ret.val);

        numsA = new int[] {0,9,1,2,4};
        numsB = new int[] {3,2,4};

        objA = new MyLinkedList();
        objB = new MyLinkedList();
        objA.init(numsA);
        objB.init(numsB);

        ret = getIntersectionNode(objA.head, objB.head);
        System.out.println(ret == null?null:ret.val);

        numsA = new int[] {2,6,4};
        numsB = new int[] {1,5};

        objA = new MyLinkedList();
        objB = new MyLinkedList();
        objA.init(numsA);
        objB.init(numsB);

        ret = getIntersectionNode(objA.head, objB.head);
        System.out.println(ret == null?null:ret.val);
    }
}
