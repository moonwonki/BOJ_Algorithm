import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static char[][] map;
    static int mapY;
    static int mapX;
    static List<Character> steppedOn;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int max;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        mapY = scn.nextInt();
        mapX = scn.nextInt();

        map = new char[mapY][mapX];
        max = 0;
        for (int i = 0; i < mapY; i++){
            map[i] = scn.next().toCharArray();
        }

        steppedOn = new ArrayList<>();
        steppedOn.add(map[0][0]);

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int curY, int curX){
        if (steppedOn.size() >= max) max = steppedOn.size();

        for (int i = 0; i < 4; i++){
            int newY = curY + dy[i];
            int newX = curX + dx[i];

            if (newY < 0 || newY >= mapY || newX < 0 || newX >= mapX) continue;

            if (steppedOn.contains(map[newY][newX])) continue;
            steppedOn.add(map[newY][newX]);
            dfs(newY, newX);
            steppedOn.remove(steppedOn.indexOf(map[newY][newX]));
        }
    }


}