import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
       
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        
        //하나씩 넣기 
        for(Integer num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        
        
        return Math.min(hm.size(),nums.length/2);
    }
}