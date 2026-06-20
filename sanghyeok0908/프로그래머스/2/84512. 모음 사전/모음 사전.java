import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    String[] arr;
    String[] original = new String[] { "A", "E", "I", "O", "U" };
    
    public int solution(String word) {
        initArr();
        
        // for (String s : list) {
        //     System.out.println(s);
        // }
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i + 1;
            }
        }
        
        return -1;
    }
    
    void initArr() {
        for (int i = 1; i <= 5; i++) {
            arr = new String[i];
            // System.out.println("size = " + i);
            dfs(0, i);
        }
        Collections.sort(list);
    }
    
    void dfs(int depth, int size) {
        if (depth == size) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(arr[i]);
            }
            list.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            arr[depth] = original[i];
            dfs(depth + 1, size);
        }
    }
}