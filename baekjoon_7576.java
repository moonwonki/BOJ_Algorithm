package org.example.BOJ_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7576 {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        // Value Setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // bfs values
        int[][] map = new int[n][m];
        Queue<int[]> qu = new LinkedList();// for BFS
        boolean visited[][] = new boolean[n][m];

        // Input
        for (int y = 0; y < n; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1){
                    qu.add(new int[] {y, x, 1});// add tomatoes position to queue
                }
            }
        }

        //compute BFS
        while (!qu.isEmpty()){
            int current[] = qu.poll();
            int curX = current[1];
            int curY = current[0];

            if (visited[curY][curX]) continue;
            visited[curY][curX] = true;
            map[curY][curX] = current[2];

            for (int d = 0; d < 4; d++){
                int ny = curY + dy[d];
                int nx = curX + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == -1) continue;

                qu.add(new int[] {ny, nx, map[curY][curX] + 1});
            }
        }

        int result = 0;

        boolean thereIsZero = false;
        for (int y = 0; y < n; y++){
            for (int x = 0; x < m; x++){
                result = Math.max(result, map[y][x]);
                if (map[y][x] == 0) {
                    thereIsZero = true;
                    break;
                }
            }
            if (thereIsZero) break;
        }

        if (thereIsZero) {
            System.out.println(-1);
            return;
        }
        System.out.println(result - 1);
    }
}
