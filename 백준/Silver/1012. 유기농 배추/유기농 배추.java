import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for (int test = 0; test < testCaseNum; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int mapY = Integer.parseInt(st.nextToken());
            int mapX = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[mapY][mapX];
            int cabbageNum = Integer.parseInt(st.nextToken());

            for (int i = 0; i < cabbageNum; i++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            boolean[][] checked = new boolean[mapY][mapX];

            int count = 0;
            for (int y = 0; y < mapY; y++){
                for (int x = 0; x < mapX; x++){
                    if (map[y][x] && !checked[y][x]){
                        count++;
                        Queue<int[]> qu = new LinkedList<>();

                        qu.add(new int[] {y, x});

                        while (!qu.isEmpty()){
                            int current[] = qu.poll();
                            for (int i = 0; i < 4; i++){
                                int ny = current[0] + dy[i];
                                int nx = current[1] + dx[i];

                                if (ny < 0 || ny >= mapY) continue;
                                if (nx < 0 || nx >= mapX) continue;
                                if (!map[ny][nx]) continue;
                                if (checked[ny][nx]) continue;

                                checked[ny][nx] = true;
                                qu.add(new int[] {ny, nx});
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
