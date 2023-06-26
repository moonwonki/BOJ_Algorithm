class Solution {
    static int[] numArray;
    static int targetNum;
    static int length;
    static int result;
    
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        targetNum = target;
        result = 0;

        numArray = new int[length];
        for (int i = 0; i < length; i++){
            numArray[i] = numbers[i];
        }

        dfs(new boolean[length], 0);

        return result;
    }


    public static void dfs(boolean[] plusMinus, int count){
        if (count == length){
            int sum = 0;
            for (int i = 0; i < length; i++){
                if (plusMinus[i]) sum += numArray[i];
                else sum -= numArray[i];
            }
            if (sum == targetNum) result++;
            return;
        }

        plusMinus[count] = true;
        dfs(plusMinus, count + 1);
        plusMinus[count] = false;
        dfs(plusMinus, count + 1);
    }
}