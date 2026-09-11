import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int [][] condition = new int [3][3];
        
        for (int [] row : condition){
            Arrays.fill(row,1);
        }
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i > j){
                    condition[i][j] = (int)Math.pow(5, (i-j));
                }
            }
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            
            if (o1[0] != o2[0]){
                return Integer.compare(o2[0], o1[0]);
            }
            if (o1[1] != o2[1]){
                return Integer.compare(o2[1], o1[1]);
            }
            
            return Integer.compare(o2[2], o1[2]);
        });
        
        
        int range = Math.min((picks[0] + picks[1] + picks[2]) * 5 , minerals.length);
        System.out.println(range);
        
        int[] arr = new int[3];
        Arrays.fill(arr,0);
        int cnt = 0;
        
        for (int i = 0; i < range; i++) {
            
            cnt++;
            
            if (minerals[i].equals("diamond")){
                arr[0]++;
            }
            
            if (minerals[i].equals("iron")){
                arr[1]++;
            }
            
            if (minerals[i].equals("stone")){
                arr[2]++;
            }
            
            if (cnt == 5 || i == range-1){
                
                
                queue.offer(arr);
                
                arr = new int[3];
                Arrays.fill(arr,0);
                cnt = 0;
            }
        }
        
        
        int answer = 0;
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < picks[i]; j++){
                
                if (queue.isEmpty()){
                    break;
                }
                
                int[] current = queue.poll();
                
                //다이아 
                answer += current[0] * condition[i][0];
                 
                //철
                answer += current[1] * condition[i][1];
                
                //돌
                answer += current[2] * condition[i][2];
            }
        }
        
        
        return answer;
    }
}