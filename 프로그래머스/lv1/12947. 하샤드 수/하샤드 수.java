class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int xTemp = x;
        while(xTemp != 0){
            sum += xTemp % 10;
            xTemp /= 10;
        }
        
        
        return x % sum == 0;
    }
}