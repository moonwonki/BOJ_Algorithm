

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean map[][];
    static ArrayList<Integer> resultList;
    static ArrayList<Integer> compareList;
    static boolean visited[][];

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());


        for (int t = 0; t < testNum; t++){
            map = new boolean[3][3];
            visited = new boolean[3][3];
            resultList = new ArrayList<>();
            compareList = new ArrayList<>();
            String line;
            for (int height = 0; height < 3; height++){
                line = br.readLine();
                for (int width = 0; width < 3; width++){
                    if (line.charAt(width) == 'O') map[height][width] = true;
                }

            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int numberOfNums = Integer.parseInt(st.nextToken());
            for (int i = 0 ; i < numberOfNums; i++){
                compareList.add(Integer.parseInt(st.nextToken()));
            }

            for (int y = 0; y < 3; y++){
                for (int x = 0; x < 3; x++){
                    if (visited[y][x]) continue;
                    if (map[y][x]) bfsCheck(y, x);
                }
            }

            resultList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            if (resultList.size() != compareList.size()) System.out.println(0);
            else {
                boolean result = true;
                for (int index = 0; index < resultList.size(); index++){
                    if (resultList.get(index) != compareList.get(index)){
                        result = false;
                    }
                }

                if (result) System.out.println(1);
                else System.out.println(0);
            }



        }
    }

    public static void bfsCheck(int curY, int curX){
        int count = 0;
        Queue<int[]> qu = new LinkedList<>();

        qu.add(new int[] {curY, curX});

        while (!qu.isEmpty()){
            int nowState[] = qu.poll();

            if (visited[nowState[0]][nowState[1]]) continue;
            visited[nowState[0]][nowState[1]] = true;
            count++;
            for (int i = 0; i < 4; i++){
                int ny = nowState[0] + dy[i];
                int nx = nowState[1] + dx[i];
                if (ny < 0 || ny >= 3 || nx < 0 || nx >= 3) continue;
                if (!map[ny][nx]) continue;
                if (visited[ny][nx]) continue;

                qu.add(new int[] {ny,nx});
            }
        }

        resultList.add((Integer) count);
    }




}
