import java.util.*;

public class Main {
    static ArrayList<Integer> strangePrime;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        strangePrime = new ArrayList<>();


        dfs(N, 0, 0);

        for (int i = 0; i < strangePrime.size(); i++){
            System.out.println(strangePrime.get(i));
        }
    }

    public static void dfs(int N, int number, int count){
        if (!checkPrime(number)){
            return;
        }

        if (count == N) {
            strangePrime.add(number);
            return;
        }

        for (int i = 1; i <= 9; i ++){
            if (count == 0 && i == 1) continue;
            dfs(N, number * 10 + i, count + 1);
        }
    }

    private static boolean checkPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }
        return true;
    }




}