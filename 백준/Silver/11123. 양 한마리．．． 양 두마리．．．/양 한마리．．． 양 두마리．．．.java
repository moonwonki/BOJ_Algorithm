import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int mapY;
    static int mapX;
    static boolean map[][];
    static boolean visited[][];
    static int sequence;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaseNum; t++){
            st = new StringTokenizer(br.readLine());
            mapY = Integer.parseInt(st.nextToken());
            mapX = Integer.parseInt(st.nextToken());
            map = new boolean[mapY][mapX];//양이 있는 곳은 True, 없으면 false

            for (int y = 0; y < mapY; y++){
                String s = br.readLine();
                for (int x = 0; x < mapX; x++){
                    if(s.charAt(x) == '#') map[y][x] = true;
                    else map[y][x] = false;
                }
            }

            sequence = 0;
            visited = new boolean[mapY][mapX];


            for (int y = 0; y < mapY; y++){
                for (int x = 0; x < mapX; x++){
                    if (map[y][x] && !visited[y][x]) bfs(y, x);
                }
            }

            System.out.println(sequence);
        }

    }

    private static void bfs(int startY, int startX) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{startY, startX});
        sequence++;
        while (!qu.isEmpty()){
            int curY = qu.peek()[0];
            int curX = qu.poll()[1];

            if (visited[curY][curX]) continue;
            visited[curY][curX] = true;

            for (int i = 0; i < 4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= mapY || nx < 0 || nx >= mapX) continue;
                if (!map[ny][nx]) continue;
                if (visited[ny][nx]) continue;
                qu.add(new int[] {ny, nx});
            }
        }
    }
}
