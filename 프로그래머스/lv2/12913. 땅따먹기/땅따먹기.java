class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int len = land.length;
        
        int dp[][] = new int[len][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for (int i = 1; i < len; i++){
            for (int j = 0; j < 4; j++){
                int max = 0;
                for (int k = 0; k < 4; k++){
                    if (k == j) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        
        int max = 0;
        for (int i = 0; i < 4; i++){
            max = Math.max(max, dp[len - 1][i]);
        }

        return max;
    }
}