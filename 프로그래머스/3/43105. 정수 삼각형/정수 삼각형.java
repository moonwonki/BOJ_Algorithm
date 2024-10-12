import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        
        
        for (int cur = 1; cur < height; cur++){
            for (int x = 1; x < cur; x++){
                triangle[cur][x] = Math.max(triangle[cur][x] + triangle[cur-1][x], triangle[cur][x] + triangle[cur-1][x-1]);
            }
            triangle[cur][0] += triangle[cur-1][0];
            triangle[cur][cur] += triangle[cur-1][cur - 1];
        }
        
        int max = 0;
        for (int i = 0; i < height; i++){
            max = Math.max(triangle[height-1][i], max);
        }
        
        return max;
    }
}