import java.util.*;

class Solution {
    static int total = 0;
    public int solution(int[] numbers, int target) {
        total = 0;
        dfs(0, 0, numbers, target);    
        return total;
    }
    
    public void dfs(int currentNumber, int currentStep, int[] numbers, int target){
        if (currentStep == numbers.length) {
            if (currentNumber == target) total++;
            return;
        }
        dfs(currentNumber + numbers[currentStep], currentStep + 1, numbers, target);
        dfs(currentNumber - numbers[currentStep], currentStep + 1, numbers, target);
    }
}