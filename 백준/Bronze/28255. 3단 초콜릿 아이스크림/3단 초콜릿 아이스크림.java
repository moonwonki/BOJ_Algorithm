import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());


        for (int i = 0; i < testNum; i++){


            if(checkThreeIce(br.readLine())){
                System.out.println(1);
            }
            else System.out.println(0);
        }
    }


    public static boolean checkThreeIce(String S) {

        int n = S.length();
        int sprimeLength = (n + 2) / 3; // n/3보다 크거나 같은 최소의 정수인 Sprime의 길이

        // Sprime 생성
        String sprime = S.substring(0, sprimeLength);

        // Sprime의 reverse 생성
        String sprimeReverse = new StringBuilder(sprime).reverse().toString();

        // 조건 확인
        String condition1 = sprime + sprimeReverse + sprime;
        String condition2 = sprime + sprimeReverse + sprime.substring(1);
        String condition3 = sprime + sprimeReverse.substring(1) + sprime;
        String condition4 = sprime + sprimeReverse.substring(1) + sprime.substring(1);

        boolean satisfiesCondition = S.equals(condition1) || S.equals(condition2)
                || S.equals(condition3) || S.equals(condition4);

        // 조건을 만족하는지 여부 출력
        if (satisfiesCondition) {
            return true;
        } else {
            return false;
        }
    }
}