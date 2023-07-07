import java.util.*;

class Solution {
    public String solution(int[] ints) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
        {
            StringBuilder first = new StringBuilder(Integer.toString(o1));
            StringBuilder sec = new StringBuilder(Integer.toString(o2));

            first.append(sec.toString());
            sec.append(first.toString());

            return sec.toString().compareTo(first.toString());
        });

        for (int i = 0; i < ints.length; i++){
            pq.add(ints[i]);
        }


        StringBuilder sb = new StringBuilder();
        boolean allZero = true;
        for (int i = 0; i < ints.length; i++){
            if (pq.peek() != 0) allZero = false;
            sb.append(pq.poll());
        }
        if (allZero) return "0";
        return sb.toString();

    }

    public static int getDigitNumber(Integer num) {
        int count = 0;
        while (num != 0){
            num /= 10;
            count++;
        }
        return count;
    }
}