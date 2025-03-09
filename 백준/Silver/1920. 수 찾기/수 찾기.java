import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //백준
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int numSize = Integer.parseInt(br.readLine());

        int[] numArray = new int[numSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSize; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArray);

        int findNumSize = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < findNumSize; i++){
            boolean findResult = false;
            int findNum = Integer.parseInt(st.nextToken());

            int lo = 0;
            int hi = numSize - 1;

            while (lo <= hi){
                int mid = (lo + hi) / 2;

                if (findNum > numArray[mid]){
                    lo = mid + 1;
                }
                else if (findNum < numArray[mid]){
                    hi = mid - 1;
                }
                else {
                    findResult = true;
                    break;
                }
            }

            if (findResult) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

