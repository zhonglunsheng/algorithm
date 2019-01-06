/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
��ʵ�������������ֱ��������л��ͷ����л�������
*/
public class SerializeAndDeserialize {
    private String deSerializeStr;
    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        // ������������ķ�ʽϵ�л�
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
        
        // ͬ�������������ķ�ʽ��ϵ�л�
        TreeNode t = new TreeNode(Integer.valueOf(val));
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}