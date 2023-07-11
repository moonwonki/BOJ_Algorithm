class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++){
            if(isItEven(i)) answer += i;
            else answer -= i;
        }
        
        
        return answer;
    }
    
    public static boolean isItEven(int num){
        int total = 0;
        for (int i = 1; i <= num; i++){
            if (num % i == 0) total++;
        }
        
        if (total % 2 == 0) return true;
        else return false;
    }
}