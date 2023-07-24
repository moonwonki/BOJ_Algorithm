import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer colRowToken = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(colRowToken.nextToken());
        int x = Integer.parseInt(colRowToken.nextToken());

        int cheeseCount = 0;
        int lastCheese = 0;

        int[][] board = new int[y][x];
        for (int i = 0; i < y; i++){
            StringTokenizer rowToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++){
                board[i][j] = Integer.parseInt(rowToken.nextToken());
                if (board[i][j] == 1) cheeseCount++;
            }
        }

        boolean[][] visited = new boolean[y][x];
        int reps = 0;

        Queue<int[]> thisVisit = new LinkedList<>();
        thisVisit.add(new int[]{0, 0});

        while (cheeseCount > 0){
            reps++;

            Queue<int[]> nextVisit = new LinkedList<>();
            Queue<int[]> nextMelt = new LinkedList<>();

            while (!thisVisit.isEmpty()){
                int[] now = thisVisit.poll();
                for (int[] delta: deltas){
                    int nextY = now[0] - delta[0];
                    int nextX = now[1] - delta[1];
                    if (-1 < nextX && nextX < x && -1 < nextY && nextY < y && !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        int[] next = new int[]{nextY, nextX};
                        if (board[nextY][nextX] == 1){
                            nextMelt.add(next);
                            nextVisit.add(next);
                        }
                        else {
                            thisVisit.add(next);
                        }
                    }
                }
            }
            thisVisit = nextVisit;
            lastCheese = cheeseCount;
            cheeseCount -= nextMelt.size();
            while (!nextMelt.isEmpty()) {
                int[] melt = nextMelt.poll();
                board[melt[0]][melt[1]] = 0;
            }
        }
        System.out.println(reps + "\n" + lastCheese);
    }
}
