class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for (int i = -50; i <= 1000; i++){
            int sum = 0;
            for (int j = 0; j < num; j++){
                sum += i + j;
            }
            if (sum == total) {
                for (int j = 0; j < num; j++){
                    answer[j] = i + j;
                }
            }
        }
        return answer;
    }
}