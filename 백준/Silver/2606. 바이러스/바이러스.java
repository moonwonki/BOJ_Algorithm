import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean visited[];
    static int connection[][];
    static boolean virus[];

    static int computerNum;
    static int connectionNum;



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        computerNum = scn.nextInt();
        connectionNum = scn.nextInt();
        visited = new boolean[computerNum+1];
        connection = new int[computerNum+1][computerNum+1];
        virus = new boolean[computerNum+1];

        for (int i = 0; i < connectionNum; i++){
            int originCom = scn.nextInt();
            int connectedCom = scn.nextInt();
            connection[originCom][connectedCom] = 1;
            connection[connectedCom][originCom] = 1;
        }

        dfs(1);

        int sum = 0;
        for (int i = 2; i < computerNum+1; i++){
            if (virus[i] == true){
                sum++;
            }
        }
        System.out.println(sum);
        //finish
    }

    public static void dfs(int virusCheckingCom){
        if (visited[virusCheckingCom] == true){
            return;
        }
        visited[virusCheckingCom] = true;

        for (int i = 2; i < computerNum+1; i++){
            if (connection[virusCheckingCom][i] == 0){
                continue;
            }
            else {
                virus[i] = true;
                dfs(i);
            }
        }
    }
}
