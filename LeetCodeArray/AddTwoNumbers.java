package LeetCode.LeetCodeArray;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

import LinkedList.Node;
import Stack.MyStack;

public class AddTwoNumbers {
    public static MyStack addTwoNumbers(Node l1, Node l2) {

        Node tmp1 = l1;
        MyStack s1 = new MyStack();
        while (tmp1 != null) {
            s1.push(tmp1.getData());
            tmp1 = tmp1.getNext();
        }

        Node tmp2 = l2;
        MyStack s2 = new MyStack();
        while (tmp2 != null) {
            s2.push(tmp2.getData());
            tmp2 = tmp2.getNext();
        }

        s1.print();
        s2.print();
        MyStack ret = new MyStack();
        int mem = 0;
        try {
            Integer obj1 = s1.pop();
            Integer obj2 = null;

            while (obj1 != null) {
                int sum = obj1.intValue() + mem;
                try {
                    obj2 = s2.pop();
                } catch (Exception ef) {
                    System.out.println(ef.getMessage());
                }
                if (obj2 != null) {
                    sum += obj2.intValue();
                }

                //single digit assumption
                if (sum >= 10) {
                    mem = 1;
                    ret.push(sum-10);
                } else {
                    mem = 0;
                    ret.push(sum);
                }

                obj1 = s1.pop();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        ret.push(mem);

        return ret;
    }

    public static void main(String[] args) {
        Node l1 = new Node(8);
        l1.append(6);
        l1.append(5);

        Node l2 = new Node(4);
        l2.append(5);
        l2.append(6);
        l2.append(9);

        MyStack ret = null;
        if (l1.getLength()>l2.getLength()) {
            ret = addTwoNumbers(l1, l2);
        } else
            ret = addTwoNumbers(l2, l1);

        ret.print();
    }
}
