import java.util.*;

class Solution {

    static int[] sale_rate = {10, 20, 30, 40};
    static int[][] users;
    static int[] emoticons;
    static PriorityQueue<int[]> answer;

    public int[] solution(int[][] users, int[] emoticons) {

        Solution.users = users;
        Solution.emoticons = emoticons;

        answer = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });

        int[] rates = new int[emoticons.length];
        int[] prices = new int[users.length];

        dfs(rates,prices, 0);

        return answer.poll();
    }

    private void dfs(int[] rates, int[] prices, int idx) {
        
        if (idx == emoticons.length){
            //모든 이모티콘의 할인율 결정 -> 이모티콘 플러스 가입 여부 갱신 
            
            int [] result = new int[2];
            
            for (int i = 0; i < users.length; i++){
                result[1] += prices[i];
                
                if (prices[i] >= users[i][1]){
                    result[0]++;
                    result[1] -= prices[i];
                }
            }
            
            answer.offer(result);
            return;
        }
        
        
        for (int i = 0; i < 4; i++){
            
            rates[idx] = sale_rate[i];
            int price = emoticons[idx] * (100 - sale_rate[i]) / 100;
            
            for (int j = 0; j < users.length; j++){
                if (rates[idx] >= users[j][0]) {
                    prices[j] += price;
                }  
            }
            
            dfs(rates,prices, idx+1);
            
            for (int j = 0; j < users.length; j++){
                if (rates[idx] >= users[j][0]) {
                    prices[j] -= price;
                }  
            }

        }
     
    }
}