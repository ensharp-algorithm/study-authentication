import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            String s = phone.replace(" ", "");
            set.add(s);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}