package lc;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                System.out.print(matrix[i][i1] + " ");
            }
            System.out.println();
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] generateMatrix(int n) {
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int k = 1;
        int[][] ans = new int[n][n];
        while (k <= n * n) {
            // ->
            for (int i = left; i <= right; i++)
                ans[up][i] = k++;
            up++;
            // ↓
            for (int i = up; i <= down; i++)
                ans[i][right] = k++;
            right--;
            // <-
            for (int i = right; i >= left; i--)
                ans[down][i] = k++;
            down--;

            // ↑
            for (int i = down; i >= up; i--) {
                ans[i][left] = k++;
            }
            left++;
        }
        return ans;
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode t = new ListNode();
        t.next = head;
        ListNode p = t;
        while(p.next!=null){
            if(p.next.val==val){
                p.next=p.next.next;
            }
            p = p.next;
        }
        return t.next;
    }

}
