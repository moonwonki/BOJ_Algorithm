import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int resultY;
    static int resultX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        resultY = Integer.parseInt(st.nextToken());
        resultX = Integer.parseInt(st.nextToken());

        int result = recurCall((int) Math.pow(2,N), 0, 0, 0);

        System.out.println(result);

    }

    //해당 영역에서 어떤 위치에 있는지를 체크하고 그 영역을 토대로 재귀함수 call을 하는 구조.
    //before는 해당 영역이 몇번째 숫자에서 시작하는지를 의미한다.
    private static int recurCall(int size, int startX, int startY, int before) {
        if (size == 1){
            return before;
        }

        //해당 영역 1사분면
        if (startX <= resultX && resultX < startX + size / 2 && startY <= resultY && resultY < startY + size / 2)
            return recurCall(size / 2, startX, startY, before);

        //해당 영역 2사분면
        if (startX + size / 2 <= resultX && resultX < startX + size && startY <= resultY && resultY < startY + size / 2)
            return recurCall(size / 2, startX + size / 2, startY, before + (int) Math.pow(size / 2, 2));

        //해당 영역 3사분면
        if (startX <= resultX && resultX < startX + size / 2 && startY + size / 2 <= resultY && resultY < startY + size)
            return recurCall(size / 2, startX, startY  + size / 2, before + (int) Math.pow(size / 2, 2) * 2);

        //해당 영역 4사분면
        if (startX + size / 2 <= resultX && resultX < startX + size && startY + size / 2 <= resultY && resultY < startY + size)
            return recurCall(size / 2, startX + size / 2, startY  + size / 2, before + (int) Math.pow(size / 2, 2) * 3);

        else throw new RuntimeException("bug");
    }


}
