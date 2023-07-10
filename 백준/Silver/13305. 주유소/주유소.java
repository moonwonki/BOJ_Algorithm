import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long cityCount = Integer.parseInt(reader.readLine());
        StringTokenizer cityDistToken = new StringTokenizer(reader.readLine());
        
        long[] cityDistance = new long[(int) (cityCount - 1)];
        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = Integer.parseInt(cityDistToken.nextToken());
        }

        StringTokenizer cityFuelToken = new StringTokenizer(reader.readLine());
        
        long[] cityFuel = new long[(int) cityCount];
        for (int i = 0; i < cityCount; i++) {
            cityFuel[i] = Integer.parseInt(cityFuelToken.nextToken());
        }

        
        long currentMin = Integer.MAX_VALUE;
        long needToGo = 0;
       
        long totalPrice = 0;
        
        for (int i = 0; i < cityCount - 1; i++) {
            
            if (cityFuel[i] < currentMin) {
                totalPrice += currentMin * needToGo;
                currentMin = cityFuel[i];
                needToGo = cityDistance[i];
            }

            else {

                needToGo += cityDistance[i];
            }
        }

        // 마지막 주유비를 계산하여 반환
        System.out.println(totalPrice + needToGo * currentMin);
    }
}