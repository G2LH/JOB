package Tree;
//平衡二叉树
//题目要求：
//输入二叉树的根节点，判断该树是否是平衡二叉树
public class Tree_P273_isBalanced {
    //1.从根节点开始判断
    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if((left-right) > 1 || (right - left) > 1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public static int TreeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
    //2.后序遍历
    public static boolean IsBalanced2(TreeNode root){
        if(root==null){
            return true;
        }
        return Depth(root)!=-1;
    }
    public static int Depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Depth(node.left);
        int right = Depth(node.right);
        if((left-right) > 1 || (right-left) >1){
            return -1;
        }
        return left>right?left+1:right+1;
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(isBalanced(root));
        //System.out.println(isBalanced2(root));
    }
}
