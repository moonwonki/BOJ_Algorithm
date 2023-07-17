class Solution {
    static int dp[];
    
    public int solution(int n) {
        int answer = 0;
        
        int nminusone = 1;
        int nminustwo = 0;
        
        for (int index = 2; index <= n; index++){
            answer = (nminusone + nminustwo) % 1234567;
            nminustwo = nminusone;
            nminusone = answer;
        }
        
        
        return answer;
    }
}