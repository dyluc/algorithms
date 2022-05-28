package com.thenullproject.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        /*
               1
             2   3
            4 5   6
           7     8 9


                  f
              c       j
             a d    h   k
                     i

         */

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6, new TreeNode(8), new TreeNode(9))));

        TreeNode root2 = new TreeNode('f',
                new TreeNode('c', new TreeNode('a'), new TreeNode('d')),
                new TreeNode('j', new TreeNode('h', null, new TreeNode('i')), new TreeNode('k')));

        System.out.println("BFS:");
        bfs(root);

        System.out.println("\nre Order DFS:");
        preOrderDFS(root2);

        System.out.println("\nIn Order DFS:");
        inOrderDFS(root2);

        System.out.println("\nPost Order DFS:");
        postOrderDFS(root2);

    }

    // Depth First Traversal (Pre Order)
    private static void preOrderDFS(TreeNode node) {
        if(node == null)
            return;

        System.out.print((char)node.val + ", ");
        preOrderDFS(node.left);
        preOrderDFS(node.right);

    }

    // Depth First Traversal (In Order)
    private static void inOrderDFS(TreeNode node) {
        if(node == null)
            return;

        inOrderDFS(node.left);
        System.out.print((char)node.val + ", ");
        inOrderDFS(node.right);
    }

    // Depth First Traversal (Post Order)
    private static void postOrderDFS(TreeNode node) {
        if(node == null)
            return;

        postOrderDFS(node.left);
        postOrderDFS(node.right);
        System.out.print((char)node.val + ", ");
    }


    // Breadth (Level) First Traversal
    private static void bfs(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        TreeNode temp;
        while (!queue.isEmpty()) {

            temp = queue.poll();
            System.out.print(temp.val + ", ");

            // if has right child
            if (temp.left != null)
                queue.add(temp.left);

            // if has right child
            if (temp.right != null)
                queue.add(temp.right);

        }

    }

}
