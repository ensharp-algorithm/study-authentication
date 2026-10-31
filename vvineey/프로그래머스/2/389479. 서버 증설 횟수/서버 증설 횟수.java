class Solution {
    public int solution(int[] players, int m, int k) {
        
        int result = 0;
        int [] servers = new int[24]; 
        
        for (int i = 0; i < players.length; i++){
            
            if (players[i] < m){
                continue;
                
            }
            
            if (servers[i] >= getServerCount(players[i],m)) {
                continue;
            }
            
            int add = getServerCount(players[i],m) - servers[i];
             
            for (int j = i; j < Math.min(i+k, players.length); j++){
                servers[j] += add;
            }
            result+= add;
        }
        return result;
    }
    
    private int getServerCount(int player, int m){
        return player / m;
    }
}