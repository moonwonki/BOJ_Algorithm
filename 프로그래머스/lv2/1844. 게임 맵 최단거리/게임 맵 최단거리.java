import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public int solution(int map[][]) {
        int mapY = map.length;
        int mapX = map[0].length;
        Queue<int[]> qu = new LinkedList<>();
        boolean visited[][] = new boolean[mapY][mapX];



        qu.add(new int[] {0, 0, 1});
        int result = 0;

        while (!qu.isEmpty()){
            int current[] = qu.poll();

            int curY = current[0];
            int curX = current[1];
            int count = current[2];
            if (visited[curY][curX]) continue;
            visited[curY][curX] = true;

            if (curY == mapY-1 && curX == mapX-1) {
                result = count;
                break;
            }

            for (int i = 0; i < 4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= mapY || nx < 0 || nx >= mapX) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                qu.add(new int[] {ny, nx, count+1});
            }
        }
        if (result == 0) return -1;
        return result;
    }
}