import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int n, int[][] wires) {
        
        this.answer = n - 1;
        int target = 0;
        
        HashSet<Integer> set1;
        HashSet<Integer> set2;
        
        while (target < n - 1) {
            
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            
            set1.add(wires[target][0]);
            set2.add(wires[target][1]);
            
            for (int repeat = 0; repeat < n - 1; repeat++) {
                
                for (int i = 0; i < wires.length; i++) {
                    
                    if (i == target) {
                        continue;
                    }
                    
                    if (set1.contains(wires[i][0])|| set1.contains(wires[i][1])) {
                        
                        set1.add(wires[i][0]);
                        set1.add(wires[i][1]);
                    }
                    
                    if (set2.contains(wires[i][0])|| set2.contains(wires[i][1])) {
                        
                        set2.add(wires[i][0]);
                        set2.add(wires[i][1]);
                    }
                }
            }
            
            System.out.println("자를 간선 : " + wires[target][0] + " " + wires[target][1]); 
            System.out.println(set1); System.out.println(set2);
            
            returnDiff(set1, set2);
            target++;
        }
        
        return answer;
    }
    
    private int returnDiff(HashSet<Integer> set1,HashSet<Integer> set2) {
        
        int diff = Math.abs(set1.size() - set2.size());
        answer = Math.min(answer, diff);
        
        System.out.println(diff); 
        System.out.println();
        
        return diff;
    }
}