class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xLong = (long) x;
        long nLong = (long) n;
        for (long i = 0; i < nLong; i++){
            answer[(int)i] = xLong * (i + 1);
        }
        return answer;
    }
}