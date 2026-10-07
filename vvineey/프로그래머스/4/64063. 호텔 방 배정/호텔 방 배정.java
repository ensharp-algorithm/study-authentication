import java.util.*;

class Solution {
    
    static HashMap<Long,Long> used;
    
    public long[] solution(long k, long[] room_number) {
        
        used = new HashMap<>();
        long[] answer = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++){
            // System.out.println("--------------");
            long want = room_number[i];
            long room = find(want);
            // System.out.println(">");
            used.put(room, find(room+1));
            answer[i] = room;
        }
        
        return answer;
    }
    private long find(long request){
        
        // System.out.println(request);
        if (!used.containsKey(request)){
            return request;
        }
        
        long room = find(used.get(request));
        used.put(request,room);
        
        return room;
    }
}