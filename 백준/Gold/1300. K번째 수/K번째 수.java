import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();

        long low = 1;
        long high = K;

        while (low < high){
            long count = 0;
            long mid = (low + high) / 2;

            for (int i = 1; i <= N; i++){
                long rowDevide = mid / i;
                if (rowDevide >= N) rowDevide = N;
                count += rowDevide;
            }

            if (count >= K){
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
