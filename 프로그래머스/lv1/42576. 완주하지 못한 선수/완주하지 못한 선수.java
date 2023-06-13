import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        LinkedList<String> runners = new LinkedList<String>(Arrays.asList(participant));
        
        runners.sort(Comparator.naturalOrder());
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++){
            int indexOfRunner = runners.indexOf(completion[i]);
            if (indexOfRunner >= 0) runners.remove(indexOfRunner);
        }
        
        answer = runners.get(0);
        
        return answer;
    }
}