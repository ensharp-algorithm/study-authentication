import java.util.*;

class Solution {
    
    HashMap<String, Integer> bag;
    HashSet<String> set;
    int n;
    int[] answer;
    
    public int[] solution(String[] gems) {
        
        bag = new HashMap<>();
        set = new HashSet<>();
        answer = new int[] {0, gems.length - 1};
        
        for (String gem : gems){
            set.add(gem);
        }
        
        n = set.size();
        shop(gems);
    
        // 문제에서는 1번부터 시작
        return new int[] {answer[0] + 1, answer[1] + 1};
    }
    
    private void shop(String[] gems){
        
        int left = 0; 
        int right = 0;
        
        while (right < gems.length){
            
            // right 보석 추가
            bag.put(gems[right], bag.getOrDefault(gems[right], 0) + 1);
            
            // System.out.println(left + " " + right + " " + bag);
            
            // 모든 종류의 보석을 담았다면
            while (bag.size() == n){
                
                // System.out.println(" > " + left + " " + right);
                
                // 갱신
                if (answer[1] - answer[0] > right - left) {
                    answer = new int[] {left, right};
                }
                
                // left 보석 제거
                bag.put(gems[left], bag.get(gems[left]) - 1);
                
                // 완전히 없 -> Map에서도 제거
                if (bag.get(gems[left]) == 0){
                    bag.remove(gems[left]);
                }
                
                left++;
            }
            
            right++;
        }
    }
}