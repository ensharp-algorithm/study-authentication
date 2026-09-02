class Solution {
    public int solution(int n) {
        if (n % 2 != 0)
            return 0;
        
        int[] even = new int[n + 1], odd = new int[n + 1];
        even[0] = 1;
        odd[1] = 1;
        for (int i = 2; i <= n; i++) {
            even[i] = (int)((even[i - 2] + (2 * (long)odd[i - 1] % 1000000007)) % 1000000007);
            odd[i] = (int)(((long)even[i - 1] + odd[i - 2]) % 1000000007);
        }
        return even[n];
    }
}