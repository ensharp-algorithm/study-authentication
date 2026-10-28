import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        //차량 번호 : 누적시간
        TreeMap<String, Integer> tm = new TreeMap<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String record : records){
            String[] input = record.split(" ");
            int time = getTime(input[0]);
            String carNum = input[1];
            String state = input[2];
            
            if (state.equals("IN")) {
               hm.put(carNum,time); 
            }
            
            else {
                int inTime = hm.get(carNum);
                hm.remove(carNum);
                tm.put(carNum, tm.getOrDefault(carNum, 0) + time - inTime);
            }
        }
        
        
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String carNum = entry.getKey();
            int inTime = entry.getValue();
            
            tm.put(carNum, tm.getOrDefault(carNum, 0) + getTime("23:59") - inTime);
        }
        
        
        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            
            String carNum = entry.getKey();
            int value = entry.getValue();
            
            int time  = value > fees[0] ? value - fees[0] : 0;
            int cost = fees[1] + 
                (int) Math.ceil((double) time / fees[2]) * fees[3];
            
            tm.put(carNum, cost);
        }
        
        
        int[] result = new int[tm.size()];
        int idx = 0;
        
        for (int value : tm.values()) {
            result[idx++] = value;
        }
        
        return result;
    }
    
    private int getTime(String str){
        String[] strs = str.split(":");
        
        return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
    }
}