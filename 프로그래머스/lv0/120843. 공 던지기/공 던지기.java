class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        if (k == 1) return 1;
        
        int people = numbers.length;
        
        int toss = (k - 1) * 2;
        answer = toss % people + 1;
        return answer;
    }
}