import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());

        int[] operationTimeArray = new int[inputNum + 1];
        for (int i = 0; i <= inputNum; i++) operationTimeArray[i] = Integer.MAX_VALUE;
        operationTimeArray[1] = 0;
        for (int i = 1; i <= inputNum; i++){
            if (i + 1 <= inputNum)
                operationTimeArray[i + 1] = Math.min(operationTimeArray[i] + 1, operationTimeArray[i + 1]);
            if (i * 2 <= inputNum)
                operationTimeArray[i * 2] = Math.min(operationTimeArray[i] + 1, operationTimeArray[i * 2]);
            if (i * 3 <= inputNum)
                operationTimeArray[i * 3] = Math.min(operationTimeArray[i] + 1, operationTimeArray[i * 3]);
        }


        System.out.println(operationTimeArray[inputNum]);

    }
}
