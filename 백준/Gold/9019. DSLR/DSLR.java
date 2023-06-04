
/*
https://log-laboratory.tistory.com/134 해당 블로그 참조.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCaseNum = scn.nextInt();

        for (int t = 0; t <testCaseNum ; t++) {
            int initialNum = scn.nextInt();
            int finalNum = scn.nextInt();
            String[] calculator = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> qu = new LinkedList<>();

            visited[initialNum] = true;
            qu.add(initialNum);
            Arrays.fill(calculator,"");

            int D, S, L, R;
            while (!qu.isEmpty()){
                int cur = qu.poll();

                D = (2 * cur) % 10000;
                S = cur - 1; if (S == -1) S = 9999;
                L = (cur % 1000) * 10 + cur / 1000;
                R = (cur % 10) * 1000 + cur / 10;

                if(!visited[D]){
                    visited[D] = true;
                    calculator[D] = calculator[cur] + "D";
                    qu.add(D);
                }

                if(!visited[S]){
                    visited[S]=true;
                    calculator[S]=calculator[cur] + "S";
                    qu.add(S);
                }
                if(!visited[L]){
                    visited[L]=true;
                    calculator[L]=calculator[cur] + "L";
                    qu.add(L);
                }
                if(!visited[R]){
                    visited[R]=true;
                    calculator[R]=calculator[cur] + "R";
                    qu.add(R);
                }

                if (visited[finalNum]) break;
            }

            System.out.println(calculator[finalNum]);
        }

    }
}