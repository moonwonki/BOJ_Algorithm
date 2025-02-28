import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int peopleNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> people = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < peopleNum; i++){
            people.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(people);

        int totalTimeTaken = 0;
        int sumOfPrevious = 0;
        for (int i = 0; i < peopleNum; i++){
            totalTimeTaken += sumOfPrevious + people.get(i);
            sumOfPrevious += people.get(i);
        }

        System.out.println(totalTimeTaken);

    }
}
