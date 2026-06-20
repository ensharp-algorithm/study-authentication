
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Student {
        public int idx, num, cnt;

        public Student(int idx, int num) {
            this.idx = idx;
            this.num = num;
            this.cnt = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Student> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o1.idx - o2.idx;
            }
            return o1.cnt - o2.cnt;
        });

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            PriorityQueue<Student> copyHeap = new PriorityQueue<>(heap);
            // System.out.println("========");
            while(!copyHeap.isEmpty()) {
                Student temp = copyHeap.poll();
                // System.out.printf("idx = %d, num = %d, cnt = %d\n", temp.idx, temp.num, temp.cnt);
            }

            int num = Integer.parseInt(st.nextToken());
            Student updated = null;

            for (Student student : heap) {
                if (student.num == num) {
                    updated = student;
                    break;
                }
            }

            if (updated != null) {
                // heap의 재 정렬을 위해 제거 후 재 삽입
                heap.remove(updated);
                updated.cnt++;
                heap.add(updated);
                continue;
            }

            if (heap.size() < N) {
                heap.add(new Student(i, num));
                continue;
            }

            heap.poll();
            // System.out.printf("idx = %d, num = %d, cnt = %d\n", removed.idx, removed.num, removed.cnt);
            heap.add(new Student(i, num));
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        while (!heap.isEmpty()) {
            answer.add(heap.poll().num);
        }

        while(!answer.isEmpty()) {
            sb.append(answer.poll() + " ");
        }
        sb.append('\n');
        System.out.println(sb);
    }
}
