package org.example.BOJ_Algorithm.moonwonki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_1967 {

    static ArrayList<int[]>[] tree;
    static int nodeNum;
    static int max;
    static boolean visited[];
    static int maxIdx;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        nodeNum = Integer.parseInt(br.readLine());

        tree = new ArrayList[nodeNum + 1];

        max = 0;

        for (int i = 0; i < nodeNum + 1; i++){
            tree[i] = new ArrayList<>();
        }


        for (int i = 0; i < nodeNum - 1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());



            tree[start].add(new int[] {finish, weight});
            tree[finish].add(new int[] {start, weight});
        }

        visited = new boolean[nodeNum + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[nodeNum + 1];
        visited[maxIdx] = true;
        dfs(maxIdx, 0);

        System.out.println(max);

    }


    public static void dfs(int idx, int currentLength){
        if (max < currentLength) {
            max = currentLength;
            maxIdx = idx;
        }

        for (int[] current : tree[idx]){
            int nextNode = current[0];
            int weightToNext = current[1];
            if (visited[nextNode]) continue;

            visited[nextNode] = true;
            dfs(nextNode, weightToNext + currentLength);
        }
    }
}
