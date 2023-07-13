class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean numCheck[] = new boolean[10];
        
        for (int i = 0; i < numbers.length; i++){
            numCheck[numbers[i]] = true;
        }
        
        for (int i = 0; i < 10; i++){
            if (!numCheck[i]) answer += i;
        }
        return answer;
    }
}