import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int answer[] = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        ArrayList<Integer> numList = new ArrayList<>();
        
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            small = Math.min(small, arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != small) numList.add(arr[i]);
        }
        
        int answer[] = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++){
            answer[i] = numList.get(i);
        }
        
        
        return answer;
    }
}