class Solution {
    public String solution(String phone_number) {
        String lastFour = phone_number.substring(phone_number.length() - 4, phone_number.length());
        System.out.println(lastFour);

        int changeLength = phone_number.length() - 4;

        return String.format("%s%s", "*".repeat(changeLength), lastFour);
        
    }
}