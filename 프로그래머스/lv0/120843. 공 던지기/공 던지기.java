class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        //던지는 횟수가 1이면 첫번째 사람이 던지는 사람이기 때문에 바로 1 리턴.
        if (k == 1) return 1;
        
        //전체 사람 수
        int people = numbers.length;
        //사람을 건너가는 횟수
        int toss = (k - 1) * 2;
        //답 구하기
        answer = toss % people + 1;
        return answer;
    }
}