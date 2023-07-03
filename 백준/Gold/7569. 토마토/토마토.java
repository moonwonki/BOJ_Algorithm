import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dx[] = {1, -1, 0, 0, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        // value set
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int map[][][] = new int[h][n][m];
        boolean visited[][][] = new boolean[h][n][m];
        Queue<int[]> qu = new LinkedList<>();


        //get input
        for (int z = 0; z < h; z++){
            for (int y = 0; y < n; y++){
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++){
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                    if (map[z][y][x] == 1){
                        qu.add(new int[] {z, y, x, 1});
                    }
                }
            }
        }

        //bfs
        while (!qu.isEmpty()){
            int current[] = qu.poll();

            int curZ = current[0];
            int curY = current[1];
            int curX = current[2];

            if (visited[curZ][curY][curX]) continue;
            visited[curZ][curY][curX] = true;
            map[curZ][curY][curX] = current[3];

            for (int d = 0; d < 6; d++){
                int nz = curZ + dz[d];
                int ny = curY + dy[d];
                int nx = curX + dx[d];

                //map boundary check
                if (nz < 0 || nz >= h || ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                //visit check
                if (visited[nz][ny][nx]) continue;
                //empty cell check
                if (map[nz][ny][nx] == -1) continue;

                qu.add(new int[] {nz, ny, nx, current[3] + 1});
            }
        }




        //check
        int result = 0;
        boolean isItEmpty = false;
        for (int z = 0; z < h; z++){
            for (int y = 0; y < n; y++){
                for (int x = 0; x < m; x++){
                    if (isItEmpty) break;
                    result = Math.max(result, map[z][y][x]);
                    if (map[z][y][x] == 0){
                        isItEmpty = true;
                        break;
                    }
                }
                if (isItEmpty) break;
            }
            if (isItEmpty) break;
        }


        //print
        if (isItEmpty) result = -1;
        else result -= 1;
        System.out.println(result);

    }
}
