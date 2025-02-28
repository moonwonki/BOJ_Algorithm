import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ropeNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> rope = new ArrayList<>();

        for (int i = 0; i < ropeNum; i++){
            rope.add(Integer.parseInt(br.readLine()));
        }

        rope.sort(Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < ropeNum; i++){
            max = Math.max(max, rope.get(i) * (i + 1));
        }

        System.out.println(max);

    }
}
