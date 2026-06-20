import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Student {
        int cost = 0;
        boolean isVisited = false;
        ArrayList<Student> friends = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int result = 0;
        String[] s3 = br.readLine().split(" ");
        int N = Integer.parseInt(s3[0]);
        int M = Integer.parseInt(s3[1]);
        int k = Integer.parseInt(s3[2]);
        Student[] students = new Student[N];
        String[] s1 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            students[i] = new Student();
            students[i].cost = Integer.parseInt(s1[i]);
        }

        for (int i = 0; i < M; i++) {
            String[] s2 = br.readLine().split(" ");
            int v = Integer.parseInt(s2[0]) - 1;
            int w = Integer.parseInt(s2[1]) - 1;

            students[v].friends.add(students[w]);
            students[w].friends.add(students[v]);
        }

        for (int i = 0; i < N; i++) {
            int min = func(students[i]);

            if (min != Integer.MAX_VALUE)
                result += min;
        }

        if (k >= result) {
            bw.write(result + "\n");
        } else {
            bw.write("Oh no\n");
        }
        br.close();
        bw.close();
    }

    static int func(Student student) {
        if (student.isVisited) return Integer.MAX_VALUE;

        int min = student.cost;

        student.isVisited = true;
        for(Student s: student.friends) {
            if (s.isVisited) continue;

            int result = func(s);
            if (min > result) {
                min = result;
            }
        }

        return min;
    }
}