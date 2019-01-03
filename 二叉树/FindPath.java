import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
public class FindPath {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }
    
    
    public void backtracking(TreeNode root, int target, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        
        path.add(root.val);
        
        target -= root.val;
        
        if(target == 0 && root.left == null && root.right == null){
            ret.add(new ArrayList<>(path));
        }else{
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }
        // 不管添加的值是否满足条件都需要回退一步 找其他的可能性
        path.remove(path.size() - 1);
    }
}