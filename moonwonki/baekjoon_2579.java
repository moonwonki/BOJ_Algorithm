package org.example.BOJ_Algorithm.moonwonki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairsNum = Integer.parseInt(br.readLine());

        int dp[] = new int[stairsNum];
        int stairs[] = new int[stairsNum];

        for (int i = 0; i < stairsNum; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (stairsNum == 1) {
            System.out.println(stairs[0]);
            return;
        }
        else if (stairsNum == 2){
            System.out.println(stairs[0] + stairs[1]);
            return;
        }


        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        for (int i = 3; i < stairsNum; i++){
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[stairsNum-1]);
    }
}
