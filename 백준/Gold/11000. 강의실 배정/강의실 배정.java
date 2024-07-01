import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받는 파트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int classNum = Integer.parseInt(br.readLine());
        ArrayList<int[]> classList = new ArrayList<>();

        for (int i = 0; i < classNum; i++){
            st = new StringTokenizer(br.readLine());
            int[] classVar = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            classList.add(classVar);
        }

        Collections.sort(classList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        // 풀이
        PriorityQueue<Integer> finishedTimePQ = new PriorityQueue<>();

        finishedTimePQ.add(classList.get(0)[1]);

        for (int i = 1; i < classNum; i++){
            if (finishedTimePQ.peek() <= classList.get(i)[0]){
                finishedTimePQ.poll();
            }
            finishedTimePQ.add(classList.get(i)[1]);
        }
        bw.write(Integer.toString(finishedTimePQ.size()));
        bw.flush();
    }
}