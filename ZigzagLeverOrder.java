package Algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLeverOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        boolean isRight = true;

        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> layer = new ArrayList();
            int size = q.size();
            Stack<TreeNode> s = new Stack();
            for(int i = 0; i < size; i++){
                s.push(q.poll());
            }
            for(int i = 0; i < size; i++){
                TreeNode tmp = s.pop();
                layer.add(tmp.val);
                if(isRight){
                    if(tmp.left != null) q.add(tmp.left);
                    if(tmp.right != null) q.add(tmp.right);
                }else{
                    if(tmp.right != null) q.add(tmp.right);
                    if(tmp.left != null) q.add(tmp.left);
                }
            }
            result.add(layer);
            isRight = !isRight;
        }

        return result;
    }


}
