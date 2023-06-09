import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        
        int result = 0;
        for (int i = 0; i < 5; i++){
            result += scn.nextInt();
        }
        
        System.out.println(result);
    }
}