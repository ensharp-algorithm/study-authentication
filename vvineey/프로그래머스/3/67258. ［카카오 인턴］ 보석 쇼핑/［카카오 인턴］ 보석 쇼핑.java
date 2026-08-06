import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        
        HashSet<String> gemSet = new HashSet<>();
        HashMap<String, Integer> shopping = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        
        //
        for (String s : gems){
            gemSet.add(s);
        }
        //
        
        
        int left = 0;
        int right = 0;
        
        int bestLeft = left;
        int bestRight = right;
        
        while(right < gems.length){
            
//             System.out.println(left + " " + right);
//             System.out.println(shopping);
         
            shopping.put(gems[right], shopping.getOrDefault(gems[right],0) +1);
            right++;
            
            //모든 보석을 다 담았고 left를 빼도 만족하면 길이를 갱신
            while (shopping.size() == gemSet.size()){
                
//                 System.out.println(left + " " + right);
//                 System.out.println(shopping);
            
                shopping.replace(gems[left],shopping.get(gems[left])-1);
                
                if (shopping.get(gems[left]) == 0 ){
                    shopping.remove(gems[left]);
                }
                
                left ++;
                
                if (right - left + 1 < minLength){
                    minLength = Math.min(minLength, right - left +1);
                    // System.out.println("minLength "  + minLength + " current length " + (right - left +1));

                    bestLeft = left;
                    bestRight = right;
                }
            }
            
    
            
        }
        
        int[] answer = new int[]{bestLeft,bestRight};
        
        return answer;
    }
}