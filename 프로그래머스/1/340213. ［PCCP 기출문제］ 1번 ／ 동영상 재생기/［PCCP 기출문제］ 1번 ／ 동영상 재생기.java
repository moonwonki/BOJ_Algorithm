class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int current = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        
        int dev_video_len = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        
        
        int dev_op_start = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int dev_op_end = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
                                      
        for (int i = 0; i < commands.length; i++){
            if (current >= dev_op_start && current <= dev_op_end) {
                current = dev_op_end;
            }
            
            if (commands[i].equals("prev")) {
                current = Math.max(0, current - 10);
            }
            else if (commands[i].equals("next")){
                current = Math.min(dev_video_len, current + 10);
            }
            
        }
        if (current >= dev_op_start && current <= dev_op_end) {
                current = dev_op_end;
        }
        
        int hour = current / 60;
        int minute = current % 60;
        String answer = String.format("%02d", hour) + ":" + String.format("%02d", minute) ;
        return answer;
    }
}