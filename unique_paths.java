// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 0;
        dp=new int[m][n];
        return dfs(0,0,m,n);
    }
    
    private int dfs(int i,int j,int m,int n){
        //base
        if(i==m ||j==n){
            return 0;
        }
        if(i==m-1 ||j==n-1){
            return 1;
        }
        //logic
        int right=0;
        if(j+1 < n){
            if(dp[i][j+1] != 0){
                right=dp[i][j+1];
            }
            else{
                right=dfs(i,j+1,m,n);
            }
            dp[i][j+1]=right;
        }
        int bottom=0;
        if(i+1 < m){
            if(dp[i+1][j] != 0){
                bottom=dp[i+1][j];
            }
            else{
                bottom=dfs(i+1,j,m,n);
            }
            dp[i+1][j]=bottom;
        }
        return right+bottom;
    }
}