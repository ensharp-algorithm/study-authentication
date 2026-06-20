import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int maxScore = 0;
        int p1Score = 0;
        int p2Score = 0;
        int p3Score = 0;
        
        
        for (int i =0;i<answers.length;i++){
            int answer = answers[i];
            
            System.out.println(i%10);
            
            //p1
            if (p1[i%p1.length] == answer){
                p1Score++;
            }
            
            //p2
               if (p2[i%p2.length] == answer){

                p2Score++;
            }
            
            //p3
               if (p3[i%p3.length] == answer){
                p3Score++;
            }
        }
        
     
        maxScore = Math.max(p1Score,p2Score);
        maxScore = Math.max(maxScore,p3Score);
        
        
        
        if (p1Score == maxScore){
           list.add(1);
        }
          if (p2Score == maxScore){
           list.add(2);
        }
          if (p3Score == maxScore){
           list.add(3);
        }
        
        
          int [] answerList = new int[list.size()];
        
        for (int i = 0; i < list.size() ;i++){
            answerList[i] = list.get(i);
        }
        
   
        return answerList;
    }
}