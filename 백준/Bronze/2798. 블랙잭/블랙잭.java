import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int cardNum = scn.nextInt();
        int blackJackNum = scn.nextInt();

        int card[] = new int[cardNum];

        for (int i = 0; i < cardNum; i++){
            card[i] = scn.nextInt();
        }

        int myCard = 0;
        for (int first = 0; first < cardNum - 2; first++){
            for (int second = first + 1; second < cardNum - 1; second++){
                for (int third = second + 1; third < cardNum; third++){
                    int sum = card[first] + card[second] + card[third];
                    if (sum <= blackJackNum) myCard = Math.max(sum, myCard);
                }
            }
        }

        System.out.println(myCard);
    }
}
