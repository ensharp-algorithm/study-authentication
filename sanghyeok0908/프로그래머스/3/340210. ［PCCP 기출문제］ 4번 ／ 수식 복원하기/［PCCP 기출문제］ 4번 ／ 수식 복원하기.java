import java.util.*;

class Solution {
    
    public String[] solution(String[] expressions) {
        List<Integer> bases = new ArrayList<>();
        
        for (int i = 2; i <= 9; i++) {
            boolean isPossible = true;
            
            // System.out.println("i = " + i);
            
            for (String expression : expressions) {
                String[] split = expression.split(" ");
                
                if (!isValid(split[0], i) || !isValid(split[2], i)) {
                    isPossible = false;
                    break;
                }
                
                if (!split[4].equals("X") && !isValid(split[4], i)) {
                    isPossible = false;
                    break;
                }
                
                if (split[4].equals("X")) {
                    continue;
                }
                
                int A = Integer.parseInt(split[0], i);
                int B = Integer.parseInt(split[2], i);
                int C = split[1].equals("+") ? A + B : A - B;
                
                // System.out.println(A + " " + B + " " + C);
                if (!Integer.toString(C, i).equals(split[4])) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                bases.add(i);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String expression : expressions) {
            String[] split = expression.split(" ");

            if (!split[4].equals("X")) {
                continue;
            }
                
            Set<String> set = new HashSet<>();
            
            for (Integer base : bases) {
                int A = Integer.parseInt(split[0], base);
                int B = Integer.parseInt(split[2], base);
                
                if (split[1].equals("+")) {
                    set.add(Integer.toString(A + B, base));
                } else {
                    set.add(Integer.toString(A - B, base));
                }
            }
            
            String C = set.size() == 1 ? set.iterator().next() : "?";
            result.add(split[0] + " " + split[1] + " " + split[2] + " " + split[3] + " " + C);
        }
        return result.toArray(new String[0]);
    }
    
    boolean isValid(String num, int base) {
        for (char ch : num.toCharArray()) {
            if (ch - '0' >= base) {
                return false;
            }
        }
        return true;
    }
}