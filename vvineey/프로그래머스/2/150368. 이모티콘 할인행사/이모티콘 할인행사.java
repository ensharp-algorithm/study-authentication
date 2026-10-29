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

        dfs(rates, 0);

        return answer.poll();
    }

    private void dfs(int[] rates, int idx) {

        if (idx >= emoticons.length) {

            int[] result = new int[2];

            for (int j = 0; j < users.length; j++) {
                
                // System.out.println(j + "번째 사용자");

                int price = 0;
                for (int k = 0; k < emoticons.length; k++) {
                    
                // System.out.println(k + "번째 이모티콘");
                    
                    if (rates[k] >= users[j][0]) {
                        // System.out.println("> 구매" );
                        price += emoticons[k] * (100 - rates[k]) / 100;
                    }
                }

                if (price >= users[j][1]) {
                    // System.out.println(">> 가입" );
                    result[0]++;
                }
                
                else {
                    result[1] += price;
                }
            }

            answer.offer(result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            rates[idx] = sale_rate[i];
            dfs(rates, idx + 1);
        }
    }
}