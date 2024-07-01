import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받는 파트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int meetingNum = Integer.parseInt(br.readLine());

        ArrayList<int[]> meetingList = new ArrayList<>();

        for (int i = 0; i < meetingNum; i++){
            st = new StringTokenizer(br.readLine());
            int[] meeting = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            meetingList.add(meeting);
        }

        // 풀이
        Collections.sort(meetingList, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int availableMeetingCount = 0;
        int currentTime = 0;
        for (int i = 0; i < meetingNum; i++){
            if (currentTime <= meetingList.get(i)[0]){
                availableMeetingCount++;
                currentTime = meetingList.get(i)[1];
            }
        }
        bw.write(Integer.toString(availableMeetingCount));
        bw.flush();
    }

}
