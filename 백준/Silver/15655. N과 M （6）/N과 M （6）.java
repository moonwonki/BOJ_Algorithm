import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int arrSize;
    static int limit;
    static int numArr[];
    static int result[];
    static BufferedWriter bw;
    static boolean contains[];
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrSize = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numArr = new int[arrSize];
        result = new int[limit];
        contains = new boolean[arrSize];
        for (int i = 0; i < arrSize; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        dfs(0);

        bw.flush();
        bw.close();
        br.close();


    }

    public static void dfs(int size) throws IOException {
        if (size == limit){
            for (int i = 0; i < limit; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < arrSize; i++){
            if(contains[i]) continue;
            if (size > 0 && result[size - 1] >= numArr[i]) continue;
            result[size] = numArr[i];
            contains[i] = true;
            dfs(size + 1);

            result[size] = 0;
            contains[i] = false;
        }
    }


}
