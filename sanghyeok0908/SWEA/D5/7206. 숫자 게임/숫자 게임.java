
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 숫자는 최대 99999까지이므로 dp 배열 크기 설정
    static int[] dp = new int[100000];
    
    // 방문 여부를 체크하기 위해 dp를 -1로 초기화하거나 별도 배열 사용
    // 여기서는 0이면 방문 안 함, 그 외엔 결과값으로 간주 (단, 결과가 0일 수 있으니 주의 필요. 
    // 이 문제에서 10 미만은 0턴 확정이므로 10 이상인 숫자만 메모이제이션 해도 됨)
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            // 매 테스트케이스마다 DP 초기화 (숫자가 작아서 전역 재사용도 가능하나, 안전하게 초기화)
            // 99999까지의 숫자에 대해 최대 턴수를 저장
            dp = new int[100000]; 
            
            String input = br.readLine();
            int number = Integer.parseInt(input);

            // 결과 계산
            int result = solve(number);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    // 함수 정의: 숫자 n에서 시작했을 때 가능한 '최대' 턴 수를 반환
    static int solve(int n) {
        // 1. 기저 사례 (Base Case): 한 자리 수면 더 이상 쪼갤 수 없음
        if (n < 10) {
            return 0;
        }

        // 2. 메모이제이션 확인 (Memoization)
        // 이미 계산된 적이 있다면 그 값을 반환
        if (dp[n] != 0) {
            return dp[n];
        }

        String s = Integer.toString(n);
        int len = s.length();
        int maxTurn = 0;

        // 3. 비트마스크를 이용한 모든 분할 경우의 수 탐색
        // 자를 수 있는 위치는 len - 1개.
        // 예: 123 (길이 3) -> 틈은 2개 (1^2의 사이, 2^3의 사이)
        // 비트 1: 자른다, 0: 안 자른다.
        // 1부터 (1 << (len - 1)) - 1 까지 반복하면 "적어도 한 번은 자르는" 모든 경우 포함
        for (int i = 1; i < (1 << (len - 1)); i++) {
            int currentProduct = 1;
            int currentPart = s.charAt(0) - '0';

            // 비트마스크를 순회하며 쪼개기
            for (int j = 0; j < len - 1; j++) {
                // j번째 비트가 1이면 여기서 쪼갬 (곱하기 수행)
                if ((i & (1 << j)) != 0) {
                    currentProduct *= currentPart;
                    currentPart = 0; // 초기화
                }
                // 다음 숫자 붙이기
                currentPart = currentPart * 10 + (s.charAt(j + 1) - '0');
            }
            // 마지막 남은 조각 곱하기
            currentProduct *= currentPart;

            // 4. 재귀 호출 및 최댓값 갱신
            // 현재 턴(1) + 쪼개진 수(currentProduct)로 진행했을 때의 최대 턴 수
            int turns = 1 + solve(currentProduct);
            maxTurn = Math.max(maxTurn, turns);
        }

        // 5. 결과 저장 및 반환
        dp[n] = maxTurn;
        return maxTurn;
    }
}

// System.out.println("original Indexes");
// for (int i = 0; i < numbers.length - 1; i++) {
// if (visited[i])
// System.out.print(i + " ");
// }
// System.out.println("\n==============");

// for (Integer i : list) {
// System.out.print(i + " ");
// }
// System.out.println();