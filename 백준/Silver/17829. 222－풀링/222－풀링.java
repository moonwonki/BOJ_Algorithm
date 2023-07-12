
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int mapSize;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        mapSize = Integer.parseInt(br.readLine());

        map = new int[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++){
            st = new StringTokenizer(br.readLine());
            for (int x = 0 ; x < mapSize; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(polling(mapSize, 0, 0));

    }

    public static int polling(int size, int yStart, int xStart){
        if (size == 1){
            return map[yStart][xStart];
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(polling(size / 2, yStart, xStart));
        list.add(polling(size / 2, yStart + size / 2, xStart));
        list.add(polling(size / 2, yStart, xStart + size / 2));
        list.add(polling(size / 2, yStart + size / 2, xStart + size / 2));

        Collections.sort(list);

        return list.get(2);
    }
}