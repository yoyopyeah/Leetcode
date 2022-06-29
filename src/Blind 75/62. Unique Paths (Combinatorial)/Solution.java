// package Blind 75.62. Unique Paths (Combinatorial);

public class Solution {

    // math solution: combination
    public int uniquePaths1(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
    
    // DP
    public int uniquePaths2(int cols, int rows) {
        int[][] dp = new int[rows][cols];
        
        for(int row=0;row<rows;row++)
            dp[row][0] = 1;
        
        for(int col=0;col<cols;col++)
            dp[0][col] = 1;
        
        for(int i=1;i<rows;i++)
            for(int j=1;j<cols;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        
        return dp[rows-1][cols-1];
    }

    // The above solution runs in O(m * n) time and costs O(m * n) space. However, you may have noticed that each time when we update dp[i][j], we only need dp[i - 1][j] (at the previous row) and dp[i][j - 1] (at the current row). So we can reduce the memory usage to just two rows (O(n)).
    public int uniquePaths3(int cols, int rows) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];
        
        for(int i=0;i<cols;i++){
            pre[i] = 1;
            cur[i] = 1;            
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++)
                cur[j] = cur[j-1] + pre[j];
            
            pre = cur;
        }
        
        return cur[cols-1];
    }

    public int uniquePaths(int cols, int rows) {
        int[] cur = new int[cols];
                
        for(int i=0;i<cols;i++)
            cur[i] = 1;            
        
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++)
                cur[j] = cur[j-1] + cur[j];
        } 
        return cur[cols-1];
    }
}
