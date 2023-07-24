import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 하얀 비숍들이 들어갈 수 있는 칸
    private static List<int[]> whitePoints;
    //하얀색 칸에 놓을 수 있는 비숍의 최대 갯수
    private static int whiteMax;

    private static List<int[]> blackPoints;
    private static int blackMax;



    public static void dfsWhite(int next, boolean[] selected){
        if (next == whitePoints.size()){
            int count = 0;
            for (boolean select : selected){
                if (select) count += 1;
            }
            whiteMax = Math.max(whiteMax, count);
        }
        else {
            selected[next] = true;
            if (checkWhite(next, selected)) dfsWhite(next + 1, selected);
            selected[next] = false;
            dfsWhite(next + 1, selected);
        }
    }

    public static boolean checkWhite(int next, boolean[] selected){
        int[] point = whitePoints.get(next);
        for (int i = 0; i < next; i++) {
            if (selected[i] && Math.abs(whitePoints.get(i)[0] - point[0]) == Math.abs(whitePoints.get(i)[1] - point[1]))
                return false;
        }
        return true;
    }

    public static void dfsBlack(int next, boolean[] selected){
        if (next == blackPoints.size()){
            int count = 0;
            for (boolean select : selected){
                if (select) count += 1;
            }
            blackMax = Math.max(blackMax, count);
        }
        else {
            selected[next] = true;
            if (checkBlack(next, selected))dfsBlack(next + 1, selected);
            selected[next] = false;
            dfsBlack(next + 1, selected);
        }
    }

    public static boolean checkBlack(int next, boolean[] selected){
        int[] point = blackPoints.get(next);
        for (int i = 0; i < next; i++) {
            if (selected[i] && Math.abs(blackPoints.get(i)[0] - point[0]) == Math.abs(blackPoints.get(i)[1] - point[1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        whitePoints = new ArrayList<>();
        whiteMax = 0;

        blackPoints = new ArrayList<>();
        blackMax = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer boardToken = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) {
                if (Integer.parseInt(boardToken.nextToken()) == 1) {
                    if ((i + j) % 2 == 0) whitePoints.add(new int[]{i, j});
                    else blackPoints.add(new int[]{i, j});
                }
            }
        }

        dfsWhite(0, new boolean[whitePoints.size()]);
        dfsBlack(0, new boolean[blackPoints.size()]);

        System.out.println(whiteMax + blackMax);
    }
}
