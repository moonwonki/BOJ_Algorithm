import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받는 파트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numberLine = br.readLine();
        Integer numArr[] = new Integer[numberLine.length()];

        // 풀이
        boolean zeroExists = false;
        int totalSum = 0;
        for (int i = 0; i < numberLine.length(); i++){
            numArr[i] = numberLine.charAt(i) - '0';
            if (numArr[i] == 0) zeroExists = true;
            totalSum += numArr[i];
        }

        if (!zeroExists) {
            bw.write("-1");
            bw.flush();
            return;
        }
        if (totalSum % 3 != 0 || totalSum == 0){
            bw.write("-1");
            bw.flush();
            return;
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(numArr, Collections.reverseOrder());

        for (int i = 0; i < numArr.length; i++){
            bw.write(Integer.toString(numArr[i]));
        }
        bw.flush();
    }

}
