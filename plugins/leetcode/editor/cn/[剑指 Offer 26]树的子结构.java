//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 289 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 先拆分子问题 为递归函数
     * A的节点和B的节点值进行比较
     * 终止条件：
     * 1、B为空 已完成匹配 返回true
     * 2、A为空 已越过A的树节点 返回false
     * 3、A的值不等于B的值 返回false
     *
     * 原问题包括几种转换
     * 1、A的根节点是否含有B节点开始遍历
     * 2、A的左节点是否含有B节点开始遍历
     * 3、A的右节点是否含有B节点开始遍历
     * 终止条件：
     * 1、A空节点 返回false
     * 3、3种转换只要有一种满足返回true 都不满足返回false
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
