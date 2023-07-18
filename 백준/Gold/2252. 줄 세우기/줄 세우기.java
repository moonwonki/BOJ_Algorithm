import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int students = Integer.parseInt(st.nextToken());
        int compares = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < students + 1; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < compares; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList.get(start).add(end);
        }

        // 1. 진입 차수 정리
        int[] inDegrees = new int[students + 1];
        for (List<Integer> neighbors : adjList){
            for (int neighbor : neighbors){
                inDegrees[neighbor]++;
            }
        }

        // 2. 진입 차수에 따른 첫 정점 정하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < students + 1; i++){
            if (inDegrees[i] == 0) queue.offer(i);
        }


        // 3. Queue를 이용. 위상정렬 진행
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adjList.get(node)){
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // 정답 출력
        StringBuilder answer = new StringBuilder();
        for (int node : result) answer.append(node).append(' ');
        System.out.println(answer);
    }
}


