package com.thenullproject.algorithms;

// Linked list problems. Problem
public class LinkedListOps {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

//        ListNode head = new ListNode(1, new ListNode(2));

//        System.out.println(middleNode(head).val);
        head = removeNthFromEnd(head, 1);

        while(head != null) {

            System.out.print(head.val + ", ");

            head = head.next;
        }

    }

    // problem 19
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode originalHead = head;
        ListNode precedingNode = null;
        int counter = 1;

        do {

            if(counter >= (n + 1)) {
                precedingNode = precedingNode == null ? originalHead : precedingNode.next;
            }

            counter++;
            head = head.next;
        } while(head != null);



        if(n > (counter - 1)) {
            return originalHead;
        } if(precedingNode == null) {
            originalHead = originalHead.next;
        } else {
            precedingNode.next = precedingNode.next.next;
        }

        return originalHead;

    }

    // problem 876
    public static ListNode middleNode(ListNode head) {

          ListNode[] nodeArray = new ListNode[100];
          int counter = 0;

          do {
              nodeArray[counter++] = head;
              head = head.next;
          } while(head != null);

          int mid = counter / 2;

          return nodeArray[mid];
    }
}
