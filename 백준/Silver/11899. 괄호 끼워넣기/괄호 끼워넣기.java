import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),")(",true);
        int l = st.countTokens();

        String[] s = new String[l];
        for (int i = 0; i < l ; i++) {
            s[i] = st.nextToken();
        }

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < l; i++) {
            if(stack.isEmpty()) { // 스택이 비어 있으면 그냥 삽입
                stack.add(s[i]);
            }
            else { //  pop 하고 input[i] 은 차례를 넘김
                if(stack.peek().equals("(") && s[i].equals(")")) {
                    stack.pop();
                }
                else {
                    stack.add(s[i]);
                }
            }
        }
        System.out.println(stack.size());
    }
}