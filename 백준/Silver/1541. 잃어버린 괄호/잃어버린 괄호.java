import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        //분리
        String[] inputArray = input.split("-");

        //연산
        boolean start = true;
        int result = 0;
        for (int i = 0; i < inputArray.length; i++){
            String[] currentNum = inputArray[i].split("\\+");
            int sumOfCurrentNum = 0;
            for (int j = 0; j < currentNum.length; j++){
                sumOfCurrentNum += Integer.parseInt(currentNum[j]);
            }
            if (start) {
                start = false;
                result = sumOfCurrentNum;
            }
            else result -= sumOfCurrentNum;
        }

        System.out.println(result);


    }
}