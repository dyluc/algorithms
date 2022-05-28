package com.thenullproject.algorithms;

import java.util.HashSet;
import java.util.Set;

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
//        head = removeNthFromEnd(head, 1);


        ListNode l1 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//        head = mergeTwoLists(l1, l2);
        head = removeElements(l1, 7);

        while(head != null) {

            System.out.print(head.val + ", ");
            head = head.next;
        }

    }

    // problem 19
    private static ListNode removeNthFromEnd(ListNode head, int n) {

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
    private static ListNode middleNode(ListNode head) {

          ListNode[] nodeArray = new ListNode[100];
          int counter = 0;

          do {
              nodeArray[counter++] = head;
              head = head.next;
          } while(head != null);

          int mid = counter / 2;

          return nodeArray[mid];
    }

    // problem 141 (check for cycles)
    private static boolean hasCycle(ListNode head) {

        Set<ListNode> visitedNodes = new HashSet<>();

        while(head != null) {

            if(!visitedNodes.add(head))
                return true;

            head = head.next;
        }

        return false;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        // set head
        ListNode head;
        if(list1.val < list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode originalHead = head;


        while(true) {

            if(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    head.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    head.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            } else if(list1 == null) {
                head.next = list2;
                break;
            } else {
                head.next = list1;
                break;
            }

            head = head.next;
        }

        return originalHead;

    }

    // problem 203, remove list element
    private static ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return null;

        ListNode newHead = head;

        while(head != null) {

            if(head.next != null && head.next.val == val)
                head.next = head.next.next;
            else
                head = head.next;

        }

        if(newHead.val == val)
            newHead = newHead.next;

        return newHead;

    }
}
