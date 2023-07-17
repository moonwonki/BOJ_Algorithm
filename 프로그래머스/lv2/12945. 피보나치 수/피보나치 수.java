class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int nminusone = 1;//F(n-1)
        int nminustwo = 0;//F(n-2)
        
        //F(n) = nminusone + nminustwo
        //nminusone을 바꿔줌. n++이 일어나니까.
        //nminustwo을 바꿔줌. n++이 일어나니까
        
        for (int index = 2; index <= n; index++){
            answer = (nminusone + nminustwo) % 1234567;//결과에 큰 차이가 없다!!
            nminustwo = nminusone;
            nminusone = answer;
        }
            
        return answer;
    }
}