/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = m - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[top][i] = getNumber(head);
                if (head != null) {
                    head = head.next;
                }
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = getNumber(head);
                if (head != null) {
                    head = head.next;
                }
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result[bottom][i] = getNumber(head);
                if (head != null) {
                    head = head.next;
                }
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result[i][left] = getNumber(head);
                if (head != null) {
                    head = head.next;
                }
            }
            left++;
        }

        return result;
    }

    private int getNumber(ListNode head) {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

}