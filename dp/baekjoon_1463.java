package org.example.BOJ_Algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        if (number == 1){
            System.out.println(0);
            return;
        }
        if (number == 2) {
            System.out.println(1);
            return;
        }
        int dp[] = new int[number+1];

        Arrays.fill(dp, -1);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 2; i <= number; i++){
            //반드시 범위 검사 구문을 먼저 넣어줘야 한다.
            //범위 안에 있는가? && (해당 값이 아직 채워지지 않았나? || 채우려는 값보다 큰 값으로 채워져 있나?)
            if (i * 2 <= number && (dp[i * 2] == -1 || dp[i * 2] > dp[i] + 1)) dp[i * 2] = dp[i] + 1;
            if (i * 3 <= number && (dp[i * 3] == -1 || dp[i * 3] > dp[i] + 1)) dp[i * 3] = dp[i] + 1;
            if (i + 1 <= number && (dp[i + 1] == -1 || dp[i + 1] > dp[i] + 1)) dp[i + 1] = dp[i] + 1;
        }

        System.out.println(dp[number]);

    }
}
