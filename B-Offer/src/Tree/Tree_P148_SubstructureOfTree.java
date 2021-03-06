package Tree;

//树的子结构:输入两棵二叉树A和B，判断B是不是A的子结构。
//则需要从A的那个节点开始严格匹配，对应于下面的tree1HasTree2FromRoot函数。
// 如果匹配不成功，则返回到开始匹配的那个节点，对它的左右子树继续判断是否与B的根节点值相同，重复上述过程。
public class Tree_P148_SubstructureOfTree {
    public static boolean HasSubtree(TreeNode<Integer> root1, TreeNode<Integer> root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val.equals(root2.val))
                result = DoseTree1HasTree2(root1, root2);
            if(!result)
                result = HasSubtree(root1.left, root2);
            if(!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }
    public static boolean DoseTree1HasTree2(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root2 == null)
            return true;//root2遍历完
        if(root1 == null)
            return false;
        if(!root1.val.equals(root2.val))//不同肯定为false
            return false;
        return DoseTree1HasTree2(root1.left,root2.left)
                &&DoseTree1HasTree2(root1.right,root2.right);
    }
    public static void main(String[] args){
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(7);
        root1.left.left = new TreeNode<>(9);
        root1.left.right = new TreeNode<>(2);
        root1.left.right.left = new TreeNode<>(4);
        root1.left.right.right = new TreeNode<>(7);
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(9);
        root2.right = new TreeNode<>(2);
        TreeNode<Integer> root3 = new TreeNode<>(2);
        root3.left = new TreeNode<>(4);
        root3.right = new TreeNode<>(3);
        System.out.println(HasSubtree(root1,root2));
        System.out.println(HasSubtree(root1,root3));
    }
}
