import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        long first[] = new long[3];
        first[0] = scn.nextLong();
        first[1] = scn.nextLong();
        first[2] = scn.nextLong();

        long second[] = new long[3];
        second[0] = scn.nextLong();
        second[1] = scn.nextLong();
        second[2] = scn.nextLong();

        long temp = (long) (Math.pow(first[0] - second[0] , 2)  + Math.pow(first[1] - second[1], 2));

        if (temp < Math.pow((double) (first[2] + second[2]) , 2)) System.out.println("YES");
        else System.out.println("NO");


    }
}
