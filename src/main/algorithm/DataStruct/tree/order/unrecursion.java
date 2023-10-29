package main.algorithm.DataStruct.tree.order;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 算法->数据结构->树->递归遍历:
 * - 先序遍历（递归实现）
 * - 中序遍历（递归实现）
 * - 后序遍历（递归实现）
 */
public class unrecursion {

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                System.out.print(t.val);
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            t = t.right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            System.out.println(t.val);
            stack.add(t.right);
            stack.add(t.left);
        }
        return ans;
    }


    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            System.out.print(t.val);
            t = t.right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t =root;
        //stack.add(root);
        while (t!=null||!stack.isEmpty()){
            if(t != null){
                stack.add(t);
                t=t.left;
            }else {
                t = stack.pop();
                System.out.println(t.val);
                t=t.right;
            }
        }

        return ans;
    }
    /**
     * 对于一个结点：
     * 左孩子全遍历，但不能出栈(右孩子没遍历)
     * 遍历右孩子
     * 将当前结点出栈(用lastvisit来标记上一个出栈的结点，如果正在访问节点的右孩子是上一个，那就可以出栈，否则访问右孩子)
     *
     */
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        TreeNode lastVisit = new TreeNode();
        while (!stack.isEmpty() || t != null) {
            while (t != null && t != lastVisit) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.isEmpty()) {
                t = stack.peek();
                if (t.right == null || t.right == lastVisit) {
                    //右孩子访问过
                    t = stack.pop();
                    System.out.print(t.val);
                    lastVisit = t;
                } else {
                    t = t.right;
                }
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            if(t!=null){
                System.out.println(t.val);
                stack.add(t.left);
                stack.add(t.right);
            }

        }
        return ans;

    }


    public static void main(String[] args) {
        TreeNode[] treeNode = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            treeNode[i] = new TreeNode(i);
        }
        TreeNode root;
        // init data
        {
            treeNode[5].left = treeNode[3];
            treeNode[5].right = treeNode[8];
            treeNode[3].left = treeNode[1];
            treeNode[3].right = treeNode[4];
            treeNode[8].left = treeNode[7];
            treeNode[8].right = treeNode[9];
            treeNode[1].left = treeNode[0];
            treeNode[1].right = treeNode[2];
            treeNode[7].left = treeNode[6];
            root = treeNode[5];
        }

        System.out.print("\n先序遍历：");
        preOrder(root);

        System.out.print("\n中序遍历：");
        inOrder(root);

        System.out.print("\n后序遍历：");
        postOrder(root);

    }
}
