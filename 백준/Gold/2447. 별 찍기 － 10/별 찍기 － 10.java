
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Main {

    static boolean map[][];
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int size = scn.nextInt();

        //True인 곳이 공백, 아닌 곳은 별.
        map = new boolean[size][size];


        recursive(size, 0, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (map[i][j]) bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        scn.close();

    }

    public static void recursive(int size, int curY, int curX){
        if (size == 3){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    map[curY+i][curX+j] = true;
                }
            }
            map[curY+1][curX+1] = false;
            return;
        }



        for (int bigY = 0; bigY < size; bigY += size / 3){
            for (int bigX = 0; bigX < size; bigX += size / 3){
                if (bigY == size / 3 && bigX == size / 3) continue;
                recursive(size / 3, curY + bigY, curX + bigX);
            }
        }


    }

}
