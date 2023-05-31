import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int mapY;
    static int mapX;

    static int[][] map;
    static ArrayList<int[][]> shapes = new ArrayList<>();

    public static void main(String[] args) {
        int shape1[][] = {{0,0}, {0, 1}, {0,2}, {0,3}};
        int shape2[][] = {{0,0}, {0, 1}, {1,0}, {1, 1}};
        int shape3[][] = {{0, 0}, {1, 0}, {2, 0}, {2, 1}};
        int shape3_1[][] = {{0, 0}, {0, 1}, {1, 0}, {2, 0}};
        int shape4[][] = {{0, 0}, {1, 0}, {1, 1}, {2, 1}};
        int shape4_1[][] = {{0, 0}, {0, 1}, {1, 1}, {1, 2}};
        int shape5[][] = {{0, 0}, {0, 1}, {0, 2}, {1, 1}};
        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(shape3_1);
        shapes.add(shape4);
        shapes.add(shape4_1);
        shapes.add(shape5);

        Scanner scn = new Scanner(System.in);

        mapY = scn.nextInt();
        mapX = scn.nextInt();
        map = new int[mapY][mapX];

        for (int y = 0; y < mapY; y++){
            for (int x = 0; x < mapX; x++){
                map[y][x] = scn.nextInt();
            }
        }

        int result = 0;
        int targetMap[][] = map;
        for (int i = 0; i < 7; i++){
            int rotate = 4;
            if (i == 1) rotate = 1;
            if (i == 4 || i == 5 || i == 0) rotate = 2;

            for (int mapRoll = 0; mapRoll < rotate; mapRoll++){
                targetMap = rotateMap(targetMap);
                result = Math.max(calculate(targetMap, i), result);

            }

        }


        System.out.println(result);
    }

    static int[][] rotateMap(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;
    }
    static int calculate(int[][] targetMap, int shapeIndex) {
        int shape[][] = shapes.get(shapeIndex);

        int resultMax = 0;
        for (int y = 0; y < targetMap.length; y++){
            for (int x = 0; x < targetMap[0].length; x++){
                boolean broke = false;
                int sum = 0;
                for (int i = 0; i < 4; i++){
                    int curY = y + shape[i][0];
                    int curX = x + shape[i][1];

                    if (curY < 0 || curY >= targetMap.length || curX < 0 || curX >= targetMap[0].length) {
                        broke = true;
                        break;
                    }
                    sum += targetMap[curY][curX];
                }

                if (broke) continue;
                resultMax = Math.max(sum, resultMax);
            }
        }

        return resultMax;
    }
}