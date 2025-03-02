import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computerNum = Integer.parseInt(br.readLine());
        int connectionNum = Integer.parseInt(br.readLine());

        boolean[][] connections = new boolean[computerNum + 1][computerNum + 1];
        for (int i = 0; i < connectionNum; i++){
            st = new StringTokenizer(br.readLine());
            int firstCom = Integer.parseInt(st.nextToken());
            int secondCom = Integer.parseInt(st.nextToken());

            connections[firstCom][secondCom] = true;
            connections[secondCom][firstCom] = true;
        }

        boolean[] computerChecked = new boolean[computerNum + 1];
        int count = 0;

        Queue<Integer> qu = new LinkedList<>();

        computerChecked[1] = true;
        qu.add(1);

        while (!qu.isEmpty()){
            int currentComputer = qu.poll();

            for (int j = 1; j <= computerNum; j++){
                if (connections[currentComputer][j]){
                    if (computerChecked[j]) continue;
                    count++;
                    computerChecked[j] = true;
                    qu.add(j);
                }

            }
        }

        System.out.println(count);
    }
}


