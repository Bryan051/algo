import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < line.length(); i++) {
            // 대문자 숫자로 전환, 그 숫자를 인덱스로 해당 알파벳 갯수가 몇개인지
            int idx = line.charAt(i) - 'A';
            alpha[idx]++;
        }
        // 홀수 갯수 구함
        int odd = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i]%2 != 0 ) odd++;
        }
        // 홀수가 1개 이상이면 펠린드롬이 안됨
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        // 아닐시
        String ans = "";
        StringBuilder sb = new StringBuilder();
        // 앞
        for (int i = 0; i < alpha.length ; i++) {
            for (int j = 0; j < alpha[i]/2; j++) {
                sb.append((char) (i + 65));
            }
        }
        // 앞
        ans += sb.toString();
        // 뒤
        String end = sb.reverse().toString();
        // 중간. 홀수일때
        sb = new StringBuilder();
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i]%2==1) {
                sb.append((char)(i+65));
            }
        }
        ans +=sb.toString()+end;
        System.out.println(ans);
    }

}