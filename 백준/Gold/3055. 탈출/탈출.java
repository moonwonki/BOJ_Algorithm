import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
    // D(비버의 굴)은 -9;
    // *(물)은 -1;
    // S(고슴도치)는 1;
    // X(돌)은 -5;

    static int yField;
    static int xField;
    static int map[][];
    static Queue<int[]> q;
    static boolean visited[][];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            yField = scn.nextInt();
            xField = scn.nextInt();

            map = new int[yField][xField];
            visited = new boolean[yField][xField];
            q = new LinkedList<int[]>();

            int sonicX = 0;
            int sonicY = 0;
            int bieberX = 0;
            int bieberY = 0;
            for (int y = 0; y < yField; y++){
                String tmp = scn.next();
                for (int x = 0; x < xField; x++){
                    if (tmp.charAt(x) == 'D') {
                        map[y][x] = -9;
                        bieberX = x;
                        bieberY = y;
                    }
                    else if (tmp.charAt(x) == '.'){
                        map[y][x] = 0;
                    }
                    else if (tmp.charAt(x) == '*'){
                        map[y][x] = -1;
                        q.add(new int[] {y, x});
                    }
                    else if (tmp.charAt(x) == 'S'){
                        map[y][x] = 1;
                        sonicX = x;
                        sonicY = y;
                    }
                    else if (tmp.charAt(x) == 'X'){
                        map[y][x] = -5;
                    }
                }
            }



            bfs(sonicY, sonicX);
            while(!q.isEmpty()){
                int tmp[] = q.poll();
                bfs(tmp[0], tmp[1]);
            }

            if (map[bieberY][bieberX] != -9){
                System.out.println(map[bieberY][bieberX] - 1);
            }
            else {
                System.out.println("KAKTUS");
            }


    }

    public static void bfs(int yInput, int xInput){

        if (visited[yInput][xInput] == true){
            return;
        }
        visited[yInput][xInput] = true;

        for (int i = 0; i < 4; i++){
            int nx = xInput + dx[i];
            int ny = yInput + dy[i];
            if ((nx < 0) || (nx >= xField) || (ny < 0) || (ny >= yField))
                continue;

            if (map[ny][nx] >= 0){//빈칸이거나 소닉이 지나간 자리일때.
                //System.out.println("물 시작");
                //System.out.println("x: " + xInput + ", y : " + yInput);
                //System.out.println("nx: " + nx + ", ny : " + ny);
                if (map[yInput][xInput] == -1){//만약 물이라면.
                    map[ny][nx] = -1;
                    q.add(new int[] {ny, nx});
                }
                else {// 소닉이라면.
                    if (mapCheck(ny,nx)){
                        map[ny][nx] = map[yInput][xInput] + 1;
                        q.add(new int[] {ny, nx});
                    }
                    else{
                        continue;
                    }
                }
            }
            else if (map[ny][nx] == -5){//물이거나 돌일 때.
                continue;
            }
            else if (map[ny][nx] == -9){// 비버소굴일 때.
                if (map[yInput][xInput] == -1){//만약 물이라면.
                    continue;
                }
                else {// 소닉이라면.
                    map[ny][nx] = map[yInput][xInput] + 1;
                    q.clear();
                }
            }
        }
    }
    public static void mapShow(){
        System.out.println("------------------------------------");
        for (int i = 0; i < yField; i++){
            for (int j =0 ; j < xField; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------");
    }

    public static boolean mapCheck(int y, int x) {
        if (map[y][x] >= 1){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx < 0) || (nx >= xField) || (ny < 0) || (ny >= yField))
                continue;
            if (map[ny][nx] == -1) {
                return false;
            }
        }
        return true;
    }
}