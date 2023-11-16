package leetcode.toOffer01.day14_搜索与回溯3;
/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
 */
public class movingCount {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        int i = dfs1(visited,m, n, k, 0, 0);
        return i;
    }
    int dfs1(boolean[][] visited,int m,int n,int k,int i,int j){
        //访问过的格子，越界的格子和不满足条件的格子都直接返回为0
        if(i >= m || i < 0 || j >= n || j < 0 ||dfs(i,j,k)==false||visited[i][j])
            return 0;
        visited[i][j]=true;
        //根据观察，不会走回头路，只需要往右和往下进行继续的查询
        return 1+dfs1(visited,m,n,k,i+1,j)+dfs1(visited,m,n,k,i,j+1);

    }

    boolean dfs( int m, int n, int k) {
        int count=0;
        while (m>0){
            count+=m%10;
            m=m/10;
        }

        while (n>0){
            count+=n%10;
            n=n/10;
        }

        if(count<=k){

            return true;

        }
        return false;



    }

}
