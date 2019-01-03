/**
*����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ�����������������������������ֶ�������ͬ��
*���磬��ͼ�Ǻ���������� 1,3,2 ����Ӧ�Ķ�����������
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
        // ����������������������һ��ֵ���Ǹ��ڵ�
        int rootValue = sequence[last];
        // �ҵ���һ���ȸ��ڵ�ֵ��� Ҳ���Ǻ�����������������������Ľ����
        while(cutIndex < last && sequence[cutIndex] <= rootValue){
            cutIndex ++;
        }
        
        // ֻҪ����������һ��ֵС�ڸ��ڵ� ��ô�Ͳ��Ǻ�������Ľ��
        while(cutIndex < last){
            if(sequence[cutIndex] < rootValue){
                return false;
            }
            cutIndex ++;
        }
        
        return verify(sequence, first, cutIndex -1) && verify(sequence, cutIndex, last);
    }
}