import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        //위치, 우선순위
        Deque<int[]> wait = new ArrayDeque<>();
        int n = priorities.length;
        
        
        //0번 프로세스 넣기이
        wait.offer(new int[]{0,priorities[0]});
        
        
        System.out.println("현재 대기 큐 상태");
        for (int[] k : wait){
            System.out.println(k[0] + " " + k[1]);
        }
        
        
        for (int i = 1; i < n;i++){
            int current = priorities[i];
            
            System.out.println("==========");
            System.out.println("i " + i + " current " + current + "\n현재 대기 큐 상태");
            for (int[] k : wait){
                System.out.println(k[0] + " " + k[1]);
            }

            wait.offer(new int[]{i,current});
            
            int cnt = wait.size();
            while (cnt >= 0) {
                
                int[] top = wait.poll();
                
                if (top[1] <= current) {

                    System.out.println(top[1] + " vs " + current);
                    wait.offer(top);
                }
                else{
                     wait.addLast(top);
                }
                cnt--;
            }
 
        }
        
        
        System.out.println("==========");
        int answer = 0;
        int cnt = 0;
        
        
        System.out.println("마지막 대기 큐 상태\n ");
        for (int[] i : wait){
            cnt++;
            System.out.println(i[0] + " " + i[1]);
            if (i[0] == location){
                answer = cnt;
            }
        }
        
        System.out.println("==========");

        return answer;
    }
}