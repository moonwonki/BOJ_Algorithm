class Solution {
    public String solution(String s) {
        String[] numberString = s.split(" ");

        int numbers[] = new int[numberString.length];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberString.length; i++){
            numbers[i] = Integer.parseInt(numberString[i]);
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        return (min + " " + max);
    }
}