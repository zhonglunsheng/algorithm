/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/
public class Convert{
    TreeNode head = null;
    TreeNode pre = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        node.left = pre;
        
        if(pre != null){
            pre.right = node;
        }
        
        if(head == null){
            head = node;
        }
        
        pre = node;
        inOrder(node.right);
    }
}