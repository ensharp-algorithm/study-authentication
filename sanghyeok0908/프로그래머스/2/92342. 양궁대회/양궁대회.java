import java.util.*;

class Solution {
    
    int[] answer = null;
    int orignalDiff = 0;
    
    public int[] solution(int n, int[] info) {
        dfs(n, info, new int[11], 0, 0, 0, 0);
        return answer == null ? new int[] { -1 } : answer;
    }
    
    void dfs(int n, int[] aArr, int[] bArr,
             int aPoint, int bPoint, int depth, int curCnt) {
        if (curCnt > n) {
            return;
        }
        
        if (curCnt == n) {
            for (int i = depth; i < 11; i++) {
                if (aArr[i] != 0 && aArr[i] >= bArr[i])
                    aPoint += 10 - i;
            }
            
            if (aPoint < bPoint) {                
                // System.out.printf("depth=%d,curCnt=%d,diff=%d\n", depth, curCnt, bPoint-aPoint);
                // System.out.printf("aPoint=%d,bPoint=%d\n", aPoint, bPoint);
                // for (int a : bArr) {
                //     System.out.print(a + " ");
                // }
                // System.out.println();

                update(bPoint - aPoint, bArr);
            }
            return;
        }
        
        // 화살이 남았을 때
        if (depth == 10) {
            int[] newBArr = new int[11];
            newBArr = bArr.clone();
            newBArr[depth] = n - curCnt;
            
            dfs(n, aArr, newBArr, 
               aPoint, bPoint, depth + 1, n);
            return;
        }
        
        // 라이언
        int[] newBArr = new int[11];
        newBArr = bArr.clone();
        newBArr[depth] = aArr[depth] + 1;
        
        dfs(n, aArr, newBArr,
            aPoint, bPoint + 10 - depth, depth + 1, curCnt + newBArr[depth]);
        
        // 어피치
        if (aArr[depth] == 0) {
            dfs(n, aArr, bArr,
                aPoint, bPoint, depth + 1, curCnt);
        } else {
            dfs(n, aArr, bArr,
                aPoint + 10 - depth, bPoint, depth + 1, curCnt);   
        }
    }
    
    void update(int newDiff, int[] arr) {
        if (orignalDiff > newDiff) {
            return;
        } else if (orignalDiff < newDiff) {
            orignalDiff = newDiff;
            answer = arr.clone();
            return;
        }
        
        for (int i = 10; i >= 0; i--) {
            if (answer[i] > arr[i]) {
                return;
            } else if (answer[i] < arr[i]) {
                answer = arr.clone();
                return;
            }
        }
    }
}