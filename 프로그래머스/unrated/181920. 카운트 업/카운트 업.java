class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];
        
        int index = 0;
        while (start <= end){
            answer[index++] = start++;
        }
        return answer;
    }
}