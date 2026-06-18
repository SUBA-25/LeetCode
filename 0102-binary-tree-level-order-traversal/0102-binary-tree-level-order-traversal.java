class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>>levelorder=new ArrayList<>();
        pre(root,0,levelorder);
        return levelorder;
    }
    public static void pre(TreeNode root,int l,List<List<Integer>>levelorder)
    {
        if(root==null)
            return;
        if(levelorder.size()==l)
        {
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            levelorder.add(li);
        }
        else
            levelorder.get(l).add(root.val);
        pre(root.left,l+1,levelorder);
        pre(root.right,l+1,levelorder);
    } 
}