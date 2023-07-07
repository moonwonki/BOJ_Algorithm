import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandsLen = commands.length;
        int[] answer = new int[commandsLen];
        int answerIdx = 0;

        for (int i = 0; i < commandsLen; i++){
            int start = commands[i][0] - 1;
            int finish = commands[i][1] - 1;

            int temp[] = new int[finish - start + 1];
            int index = 0;
            for (int j = start; j <= finish; j++){
                temp[index++] = array[j];
            }

            Arrays.sort(temp);
            answer[answerIdx++] = temp[commands[i][2] - 1];

        }

        return answer;
    }
}