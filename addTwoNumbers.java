    
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode pre = null;
        int up = 0;
        while (l1 != null && l2 != null) {
            int l1v = l1.val;
            int l2v = l2.val;
            int sum = l1v + l2v + up;
            up = sum >= 10 ? 1 : 0;
            ListNode ln = new ListNode(sum % 10);
            if (root == null) {
                root = ln;
            } else {
                pre.next = ln;
            }
            pre = ln;
            l1 = l1.next;
            l2 = l2.next;
        }



        if (up == 1) {
            if (l1 != null) {
                pre.next = addTwoNumbers(l1, new ListNode(up));
            } else if (l2 != null) {
                pre.next = addTwoNumbers(l2, new ListNode(up));
            } else {
                pre.next = new ListNode(1);
            }
        } else {
            if (l1 != null) {
                pre.next = l1;
            }
            if (l2 != null) {
                pre.next = l2;
            }
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
