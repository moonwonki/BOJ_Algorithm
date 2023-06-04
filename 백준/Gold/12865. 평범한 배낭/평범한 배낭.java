
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Main {
    static int thingNum;
    static int dp[];
    static int weightLimit;
    static int things[][];

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        thingNum = scn.nextInt();
        weightLimit = scn.nextInt();
        things = new int[thingNum+1][2];
        dp = new int[weightLimit+1];
        for (int i = 1; i <= thingNum; i++){
            int tmp1 = scn.nextInt();
            int tmp2 = scn.nextInt();
            things[i] = new int[] {tmp1, tmp2};
        }
        dp[0] = 0;
        for (int i = 1; i <= thingNum; i++){
            for (int j = weightLimit; j >= things[i][0]; j--){
                dp[j] = Math.max(dp[j], dp[j - things[i][0]] + things[i][1]);
            }
        }

        System.out.println(dp[weightLimit]);
    }
}