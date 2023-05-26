package org.example.BOJ_Algorithm.moonwonki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11501 {
    //그리디 알고리즘 문제.
    //최고의 경우의 수만 모은다!
    //최고의 경우의 수 : 가장 비쌀 때에만 파는 것!
    public static void main(String[] args) throws IOException {
        //입력 받는 변수 준비.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCaseNum = Integer.parseInt(br.readLine());


        for (int t = 0; t < testCaseNum; t++) {
            //입력 받기.
            int dayLimit = Integer.parseInt(br.readLine());
            long stock[] = new long[dayLimit];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < dayLimit; i++){
                stock[i] = Long.parseLong(st.nextToken());
            }

            //그리디 알고리즘 계산.
            long sum = 0;
            long max = 0;
            //마지막 날부터 최고가를 찾는다
            //마지막 날부터 역으로 처음 시작일까지 건너간다.
            //최고가를 갱신한다면! max 변수를 바꿔준다.
            //최고가보다 낮다면 그날 한개 사서 최고가에서 파는 것이기 때문에 sum에 max - 그날 가격을 더해준다.
            for (int i = dayLimit - 1; i >= 0; i--){
                if (max < stock[i])
                    max = stock[i];
                else
                    sum += max - stock[i];
            }
            System.out.println(sum);

        }

    }
}
