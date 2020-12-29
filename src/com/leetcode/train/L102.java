package com.leetcode.train;

import com.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6= new TreeNode(6);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root1.setLeft(root4);
        root2.setLeft(root5);
        root2.setLeft(root6);
        levelOrder(root);
    }

    public  static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer>  subList = new ArrayList<>();
            for (int i=0;i<queue.size();i++){
                TreeNode cunrrentNode = queue.poll();
                subList.add(cunrrentNode.getVal());
                System.out.println(cunrrentNode.getVal());
                if (cunrrentNode.getLeft() != null) {
                    queue.offer(cunrrentNode.getLeft());
                }
                if (cunrrentNode.getRight() != null) {
                    queue.offer(cunrrentNode.getRight());
                }
            }
            res.add(subList);
        }
        return res;
    }
}
