class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        
        int answer = 0;
        
        int count = 0;
        
        long numOut = num;
        while (numOut != 1 && count <= 500){
            count++;
            if (numOut % 2 == 0) numOut /= 2;
            else numOut = numOut * 3 + 1;
        }
        
        if (numOut != 1){
            answer = -1;
        }
        else {
            answer = count;
        }
        return answer;
    }
}