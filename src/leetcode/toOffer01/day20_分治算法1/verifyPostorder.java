package leetcode.toOffer01.day20_分治算法1;
/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 */

//遍历顺序左右根
public class verifyPostorder {
    int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder=postorder;
        Integer left=null;
        Integer right=null;
        for (int i = postorder.length-1; i >=0; i--) {
            if(postorder[i]<postorder[postorder.length-1]){
                left=i;
                break;
            }
        }
        for (int i = postorder.length-1; i >=0; i--) {
            if(postorder[i]>postorder[postorder.length-1]){
                right=i;
                break;
            }
        }
        return subVerify(postorder.length-1, left,right );
    }

    public boolean subVerify(int root,Integer left,Integer right){

        if(left==null&&right==null)
            return true ;
        if(left!=null&&right!=null&&left>right)
            return false;
        Integer left_left=null;
        Integer left_right=null;
        Integer right_left=null;
        Integer right_right=null;


        if(left!=null){
            for (int i = left-1; i >=0; i--) {
                if(postorder[i]>postorder[root]){
                    return false;
                }
            }
            for (int i = left-1; i >=0; i--) {
                if(postorder[i]<postorder[left-1]){
                    left_left=i;
                    break;
                }
            }
            for (int i = left-1; i >=0; i--) {
                if(postorder[i]>postorder[left-1]){
                    left_right=i;
                    break;
                }
            }
        }

        if(right!=null){

            for (int i = right-1; i >=(left==null?0:left+1); i--) {
                if(postorder[i]<postorder[root]){
                    return false;
                }
            }
            for (int i = right-1; i >=(left==null?0:left+1); i--) {
                if(postorder[i]<postorder[right-1]){
                    right_left=i;
                    break;
                }
            }
            for (int i = right-1; i >=(left==null?0:left+1); i--) {
                if(postorder[i]>postorder[right-1]){
                    right_right=i;
                    break;
                }
            }
        }

        return subVerify(left,left_left,left_right)&&subVerify(right,right_left,right_right);
    }
}
