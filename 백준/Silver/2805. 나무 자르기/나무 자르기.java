
import java.util.*;
import java.io.*;




public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받는 파트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeNum = Integer.parseInt(st.nextToken());
        long needSize = Long.parseLong(st.nextToken());
        int tree[] = new int[treeNum];

        long biggestTree = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeNum; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            biggestTree = Math.max(biggestTree, tree[i]);
        }

        // 풀이
        long lo = 0;
        long high = biggestTree;
        long mid = 0;
        while (lo < high){
            mid = (lo + high) / 2;
            long sum = 0;
            for (int i = 0; i < treeNum; i++){
                if (tree[i] - mid > 0) sum += tree[i] - mid;
            }

            if (sum < needSize){
                high = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        bw.write(Long.toString(lo - 1));
        bw.flush();
    }
}
