
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int paperNum = scn.nextInt();
        boolean background[][] = new boolean[100][100];

        for (int i = 0; i < paperNum; i++){
            int left = scn.nextInt();
            int bottom = scn.nextInt();

            for (int x = left; x < left + 10; x++){
                for (int y = bottom; y < bottom + 10; y++){
                    background[y][x] = true;
                }
            }

        }

        int count = 0;
        for (int y = 0; y < 100; y++){
            for (int x = 0; x < 100; x++){
                if (background[y][x]) count++;
            }
        }

        System.out.println(count);
    }
}