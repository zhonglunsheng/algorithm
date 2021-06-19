//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
//    public ListNode deleteNode(ListNode head, int val) {
//        // 如果要删除的节点是头节点
//        if (head == null) return null;
//        if (head.val == val) return head.next;
//
//        // 开始遍历链表
//        ListNode cur = head;
//        // 先找到要删除的节点的前节点
//        while (cur.next != null && cur.next.val != val) {
//            cur = cur.next;
//        }
//        // 将前节点的下一个节点指向要删除节点的后一个节点
//        if (cur != null) cur.next = cur.next.next;
//
//        return head;
//    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        // 找到要删除的节点返回下一个节点
        if (head.val == val) {
            return head.next;
        }else {
            // 转换子问题 head.next 指向删除节点后的下一个节点
            head.next = deleteNode(head.next, val);
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
