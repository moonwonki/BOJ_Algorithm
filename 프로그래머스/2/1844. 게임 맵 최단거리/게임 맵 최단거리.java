import java.util.*;

class Solution {
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public int solution(int map[][]) {
        int mapX = map[0].length;
        int mapY = map.length;
    
        
        
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[] {0,0,1});
        while (!qu.isEmpty()){
            int current[] = qu.poll();
            if (current[0] == mapX - 1 && current[1] == mapY - 1){
                return current[2];
            }
            for (int i = 0; i < 4; i++){
                int newY = current[1] + dy[i];
                int newX = current[0] + dx[i];
                
                if (newY < 0 || newY >= mapY || newX < 0 || newX >= mapX || map[newY][newX] == 0) continue;
                map[newY][newX] = 0;
                
                qu.offer(new int[] {newX, newY, current[2] + 1});
            }
        }
        return -1;
    }
}