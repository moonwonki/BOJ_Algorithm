class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //사람 수 n이 6으로 나누어 떨어진다면 n / 6 (피자 개수) 리턴.
        if (n % 6 == 0) return n / 6;
        
        //만약 안된다면 n과 6의 최소 공배수만큼의 조각이 필요.
        int pizza = 1;
        while (true){
            if ((pizza * 6) % n == 0) break;
            pizza++;
        }
        
        answer = pizza;
        return answer;
    }
}