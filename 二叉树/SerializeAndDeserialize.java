/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
请实现两个函数，分别用来序列化和反序列化二叉树
*/
public class SerializeAndDeserialize {
    private String deSerializeStr;
    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        // 采用先序遍历的方式系列化
        return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);
  }
    TreeNode Deserialize(String str) {
       deSerializeStr = str;
       return Deserialize();
  }
    
    TreeNode Deserialize(){
        if(deSerializeStr.length() == 0){
            return null;
        }
        int index = deSerializeStr.indexOf(" ");
        String val = index == -1? deSerializeStr:deSerializeStr.substring(0, index);
        deSerializeStr = index == -1? "":deSerializeStr.substring(index+1);
        
        if(val.equals("#")){
            return null;
        }
        
        // 同理采用先序遍历的方式反系列化
        TreeNode t = new TreeNode(Integer.valueOf(val));
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}