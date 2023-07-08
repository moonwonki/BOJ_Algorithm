import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int sizeOfMap;
    static boolean map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfMap = Integer.parseInt(br.readLine());

        String line;
        map = new boolean[sizeOfMap][sizeOfMap];
        for (int y = 0; y < sizeOfMap; y++){
            line = br.readLine();
            for (int x = 0; x < sizeOfMap; x++){
                if (line.charAt(x) - '0' == 1) map[y][x] = true;
            }
        }

        String recur = recursiveCall(0, 0, sizeOfMap);
        System.out.println(recur);
    }


    public static String recursiveCall(int startX, int startY, int size){
        //해당하는 영역 전체가 0이라면 걍 "0" 리턴
        if (fullOfZero(startX, startY, size)) return "0";
        if (fullOfOne(startX, startY, size)) return "1";
        if (size == 1) return "1";

        StringBuilder result = new StringBuilder("(");
        //좀 더 크다면 4개로 나누어서 판별식 바로 돌림.
        if (fullOfZero(startX, startY, size / 2)) result.append("0");
        else result.append(recursiveCall(startX, startY, size/2));

        if (fullOfZero(startX + size / 2, startY, size / 2)) result.append("0");
        else result.append(recursiveCall(startX + size / 2, startY, size/2));

        if (fullOfZero(startX, startY + size / 2, size / 2)) result.append("0");
        else result.append(recursiveCall(startX, startY + size / 2, size/2));

        if (fullOfZero(startX + size / 2, startY + size / 2, size / 2)) result.append("0");
        else result.append(recursiveCall(startX + size / 2, startY + size / 2, size/2));

        result.append(")");
        return result.toString();
    }

    public static boolean fullOfZero(int startX, int startY, int size) {
        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                if (map[y + startY][x + startX]) return false;
            }
        }
        return true;
    }

    public static boolean fullOfOne(int startX, int startY, int size) {
        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                if (!map[y + startY][x + startX]) return false;
            }
        }
        return true;
    }
}
