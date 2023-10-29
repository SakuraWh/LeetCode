package main.middle;

import java.util.Stack;

public class test_verifypreordersequenceinbinarysearchtree {
    public static void main(String[] args) {
        System.out.println(new test_verifypreordersequenceinbinarysearchtree().verifyPreorder(new int[]{2,1}));
    }

    //单调栈
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int root = preorder[preorder.length-1];
        for (int i : preorder) {
            while (!stack.isEmpty() && stack.peek() < i) {
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && stack.peek() <= root) {
            stack.pop();
        }
        return stack.size() == 0;

    }

//    public boolean verifyPreorder(int[] preorder) {
//
//        return istree(preorder, 0, preorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
//
//    }
//
//    public boolean istree(int[] tree, int left, int right, int upper, int lower) {
//        if (left > right)
//            return true;
//
////        for (int i = left; i <= right; i++) {
////            System.out.printf(tree[i] + " ");
////        }
////        System.out.println();
//        int root = tree[left];
//        for (int i = left + 1; i <= right; i++) {
//            if (tree[i] > root) {
//                return istree(tree, left + 1, i - 1, root, lower) && istree(tree, i, right, upper, root);
//            }
//            if (tree[i] >= upper || tree[i] <= lower)
//                return false;
//        }
//        return istree(tree, left + 1, right, root, lower);
//    }

}
