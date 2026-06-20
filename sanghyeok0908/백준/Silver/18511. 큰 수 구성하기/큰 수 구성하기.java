import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static int[] bruthArr;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int nLen = (N + "").length();
        bruthArr = new int[nLen];
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = nLen; i >= 0; i--) {
            setList(0, i);
            if (!list.isEmpty()) {
                break;
            }
        }
        list.sort((o1, o2) -> (o1 - o2) * -1);
        System.out.println(list.get(0));
    }

    static void setList(int depth, int nLen) {
        if (depth == nLen) {
            String temp = "";
            for (int i = 0; i < nLen; i++) {
                temp += bruthArr[i];
            }

            int result = Integer.parseInt(temp);
            if (result <= N) {
                list.add(result);
                // System.out.println(result);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            bruthArr[depth] = arr[i];
            setList(depth + 1, nLen);
        }
    }
}
/*
 * K == 1:
 * 1th = 1
 * 2th = 1
 * 3th = 1
 * ...
 * 
 * K == 2:
 * 1th = 2
 * 2th = 4
 * 3th = 8
 */