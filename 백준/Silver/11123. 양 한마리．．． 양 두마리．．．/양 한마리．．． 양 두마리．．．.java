import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int mapY;//목장의 y 길이 (y는 세로)
    static int mapX;//목장의 x 길이 (x는 가로)
    static boolean map[][];//목장
    static boolean visited[][];//방문한 곳 표시
    static int sequence;//결과값.
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};


    /*
    map을 boolean의 2차원 배열로 만든 후,
    양을 true, 양이 없는 곳을 false로 해서 기록한다.
    (Int 배열도 가능)

    그 후에 map을 (0, 0)에서 끝까지 차례로 지나가면서 양을 발견한다.
    아직 방문하지 않은 새로운 양을 발견한다면 BFS 메소드를 호출하고 발견 좌표를 넘겨준다.

    BFS 메소드가 하는 일은 간단하다. 일단 sequence 변수를 1개 올려준다. 이것은 한 무리의 양을 발견했다는 의미이다.
    그리고 그 양에 연결된 모든 양들을 표시(visited) 처리한다. 이 과정에서 bfs 알고리즘이 쓰인다.

    끝까지 다 돌았다면 이제 sequence 변수의 값을 출력한다. sequence 변수는 한 무리의 새로운 양들을 발견할 때마다 값을 올려줬으니,
    전체 양무리의 개수와 같다.

    ---------------> 이제 이 과정을 각 테스트 케이스마다 반복한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //테스트 케이스 입력 받기
        int testCaseNum = Integer.parseInt(br.readLine());
        //테스트 케이스 개수 따라 반복 시작!
        for (int t = 0; t < testCaseNum; t++){
            st = new StringTokenizer(br.readLine());
            mapY = Integer.parseInt(st.nextToken());
            mapX = Integer.parseInt(st.nextToken());
            map = new boolean[mapY][mapX];//양이 있는 곳은 True, 없으면 false

            //입력받아서 map 변수 채우기
            for (int y = 0; y < mapY; y++){
                String s = br.readLine();
                for (int x = 0; x < mapX; x++){
                    if(s.charAt(x) == '#') map[y][x] = true;
                    else map[y][x] = false;
                }
            }

            //sequence와 visited 같은 결과 산출에 필요한 변수들 값 초기화
            sequence = 0;
            visited = new boolean[mapY][mapX];


            //맵 전체를 뒤져서 '아직 발견하지 않은' 양을 발견한다면 냅다 bfs를 돌린다.
            for (int y = 0; y < mapY; y++){
                for (int x = 0; x < mapX; x++){
                    if (map[y][x] && !visited[y][x]) bfs(y, x);
                }
            }

            System.out.println(sequence);
        }

    }

    private static void bfs(int startY, int startX) {
        //이곳에 왔다는 것은 새로운 양을 한마리 발견했다는 것이다. 이제 이 양 또는 이 양에 연결된 모든 양들을 하나의 무리로 보고 연결된 양들을 전부 방문 처리해줄 것이다.
        //일단 양 무리를 하나 찾은 셈이므로 sequence++ 해준다.
        sequence++;
        //bfs에 필요한 Queue
        Queue<int[]> qu = new LinkedList<>();
        //초기값을 더한다.
        qu.add(new int[]{startY, startX});

        //qu가 비게 될 때까지 반복.
        while (!qu.isEmpty()){
            //현재 좌표 구하기
            int curY = qu.peek()[0];
            int curX = qu.poll()[1];

            //방문 여부 확인하기
            if (visited[curY][curX]) continue;
            visited[curY][curX] = true;

            //4가지 방위 방문조사하기
            for (int i = 0; i < 4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= mapY || nx < 0 || nx >= mapX) continue;//맵의 경계값을 넘어가는가?
                if (!map[ny][nx]) continue;//양이 있는가?
                if (visited[ny][nx]) continue;//방문한 곳인가?
                qu.add(new int[] {ny, nx});//전부 아니라면 qu에 넣어서 다음 번 방문 대기열에 넣어준다.
            }
        }
    }
}