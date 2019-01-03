import java.util.*;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Print {
    ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        queue.add(pRoot);
        
        while(!queue.isEmpty()){
            
            int ctn = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(ctn-- > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(list.size() != 0){
                lists.add(list);
            } 
        }
        return lists;
    }
    
}