package leetcode.代码随想录.回溯算法;

import java.util.*;

public class combinationSum2 {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    boolean[] used;
    HashSet<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used=new boolean[candidates.length];
        Arrays.fill(used,false);
        backtrack(candidates,target,0,0);


        return res;
    }


    void backtrack(int[] candidates,int n,int sum,int start){
        if(sum==n&&!set.contains(temp)){
            res.add(new ArrayList<>(temp));
            set.add(new ArrayList<>(temp));
            sum=0;
            return;
        }
        if(sum>n){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(sum+candidates[i]>n){//剪枝操作
                break;
            }
            if(i>0&&candidates[i]==candidates[i-1]&&!used[i-1]){//对同一树层进行剪枝
                continue;
            }
            used[i]=true;
            temp.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,n,sum,i+1);
            used[i]=false;
            sum-=candidates[i];
            temp.removeLast();
        }

    }
}
