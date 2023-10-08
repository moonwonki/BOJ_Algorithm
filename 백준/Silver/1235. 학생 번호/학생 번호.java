import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] studentNumArray;
    static int fullLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int studentNum = Integer.parseInt(br.readLine());

        studentNumArray = new String[studentNum];

        for (int i = 0; i < studentNum; i++){
            studentNumArray[i] = br.readLine();
        }
        fullLength = studentNumArray[0].length();

        for (int i = 1; i <= fullLength; i++){
            if (back(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean back(int num) {
        for (int i = 0; i < studentNumArray.length - 1; i++){
            for (int j = i + 1; j < studentNumArray.length; j++){
                if (studentNumArray[i].substring(fullLength - num).equals(studentNumArray[j].substring(fullLength - num)))
                    return false;
            }
        }
        return true;

    }


}