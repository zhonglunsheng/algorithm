//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 225 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    /**
     * 指针拆解法
     * @param head
     * @return
     */
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        // 每个节点复制一遍 先不考虑random
//        Node cur = head;
//        while (cur != null) {
//            // 构造一个重复节点 随机指针也复制
//            Node copyNode = new Node(cur.val);
//            copyNode.next = cur.next;
//            // 复制随机节点
//            cur.next = copyNode;
//            // cur 指向复制节点后的一个节点
//            cur = copyNode.next;
//        }
//        // 开始复制random节点
//        cur = head;
//        while (cur != null) {
//            if (cur.random != null) {
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//        // 拆分奇偶节点
//        Node oldNode = head;
//        // 保存复制后的头节点
//        Node evenNode = head.next;
//        cur = head.next;
//        while (cur.next != null) {
//            oldNode.next = oldNode.next.next;
//            cur.next = cur.next.next;
//            oldNode = oldNode.next;
//            cur = cur.next;
//        }
//
//        // 单独处理原链表尾节点
//        oldNode.next = null;
//        return evenNode;
//    }

    /**
     * 利用hash解决
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        // 复制节点val值
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 重新遍历一次 负责next和random值
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
