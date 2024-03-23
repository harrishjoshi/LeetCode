package leetcode.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode currentHead = dummyHead;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int x = (current1 != null) ? current1.val : 0;
            int y = (current2 != null) ? current2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currentHead.next = new ListNode(sum % 10);
            currentHead = currentHead.next;
            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }

        if (carry > 0) {
            currentHead.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public ListNode createLinkedList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummyHead.next;
    }

    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var addTwoNumbers = new AddTwoNumbers();
        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{5, 6, 4};
        ListNode l1 = addTwoNumbers.createLinkedList(arr1);
        ListNode l2 = addTwoNumbers.createLinkedList(arr2);
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.printLinkedList(listNode);
    }
}