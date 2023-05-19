package org.example.BOJ_Algorithm.moonwonki;

import java.io.*;
import java.util.*;

public class baekjoon_14502 {
    static int map[][];
    static int ySizeMap;
    static int xSizeMap;
    static boolean visited[][];
    static ArrayList<int[]> wall;
    static ArrayList<int[]> virus;

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int Max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ySizeMap = Integer.parseInt(st.nextToken());
        xSizeMap = Integer.parseInt(st.nextToken());

        map = new int[ySizeMap][xSizeMap]; 
        wall = new ArrayList<>();
        virus = new ArrayList<>();
        Max = 0;
        for (int y = 0; y < ySizeMap; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xSizeMap; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2)
                    virus.add(new int[] {y,x});
            }
        }

        backTrack(0);

        bw.write(Integer.toString(Max));


        bw.flush();
        bw.close();




    }

    public static void backTrack(int count){
        if (count == 3){
            int safeArea = bfs();
            if (safeArea > Max){
                Max = safeArea;
            }
        }
        else {
            for (int y = 0; y < ySizeMap; y++){
                for (int x = 0; x <xSizeMap; x++){
                    int tmp[] = new int[] {y,x};
                    if (map[y][x] == 0){
                        wall.add(tmp);
                        map[tmp[0]][tmp[1]] = 1;
                        backTrack(count+1);
                        wall.remove(tmp);
                        map[tmp[0]][tmp[1]] = 0;
                    }
                    tmp = null;
                }
            }
        }
    }

    public static int bfs(){
        int result = 0;
        visited = new boolean[ySizeMap][xSizeMap];

        int newMap[][] = new int[ySizeMap][xSizeMap];
        for (int y = 0; y < ySizeMap; y++){
            for (int x = 0; x < xSizeMap; x++){
                newMap[y][x] = map[y][x];
            }
        }

        for (int i = 0; i < virus.size(); i++){
            int startPoint[] = virus.get(i);
            Queue<int[]> qu = new LinkedList<>();
            qu.add(startPoint);
            while (!qu.isEmpty()){
                int pos[] = qu.poll();
                int yCur = pos[0];
                int xCur = pos[1];
                if (visited[yCur][xCur])
                    continue;
                newMap[yCur][xCur] = 2;
                visited[yCur][xCur] = true;
                for (int j = 0; j < 4; j++){
                    int nx = xCur + dx[j];
                    int ny = yCur + dy[j];
                    if (ny < 0 || ny >= ySizeMap || nx < 0 || nx >= xSizeMap)
                        continue;
                    if (visited[ny][nx])
                        continue;
                    if (newMap[ny][nx] == 0){
                        qu.add(new int[] {ny,nx});
                    }

                }
            }
        }

        for (int y = 0; y < ySizeMap; y++){
            for (int x = 0; x < xSizeMap; x++){
                if (newMap[y][x] == 0)
                    result++;
            }
        }

        return result;
    }
}
