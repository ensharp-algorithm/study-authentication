import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> str = new LinkedList<>();

        String inputString = br.readLine();
        int M = Integer.parseInt(br.readLine());

        for (char c : inputString.toCharArray()) {
            str.add(c);
        }

        ListIterator<Character> iterator = str.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            if (command.charAt(0) == 'P') {
                iterator.add(command.charAt(2));
            } else if (command.charAt(0) == 'L' && iterator.hasPrevious()) {
                iterator.previous();
            } else if (command.charAt(0) == 'D' && iterator.hasNext()) {
                iterator.next();
            } else if (command.charAt(0) == 'B' && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            }
        }

        for(char c : str) {
            bw.write(c);
        }
        
        bw.flush();
        bw.close();
    }
}
