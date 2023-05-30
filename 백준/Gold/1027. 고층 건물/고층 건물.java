import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int buildingNum;
    static long building[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        buildingNum = Integer.parseInt(br.readLine());

        building = new long[buildingNum + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < buildingNum + 1; i++){
            building[i] = Long.parseLong(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= buildingNum; i++){
            int result = findLeft(i) + findRight(i);
            max = Math.max(result, max);
        }
        System.out.println(max);


    }

    private static int findRight(int viewerX) {
        int result = 0;


        for (int targetX = viewerX + 1; targetX <= buildingNum; targetX++){
            boolean blocked = false;
            for (int middle = targetX - 1; middle > viewerX; middle--) {
                blocked = blocksRight(targetX, viewerX, middle);
                if (blocked) break;
            }
            if (!blocked) result++;
        }
        return result;
    }

    private static int findLeft(int viewerX) {
        int result = 0;

        //y = aVal * x + bVal
        for (int targetX = 1; targetX < viewerX; targetX++){
            boolean blocked = false;
            for (int middle = targetX + 1; middle < viewerX; middle++) {
                blocked = blocksLeft(targetX, viewerX, middle);
                if (blocked) break;
            }
            if (!blocked) result++;
        }
        return result;
    }

    //가운데 middle이 가리지 않는다면 false
    //가운데 middle이 가린다면 true
    private static boolean blocksLeft(int targetX, int viewerX, int middle) {
        long viewerY = building[viewerX];
        long targetY = building[targetX];
        long middleY = building[middle];

        if ((viewerX*targetY + targetX * middleY + middle * viewerY) - (viewerY * targetX + targetY * middle + middleY * viewerX) <= 0) return true;
        else return false;
    }

    private static boolean blocksRight(int targetX, int viewerX, int middle) {
        long viewerY = building[viewerX];
        long targetY = building[targetX];
        long middleY = building[middle];

        if ((viewerX*targetY + targetX * middleY + middle * viewerY) - (viewerY * targetX + targetY * middle + middleY * viewerX) >= 0) return true;
        else return false;
    }

}
