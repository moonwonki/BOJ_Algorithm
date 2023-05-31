import java.util.Scanner;


public class Main {
    static int mapY;
    static int mapX;
    static char[][] map;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, -1, 0, 1};
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        mapY = scn.nextInt();
        mapX = scn.nextInt();

        map = new char[mapY][mapX];
        for (int i = 0; i < mapY; i++){
            map[i] = scn.next().toCharArray();
        }

        for (int y = 0; y < mapY; y++){
            for (int x = 0; x < mapX; x++){
                visited = new boolean[mapY][mapX];
                if (dfs(y, x, -1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    public static boolean dfs(int curY, int curX, int beforeDir){
        for (int i = 0; i < 4; i++){
            if (Math.abs(i - beforeDir) == 2) continue;
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];

            if (nextY < 0 || nextY >= mapY || nextX < 0 || nextX >= mapX) continue;
            if (visited[nextY][nextX]) return true;

            if (map[nextY][nextX] != map[curY][curX]) continue;
            visited[nextY][nextX] = true;
            if (dfs(nextY, nextX, i)) return true;
            visited[nextY][nextX] = false;


        }
        return false;
    }

}
