import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        int[] amount_left = new int[progresses.length];
        
        //작업 일수 계산 
        for (int i = 0;i<progresses.length;i++){
            double left = 100 - progresses[i];
            amount_left[i] = (int)Math.ceil(left/speeds[i]);
        }
        
//         for(int a : amount_left){
//             System.out.println(a + " ");
//         }
    
        
        //배포 일 계산
        int cnt = 1;
        int max = amount_left[0];
        
        for (int i = 1; i < progresses.length ; i++){
            
            if (max >= amount_left[i]){
                cnt++;
            }
            else{
                answerList.add(cnt);
                max = amount_left[i];
                cnt =1;
            }
        }
        
        

         answerList.add(cnt);
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
}