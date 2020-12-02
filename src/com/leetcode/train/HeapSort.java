package com.leetcode.train;

import java.util.Arrays;

public class HeapSort {

    /**
     * 建堆
     *
     * @param arrays          看作是完全二叉树
     * @param currentRootNode 当前父节点位置
     * @param size            节点总数
     */
    public static void heapify(int[] arrays, int currentRootNode, int size) {

        if (currentRootNode < size) {
            //左子树和右字数的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            //把当前父节点位置看成是最大的
            int max = currentRootNode;

            if (left < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }
            if (right < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != currentRootNode) {
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;

                //继续比较，直到完成一次建堆
                heapify(arrays, max, size);
            }
        }
    }

    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void maxHeapify(int[] arrays, int size) {

        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            heapify(arrays, i, size);
        }

    }

    public static void main(String[] args) {
      int[] arrays = {2,1,6,3,5,9,4};
        /**
         * 每构建一次大顶堆，都将堆顶的元素 和数组的第一个元素互换位置，放到数组首位
         */
      for(int i =0;i<arrays.length;i++){
          /**
           * 每建好一次堆就可以把最后一个元素移除，减少一个
           */
          maxHeapify(arrays,arrays.length -1);
          int temp = arrays[0];
          arrays[0] = arrays[(arrays.length-1)-i];
          arrays[(arrays.length-1)-i] = temp;
      }
    }
}
