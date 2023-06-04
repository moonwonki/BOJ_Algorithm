import java.util.*;

public class Main {
    static int mapSize;
    static int map[][];
    static int maxResult;
    static ArrayList<Integer> line = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        mapSize = scn.nextInt();
        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++){
            for (int j = 0; j < mapSize; j++){
                map[i][j] = scn.nextInt();
            }
        }

        Queue<int[][]> qu = new LinkedList<>();
        Queue<Integer> times = new LinkedList<>();
        qu.add(copyMap(map));
        times.add(0);
        maxResult = 0;

        while(!qu.isEmpty()){
            int curMap[][] = qu.poll();
            int count = times.poll();

            if (count == 5){
                findMax(curMap);
                continue;
            }
            for (int i = 0; i < 4; i++){
                //UP
                if (i == 0){
                    qu.add(slideUp(copyMap(curMap)));
                    times.add(count + 1);
                }
                //DOWN
                if (i == 1){
                    qu.add(slideDown(copyMap(curMap)));
                    times.add(count + 1);
                }

                //left
                if (i == 2){
                    qu.add(slideLeft(copyMap(curMap)));
                    times.add(count + 1);
                }

                //Right
                if (i == 3){
                    qu.add(slideRight(copyMap(curMap)));
                    times.add(count + 1);
                }



            }

        }
        System.out.println(maxResult);
    }

    public static void findMax(int[][] curMap) {
        for (int y = 0; y < mapSize; y++){
            for (int x = 0; x < mapSize; x++){
                maxResult = Math.max(maxResult, curMap[y][x]);
            }
        }

    }

    public static int[][] slideUp(int[][] data) {
        for (int x = 0; x < mapSize; x++){
            line.clear();
            for (int y = 0; y < mapSize; y++){
                if (data[y][x] != 0){
                    line.add(data[y][x]);
                }
            }

            lineDigest();
            for (int y = 0; y < mapSize; y++){
                data[y][x] = 0;
            }
            for (int y = 0; y < line.size(); y++){
                data[y][x] = line.get(y);
            }


        }
        return data;
    }



    public static int[][] slideDown(int[][] data) {
        for (int x = 0; x < mapSize; x++){
            line.clear();
            for (int y = mapSize - 1; y >= 0; y--){
                if (data[y][x] != 0){
                    line.add(data[y][x]);
                }
            }

            lineDigest();
            for (int y = 0; y < mapSize; y++){
                data[y][x] = 0;
            }

            int lineIndex = 0;
            for (int y = mapSize - 1;  y >= 0 && lineIndex < line.size(); y--){
                data[y][x] = line.get(lineIndex++);
            }


        }
        return data;
    }

    public static int[][] slideLeft(int[][] data) {
        for (int y = 0; y < mapSize; y++){
            line.clear();
            for (int x = 0; x < mapSize; x++){
                if (data[y][x] != 0){
                    line.add(data[y][x]);
                }
            }

            lineDigest();
            Arrays.fill(data[y], 0);
            for (int x = 0; x < line.size(); x++){
                data[y][x] = line.get(x);
            }


        }
        return data;
    }

    public static int[][] slideRight(int[][] data) {
        for (int y = 0; y < mapSize; y++){
            line.clear();
            for (int x = mapSize - 1; x >= 0; x--){
                if (data[y][x] != 0){
                    line.add(data[y][x]);
                }
            }

            lineDigest();
            Arrays.fill(data[y], 0);

            int lineIndex = 0;
            for (int x = mapSize - 1;  x >= 0 && lineIndex < line.size(); x--){
                data[y][x] = line.get(lineIndex++);
            }


        }
        return data;
    }

    public static void lineDigest() {
        for (int i = 0; i < line.size() - 1; i++){
            if (Objects.equals(line.get(i), line.get(i + 1))){
                line.set(i, line.get(i) * 2);
                line.remove(i + 1);
            }
        }
    }

    public static int[][] copyMap(int origin[][]){
        int[][] result = new int[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++){
            for (int x = 0; x < mapSize; x++){
                result[y][x] = origin[y][x];
            }
        }
        return result;
    }
}