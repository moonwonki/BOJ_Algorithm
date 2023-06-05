import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int numAmount = scn.nextInt();
        int numArr[] = new int[numAmount];

        for (int i = 0; i < numAmount; i++) numArr[i] = scn.nextInt();

        Arrays.sort(numArr);

        int sum = 1;
        for (int i = 0; i < numAmount; i++){
            if (sum < numArr[i])
                break;
            sum += numArr[i];
        }

        System.out.println(sum);
    }
}