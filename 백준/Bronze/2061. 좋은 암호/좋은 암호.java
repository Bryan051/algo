import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 주어진 값이 long 보다 큰 값이었음.
        BigInteger k = new BigInteger(st.nextToken());
        BigInteger l = new BigInteger(st.nextToken());

        // l 보다 큰 경우는 good 이므로 그 이하만 고려 해 주면 된다.
        // 소수가 l 보다 작을경우 n으로 지정할것.
        int n = 0;

        long a = 0,b = 0;
        for (int i = 2; i < l.intValue(); i++) {
            // .remainder(BigInteger 나머지연산).compareTo(BigInteger의 0 값)을 비교함
            // A compareTo B -> A>B =1 / A = b = 0/ A < B = -1
            // compareTo 의 결과값이 0 인게 == 0 일때 (k를 나눈 나머지가 0과 같을 때 ) n 을 i로
            if((k.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
                n = i;
                break;
            }
        }
        //삼항연산자로 S값에 N값의 여부에 따른 값 저장
        String S = (n > 0)? ("BAD " + n) : "GOOD";

        System.out.println(S);

    }

}