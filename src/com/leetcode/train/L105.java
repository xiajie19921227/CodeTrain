package com.leetcode.train;

import com.dataStructure.tree.TreeNode;

import java.util.Arrays;

public class L105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 递归出口条件，preorder
         */
        if(preorder.length==0|| inorder.length==0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;i++){
            if(preorder[0] == inorder[i]){
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(pre_left,in_left);
                root.right = buildTree(pre_right,in_right);
                break;
            }
        }
        return  root;
    }
}
