
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {

        Arrays.sort(plans, (o1, o2) ->
            Integer.compare(getTime(o1[1]), getTime(o2[1]))
        );

        int n = plans.length;
        String[] answer = new String[n];
        int idx = 0;


        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n - 1; i++) {

            int start = getTime(plans[i][1]);
            int nextStart = getTime(plans[i + 1][1]);
            int duration = Integer.parseInt(plans[i][2]);

            int available = nextStart - start;

            if (duration > available) {
                int rest = duration - available;
                stack.push(new int[]{i, rest});
                continue;
            }

            answer[idx++] = plans[i][0];
            available -= duration;

            
            while (available > 0 && !stack.isEmpty()) {

                int[] sub = stack.pop();

                if (sub[1] <= available) {
                    available -= sub[1];
                    answer[idx++] = plans[sub[0]][0];
                } else {
                    sub[1] -= available;
                    stack.push(sub);
                    available = 0;
                }
            }
        }

        answer[idx++] = plans[n - 1][0];

        while (!stack.isEmpty()) {
            int[] sub = stack.pop();
            answer[idx++] = plans[sub[0]][0];
        }

        return answer;
    }

    private int getTime(String str) {
        String[] strs = str.split(":");
        return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
    }
}
