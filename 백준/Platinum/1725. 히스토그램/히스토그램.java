import java.util.Scanner;
import java.util.Stack;

//8 4 7 6 8 5 9 1 0 결과 : 25
//10 1 1 1 2 2 2 2 1 1 1 결과: 10
//10 8 6 3 5 0 0 4 10 2 5 결과 : 12
//
//
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();


        long stick[] = new long[N];
        Stack<Long> st = new Stack<>();//여기에 들어가는 값은 인덱스임!!!!! 명심할 것!

        long max = 0;
        for (int i = 0; i < N; i++){
            stick[i] = scn.nextLong();
            if (st.isEmpty()) {
                st.push(stick[i]);
                continue;
            }

            long length = 0;
            while (!st.isEmpty() && stick[i] < st.peek()){
                length += 1;
                long height = st.pop();
                max = Math.max(height * length, max);
            }
            long temp = stick[i];
            for (int j = 0; j < length; j++){
                st.push(temp);
            }
            st.push(stick[i]);

        }

        long length = 0;
        while (!st.isEmpty()){
            length += 1;
            long height = st.pop();
            max = Math.max(height * length, max);
        }

        System.out.println(max);
    }
}