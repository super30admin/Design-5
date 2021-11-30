//Time complexity:- O(n).
//space complexity:- O(n).
//Did it run on leetcode:- Yes.
//What was the problem you faced while doing it?;- Tried using hashmap but difficulty in checking all elements.
//Code with approach is written in comments.



class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree=new int[n+1];
        int[] outdegree=new int[n+1];
        for(int[] rel:trust){
            int a=rel[0];
            int b=rel[1];
            indegree[a]=indegree[a]+1; // iterating for each row and in that row first element incrementing
                                    //indegree[of that number] and outdegree of second element element in row.
            outdegree[b]=outdegree[b]+1;
        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==0 && outdegree[i]==n-1){
                return i;          //The vertex with n-1 outdegrees and indegrees with 0 is returned.
            }
        }
        return -1;
        
    }
}