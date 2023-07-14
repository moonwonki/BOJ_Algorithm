import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCaseNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaseNum; t++) {
            int numOfOrder = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> numList = new TreeMap<Integer, Integer>();

            for (int i = 0; i < numOfOrder; i++){
                st = new StringTokenizer(br.readLine());

                char order = st.nextToken().charAt(0);

                if (order == 'I'){
                    int tmp = Integer.parseInt(st.nextToken());
                    numList.put(tmp, numList.getOrDefault(tmp, 0) + 1);
                }
                else if (order == 'D'){
                    int tmp = Integer.parseInt(st.nextToken());
                    if (numList.size() == 0){
                        continue;
                    }
                    int con = tmp == 1 ? numList.lastKey() : numList.firstKey();
                    if (numList.put(con, numList.get(con) - 1) == 1)
                        numList.remove(con);
                }
            }
            if (numList.size() == 0){
                System.out.println("EMPTY");
            }
            else {
                System.out.println(numList.lastKey() + " " + numList.firstKey());

            }
        }
    }
}