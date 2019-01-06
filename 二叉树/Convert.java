/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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