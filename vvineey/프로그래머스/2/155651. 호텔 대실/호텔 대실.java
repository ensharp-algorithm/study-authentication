import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] timeTable = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length ;i++){
            timeTable[i] = getTime(book_time[i]);
        }
        
        for (int[]row : timeTable){
            Arrays.sort(timeTable, (o1,o2)->{
                return Integer.compare(o1[0],o2[0]);
            });
        }

        // for (int[]row : timeTable){
        //     System.out.println(Arrays.toString(row));
        // }
        
        
        ArrayList<boolean[]> list = new ArrayList<>();
        list.add(new boolean[1450]);
    
        for (int[] row : timeTable) {
            int start = row[0];
            int end = row[1];

            boolean checked = false;

            
            //분 배열 
            for (boolean[] room : list) {

                boolean possible = true;
                
                for (int i = start; i < end; i++) {
                    
                    if (room[i]) {
                        possible = false;
                        break;
                    }
                }

                
                //기존 배열에 배정
                if (possible) {
                    for (int i = start; i < end; i++) {
                        room[i] = true;
                    }

                    checked = true;
                    break;
                }
            }

            
            
            
            if (!checked) {
                boolean[] newRoom = new boolean[1450];

                for (int i = start; i < end; i++) {
                    newRoom[i] = true;
                }

                list.add(newRoom);
            }
        }
        return list.size();
    }
    
    private int[] getTime(String[] strs){
        String[] str1 = strs[0].split(":");
        String[] str2 = strs[1].split(":");
        
        int start = Integer.parseInt(str1[0])* 60 + Integer.parseInt(str1[1]);
        int end = Integer.parseInt(str2[0])* 60 + Integer.parseInt(str2[1]) + 10;
        
        return new int[]{start,end};
    }
}