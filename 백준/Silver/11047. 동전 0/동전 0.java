import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int coinValue[] = new int[N];
        for (int i = 0; i < N; i++){
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        int coinCount = 0;
        for (int i = N-1; i>= 0; i--){
            coinCount += K / coinValue[i];
            K %= coinValue[i];
        }


        bw.write(Integer.toString(coinCount));
        bw.flush();
    }

}
