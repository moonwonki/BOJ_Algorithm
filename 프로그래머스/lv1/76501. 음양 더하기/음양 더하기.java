class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int numbers = absolutes.length;
        
        int answer = 0;
        for (int i = 0; i < numbers; i++){
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}