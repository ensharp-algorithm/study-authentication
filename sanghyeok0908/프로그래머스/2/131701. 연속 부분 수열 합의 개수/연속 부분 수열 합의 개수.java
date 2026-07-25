import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        for (int i = 1; i <= elements.length; i++) {
            accumulate(elements, i);
        }
        return set.size();
    }
    
    void accumulate(int[] elements, int size) {
        int sum = 0;
        
        // System.out.println("size = " + size);
        
        for (int i = 0; i < size; i++) {
            sum += elements[i];
        }
        
        // System.out.println("sum = " + sum + "====");
        
        set.add(sum);
        
        for (int i = size, j = 0; i < size + elements.length; i++, j++) {
            int idx = i % elements.length;
            
            // System.out.println("idx = " + idx);
            
            sum -= elements[j];   
            // System.out.println("minus = " + elements[j]);
            
            sum += elements[idx];
            set.add(sum);
            // System.out.println("plus = " + elements[idx]);
            // System.out.println("sum = " + sum + "====");
        }
        // System.out.println("return = " + set.size());
    }
}