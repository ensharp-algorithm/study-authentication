import java.util.*;

class Solution {
    
    static int n;
    static int[] rocks;
    static int diff;
    static int distance;
    
    public int solution(int distance, int[] rocks, int n) {
    
        this.rocks = rocks;
        this.n = n;
        this.diff = distance;
        this.distance = distance;

        Arrays.sort(rocks);
        binarySearch (0,distance);
        
        return diff;
    }
    

    //0이랑 다른 돌 : 2-0, 11-0, 14-0 ...         (2,11,14 ...)
    //2랑 다른 돌 : 11-2, 14-2, 17-2 ...          (9,12,15 ...)
    //11이랑 다른 돌 : 14-11, 17-11, 21-11 ...    (3,4,10 ...)
    
    //mid = 12 : 12만큼 뛸래
    //mid = 6 : 6만큼 뛸래 
    
    private void binarySearch(int left, int right){
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            int cnt = 0;
            int rock = 0;
            int currentDiff = 0;
            
            //System.out.println("\nleft " + left + " mid " + mid + " rifht " + right);
            
            
            for (int another : rocks){
                currentDiff = another - rock;
                
                // System.out.print("현재 돌 " + rock + "에서 다른 돌 " + another + "로 점프 : " + currentDiff);
            
                if (currentDiff < mid){
                    cnt++;
                    // System.out.print(" 얘 없어도 뛰겠다 그냥 제거\n");   
                }
                else{
                    rock = another;
                    // System.out.print("점프 가능 얘 기준으로 다시 점프함\n");   
                }
            }
            
            if (distance - rock < mid) {
                cnt++;
            }
            
            if (cnt <= n) {
                diff = mid;              
                left = mid +1;
                // System.out.println(cnt + "개 제거하고 만들었음 더 크게 점프할 수 있겠는데 \n 갱신! " + diff);
            }
            
            else{
                // System.out.println(cnt + "개 제거하고 만들었음 이건 못 뛴다");
                right = mid -1;
            }
        }
        
    }
    
    
        
        
    
}