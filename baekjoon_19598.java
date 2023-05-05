package org.example.BOJ_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
/*
unsolved!
 */
public class baekjoon_19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] < o2[1]) return -1;
                else if (o1[1] == o2[1]) {
                    if (o1[0] > o2[0]) return 1;
                    else if (o1[0] < o2[0]) return -1;
                    return 0;
                }
                return 0;
            }
        });


        int meetingNum = Integer.parseInt(br.readLine());

        int start, finish;
        for (int i = 0; i < meetingNum; i++){
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            finish = Integer.parseInt(st.nextToken());

            pq.add(new int[] {start, finish});
        }

        int count = 1;
        int curEnd = pq.poll()[1];


        for (int i = 1; i < meetingNum; i++){
            if (pq.peek()[0] >= curEnd){
                count++;
                curEnd = pq.poll()[1];
            }
        }

        System.out.println(count);
    }
}
