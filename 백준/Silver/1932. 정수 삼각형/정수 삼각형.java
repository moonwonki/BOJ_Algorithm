import java.util.*;

import static java.lang.Integer.parseInt;
import java.io.*;

public class Main {

    static int dp[][];
    static int height;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        height = Integer.parseInt(br.readLine());

        dp = new int[height][height];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/*
*
* *
* * *
* * * *
 */
        for (int y = 1; y < height; y++){
            for (int x = 0; x <= y; x++){
                if (x == 0){
                    dp[y][x] = dp[y][x]+dp[y-1][x];
                    continue;
                }
                else if (x == y){
                    dp[y][x] = dp[y][x] + dp[y-1][x-1];
                    continue;
                }
                dp[y][x] = dp[y][x] + Math.max(dp[y-1][x], dp[y-1][x-1]);
            }
        }

        int result = 0;
        for (int i = 0; i < height; i++){
            if (result < dp[height-1][i])
                result = dp[height-1][i];
        }
        System.out.println(result);
    }


}