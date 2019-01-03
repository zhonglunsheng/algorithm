/**
*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
*例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
*/
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        
        return verify(sequence, 0, sequence.length-1);
    }
    
    public boolean verify(int[] sequence, int first, int last){
        if(last - first <= 1){
            return true;
        }
        
        int cutIndex = first;
        // 二叉搜索树后序遍历的最后一个值就是跟节点
        int rootValue = sequence[last];
        // 找到第一个比根节点值大的 也就是后序遍历后右子树和左子树的交界点
        while(cutIndex < last && sequence[cutIndex] <= rootValue){
            cutIndex ++;
        }
        
        // 只要右子树中有一个值小于跟节点 那么就不是后序遍历的结果
        while(cutIndex < last){
            if(sequence[cutIndex] < rootValue){
                return false;
            }
            cutIndex ++;
        }
        
        return verify(sequence, first, cutIndex -1) && verify(sequence, cutIndex, last);
    }
}