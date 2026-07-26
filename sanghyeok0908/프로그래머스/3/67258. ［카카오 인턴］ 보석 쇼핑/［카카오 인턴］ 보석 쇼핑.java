import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i]))
                map.put(gems[i], 0);
        }
        
        List<int[]> result = new ArrayList<>();
        int rubyCnt = map.size();
        int[] section = new int[2];
        section[0] = 0;
        section[1] = 0;
        map.clear();
        map.put(gems[0], 1);
        
        if (map.size() >= rubyCnt) {
            result.add(new int[] { section[0], section[1] });
        }
        
        for (int i = 1; i < gems.length; i++) {
            // System.out.println(i + " " + gems[i]);
            
            if (map.containsKey(gems[i])) {
                map.put(gems[i], map.get(gems[i]) + 1);
                section[1]++;
                // System.out.println("map에 이미 존재");
                // System.out.printf("section[1] = %d 보석 개수 = %d\n", section[1], map.get(gems[i]));
                
                if (gems[section[0]].equals(gems[i])) {
                    // System.out.println("처음 것과 동일한 것");
                    
                    while(section[0] <= section[1] && map.get(gems[section[0]]) > 1) {
                        // System.out.println("section[0] = " + section[0] + " 보석 개수 = " + map.get(gems[section[0]]));
                        map.put(gems[section[0]], map.get(gems[section[0]]) - 1);
                        section[0]++;
                    }
                }
            } else {
                map.put(gems[i], 1);
                section[1]++;
                // System.out.println("처음 등장하는 보석");
                // System.out.printf("section[1] = %d 보석 개수 = %d\n", section[1], map.get(gems[i]));
            }
            
            if (map.size() >= rubyCnt) {
                result.add(new int[] { section[0], section[1] });
            }
        }
        
        int[] answer = new int[] { 0, 100010 };
        // System.out.println("answer print");
        for (int[] i : result) {
            // System.out.println(i[0] + " " + i[1]);
            // System.out.println(answer[0] + " " + answer[1]);            
            // System.out.println((i[1] - i[0]) + " " + (answer[1] - answer[0]) + " " + (i[1] - i[0] < answer[1] - answer[0]));
            if (i[1] - i[0] < answer[1] - answer[0]) {
                answer = i;
            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
}