class Solution {
    static boolean visited[];
    static int total;
    static int N;
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];
        total = 0;
        
        for (int i = 0; i < n; i++){
            if (visited[i]) continue;
            visited[i] = true;
            connect(i, computers);
            total++;
        }
        return total;
    }
    
    public void connect(int currentCom, int[][] computers){
        for (int i = 0; i < N; i++){
            if (visited[i]) continue;
            if (computers[currentCom][i] == 0) continue;
            visited[i] = true;
            connect(i, computers);
        }
    }
}