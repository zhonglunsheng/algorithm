//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 157 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//        ListNode temp = head;
//        int size = 0;
//        while(temp != null) {
//            stack.push(temp.val);
//            temp = temp.next;
//            size ++;
//        }
//        int[] reverseNodeArr = new int[size];
//        for (int i = 0; i < size; i++) {
//            reverseNodeArr[i] = stack.pop();
//        }
//        return reverseNodeArr;
//    }
    ArrayList<Integer> result = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recure(head);
        // 将List转换数组
        int size = result.size();
        int[] reverseNodeArr = new int[size];
        for (int i = 0; i < size; i++) {
            reverseNodeArr[i] = result.get(i);
        }
        return reverseNodeArr;
    }

    public void recure(ListNode head) {
        if (head == null) {
            return;
        }
        // 先递归到末尾
        recure(head.next);
        // 回溯添加值
        result.add(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
