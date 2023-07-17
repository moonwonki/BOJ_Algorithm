import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int people = scn.nextInt();
        int myVote = scn.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < people - 1; i++){
            pq.add(scn.nextInt());
        }

        int count = 0;
        while (!pq.isEmpty()){
            if (pq.peek() >= myVote){
                pq.add(pq.poll() - 1);
                count++;
                myVote++;
            }
            else break;
        }

        System.out.println(count);
    }
}
