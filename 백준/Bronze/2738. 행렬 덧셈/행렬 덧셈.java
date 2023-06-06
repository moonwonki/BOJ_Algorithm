import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int height = scn.nextInt();
        int length = scn.nextInt();

        int first[][] = new int[height][length];
        int second[][] = new int[height][length];

        for (int y = 0; y < height; y++){
            for (int x = 0; x < length; x++){
                first[y][x] = scn.nextInt();
            }
        }

        for (int y = 0; y < height; y++){
            for (int x = 0; x < length; x++){
                second[y][x] = scn.nextInt() + first[y][x];
            }
        }


        for (int y = 0; y < height; y++){
            for (int x = 0; x < length; x++){
                System.out.printf("%d ", second[y][x]);
            }
            System.out.printf("\n");
        }

    }
}