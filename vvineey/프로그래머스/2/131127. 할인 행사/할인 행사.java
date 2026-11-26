import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        int left = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        
        for (int i = 0; i < number.length; i++){
            hm.put(want[i], number[i]);
            hs.add(want[i]);
        }
        
        for (int i = 0; i < 10; i++){
            if (hm.containsKey(discount[i])){
                hm.put(discount[i], hm.get(discount[i])-1);
            }
        }
        
        int cnt = 0;
        int answer = 0;
        
        boolean flag = true;
        for (int value : hm.values()) {
            if (value != 0){
                   flag = false;
            }
        }
            
        if (flag){
            answer++;
        }
        
        while(left + 10 < discount.length){

            if (hs.contains(discount[left])){
                 hm.put(discount[left], hm.getOrDefault(discount[left],0)+1);
            }
            
            left++;
            
            if (hm.containsKey(discount[left+10-1])){
                hm.put(discount[left+10-1], hm.get(discount[left+10-1])-1);
            }
            
            flag = true;
            for (int value : hm.values()) {
                if (value != 0){
                    flag = false;
                }
            }
            
            if (flag){
                answer++;
            }
        }
        
        return answer;
    } 
}