
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lectures = Integer.parseInt(st.nextToken());
        int preReqs = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < lectures + 1; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < preReqs; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
        }

        // 1. 진입 차수 정리
        int[] inDegrees = new int[lectures + 1];
        for (List<Integer> neighbors : adjList){
            for (int neighbor : neighbors){
                inDegrees[neighbor]++;
            }
        }

        // 2. 진입 차수에 따른 첫 정점 정하기
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < lectures + 1; i++){
            if (inDegrees[i] == 0) queue.offer(new int[] {i, 1});
        }


        // 3. Queue를 이용. 위상정렬 진행
        int[] firstSem = new int[lectures + 1];
        while (!queue.isEmpty()){
            int[] lecture = queue.poll();
            int node = lecture[0];
            int semester = lecture[1];
            firstSem[node] = semester;

            for (int nextLec: adjList.get(node)){
                inDegrees[nextLec]--;
                if (inDegrees[nextLec] == 0){
                    queue.offer(new int[] {nextLec, semester + 1});
                }
            }
        }

        // 정답 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < lectures + 1; i++) answer.append(firstSem[i]).append(' ');
        System.out.println(answer);
    }
}


