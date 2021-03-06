package Tree;
//.二叉搜索树的后序遍历
//题目要求：
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，假设输入数组的任意两个数都互不相同。
public class Tree_P179_SequenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return VerifyBST(sequence, 0, sequence.length-1);
    }
//    public static boolean VerifyBST(int [] sequence, int start,int end){
//        if(end-start <= 1) {
//            return true;
//        }
//        int index = -1;
//        for(int i = start; i < end; i++){
//            if(sequence[i] > sequence[end]){
//                index = i;
//                break;
//            }
//        }
//        for(int right = index; right<end; right++){
//            if(sequence[right] < sequence[end]){
//                return false;
//            }
//        }
//        return VerifyBST(sequence, start,index-1)&&VerifyBST(sequence,index,end - 1);
//    }
       public static boolean VerifyBST(int [] sequence, int start,int end){
        if(end-start <= 1) {
            return true;
        }
        int i;
        for(i = start; i < end; i++){
            if(sequence[i] > sequence[end]){
                break;
            }
        }
        for(int right = i; right<end; right++){
            if(sequence[right] < sequence[end]){
                return false;
            }
        }
        return VerifyBST(sequence, start,i-1)&&VerifyBST(sequence,i,end - 1);
    }
    public static void main(String[] args){
        int[] sequence = {1,2,3,4,5};
        System.out.print(VerifySquenceOfBST(sequence));
    }
}
