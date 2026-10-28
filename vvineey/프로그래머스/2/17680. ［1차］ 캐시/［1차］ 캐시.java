import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0 ){
            return cities.length * 5;
        }
        
        ArrayDeque<String> cache = new ArrayDeque<>();
        
        int total = 0;
        
        for (String city : cities){
            
            city = city.toLowerCase();
            
            if (cache.contains(city)){
                cache.remove(city);
                total++;
            }
            else { 
                
                if (cache.size() >= cacheSize) {
                    cache.removeLast();
                }
                total+=5;
            }
            cache.addFirst(city);
        }
        
        
        return total;
    }
}