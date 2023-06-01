import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int parentArr[];
    static int depth[];
    static List<Integer> nodeList[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parentArr = new int[N + 1];
        depth = new int[N + 1];
        nodeList = new ArrayList[N + 1];
        visited = new boolean[N + 1];


        for (int i = 0; i < N + 1; i++){
            nodeList[i] = new ArrayList<>();
        }

        int first, second;
        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            nodeList[first].add(second);
            nodeList[second].add(first);
        }

        listToTree(1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++){

            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            while (depth[first] != depth[second]) {    // depth가 같지 않다면
                if (depth[first] > depth[second])    // 더 큰 depth의 부모를 찾아 올라간다.
                    first = parentArr[first];
                else
                    second = parentArr[second];
            }

            while (first != second) {        // depth가 같다면 공통 조상을 찾을 때 까지 부모를 찾아 올라간다.
                first = parentArr[first];
                second = parentArr[second];
            }
            System.out.println(first);
        }
    }


    public static void listToTree(int vertex, int depthCount){

        visited[vertex] = true;
        depth[vertex] = depthCount;

        for (Integer next : nodeList[vertex]) {
            if (!visited[next]) {
                parentArr[next] = vertex;    // 부모 정점을 저장.
                listToTree(next, depthCount + 1);    // DFS 마저 탐색
            }
        }
    }
}
