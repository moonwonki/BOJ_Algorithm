
import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, M, K;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int maxTeam = 0;
        for (int i = 0; i <= K; i++){
            int girl = N - i;
            int boy = M - (K - i);

            int team = 0;
            while ((team + 1)* 2 <= girl && (team + 1) <= boy){
                team++;
            }

            maxTeam = Math.max(maxTeam, team);
        }

        bw.write(Integer.toString(maxTeam));
        bw.flush();
    }

}
