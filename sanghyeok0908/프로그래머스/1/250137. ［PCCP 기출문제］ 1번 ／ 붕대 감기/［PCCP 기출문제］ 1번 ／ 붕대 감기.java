
class Solution {
    
    int[] attackInfo = new int[1010];
    int maxHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = attacks[attacks.length - 1][0];
        maxHealth = health;
        
        for (int[] at : attacks) {
            attackInfo[at[0]] = at[1];
        }
        
        for (int curTime = 1, successCnt = 0; curTime <= lastAttackTime; curTime++) {
            if (attackInfo[curTime] == 0) {
                successCnt++;
                
                health = recover(bandage[1], health);
                
                if (successCnt >= bandage[0]) {
                    health = recover(bandage[2], health);
                    successCnt = 0;
                }
            } else {
                successCnt = 0;
                health -= attackInfo[curTime];
            }
            
            // System.out.printf("t = %d, h = %d cnt = %d\n", curTime, health, successCnt);
            
            if (health <= 0) {
                return -1;
            }
        }
        
        return health;
    }
    
    int recover(int increase, int curHealth) {
        if (curHealth + increase >= maxHealth) {
            return maxHealth;
        }
        return curHealth + increase;
    }
}