import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();

        int length = 3;
        int reps = 0;


        while (length < N) {
            //처음 만드는 수열은 S(1)이니 증가시키고 시작.
            reps++;

            length = length * 2 + (reps + 3);
        }

        N--;
        while (true){
            int midIndex = (length - (reps + 3)) / 2;
            int lastIndex = (length - (reps + 3)) / 2 + reps + 3;

            if (N == midIndex){
                System.out.println("m");
                return;
            }
            else if (midIndex < N && N < lastIndex){
                System.out.println("o");
                return;
            }
            else if (N >= lastIndex){
                N -= lastIndex;
                length -= lastIndex;
            }
            else {
                length -= reps + 3;
                length -= midIndex;
            }
            reps--;
        }

    }
}