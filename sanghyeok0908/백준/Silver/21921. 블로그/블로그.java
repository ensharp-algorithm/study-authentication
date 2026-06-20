import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int max = sum;
        for (int i = X; i < N; i++) {
            sum -= arr[i - X];
            sum += arr[i];
            max = Math.max(max, sum);
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        int cnt = 0;
        sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }
        
        if (sum == max)
            cnt++;

        for (int i = X; i < N; i++) {
            sum -= arr[i - X];
            sum += arr[i];
            if (sum == max)
                cnt++;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
