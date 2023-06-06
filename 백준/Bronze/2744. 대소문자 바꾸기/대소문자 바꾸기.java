import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Scanner scn = new Scanner(System.in);

        String input = scn.next();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) System.out.print(String.valueOf(c).toLowerCase());
            else System.out.print(String.valueOf(c).toUpperCase());
        }
    }
}