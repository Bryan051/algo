import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (char c : input) {
                switch (c) {
                    case '-':
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                        break;
                    case '<':
                        if (!left.isEmpty()) {
                            right.offerFirst(left.pollLast());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.offerLast(right.pollFirst());
                        }
                        break;
                    default:
                        left.offerLast(c);
                        break;
                }
            }

            while (!left.isEmpty()) {
                sb.append(left.pollFirst());
            }
            while (!right.isEmpty()) {
                sb.append(right.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }



}
