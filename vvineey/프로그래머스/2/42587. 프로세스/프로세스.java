import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        //인덱스, 우선순위
        Deque<int[]> wait = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
    
        for (int i = 0; i < priorities.length; i++){
            wait.addLast(new int[]{i,priorities[i]});
        }
        
        
        for (int[] value :wait){
            System.out.println(value[0] + " "+ value[1]);
        }
        
        while (!wait.isEmpty()){
            
            //최댓값 찾기
            int maxNum = 0;
            for (int[] value : wait){
                maxNum = Math.max(maxNum, value[1]);
            }
            
            //top이 최댓값이 아니면 뽑아서 맨 뒤에 넣음 
            while (wait.peek()[1] != maxNum){
                wait.addLast(wait.poll());
            }
            
            answer.add(wait.poll()[0]);
        }
        
        return answer.indexOf(location) +1;
    }
}