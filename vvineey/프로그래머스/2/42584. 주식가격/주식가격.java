import java.util.*;


class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer> st = new Stack<>();

        
        
        
        for (int i = 0; i < prices.length; i++) {

            int currentPrice = prices[i];

            while (!st.isEmpty()) {
                
                int pastIndex = st.peek();
                int pastPrice = prices[pastIndex];

                if (currentPrice < pastPrice) {
                    st.pop();

                    answer[pastIndex] = i - pastIndex;
                } 
                
                else {
                    break;
                }
            }

            st.push(i);
        }
        
        

        while (!st.isEmpty()) {
            int index = st.pop();

            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}