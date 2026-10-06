import java.util.*;

class Solution {
    static String[] arr;
    static boolean[] visited;
    static HashSet<Integer> hs;
    
    public int solution(String numbers) {
        
        arr = numbers.split("");
        visited = new boolean[arr.length];
        hs = new HashSet<>();
        
        System.out.println(Arrays.toString(arr));
        makePrimeNum("");
        
    
        return hs.size();
    }
    
    private void makePrimeNum(String str){
        
        if (str.length() > 0 && isPrime(Integer.parseInt(str))){
            hs.add(Integer.parseInt(str));
        }
        
        if (str.length() == arr.length){
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            makePrimeNum(str + arr[i]);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        
        if(num < 2){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if (num % i ==0){
                return false;
            }
        }
        
        return true;
    }
}