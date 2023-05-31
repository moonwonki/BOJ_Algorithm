import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numAmount = scn.nextInt();

        int numArr[] = new int[numAmount];

        int result = 0;
        for (int i = 0; i < numAmount; i++){
            numArr[i] = scn.nextInt();
            if (isPrime(numArr[i])) result++;
        }

        System.out.println(result);


    }

    public static boolean isPrime(int num){
        if (num <= 1) return false;
        for (int i = 2; i <= num - 1; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}
