import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
		int answer = 0;
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < strArr.length; i++){
			int length = strArr[i].length();
			if (countMap.containsKey(length)) {
				countMap.replace(length, countMap.get(length) + 1);
			}
			else {
				countMap.put(length, 1);
			}
		}

		int maxAppearance = 0;
		Collection<Integer> values = countMap.values();
		for (Integer number : values){
			maxAppearance = Math.max(number, maxAppearance);
		}

		return maxAppearance;
	}
}