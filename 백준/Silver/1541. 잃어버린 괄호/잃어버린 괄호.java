import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        최대 5자리
        연산자 연속 두개 x
        0 시작 가능
        괄호쳐서 최소
         */
        StringTokenizer st = new StringTokenizer(br.readLine(),"+-",true);
        int n = st.countTokens();
        int sum = 0;
        int minus = 0;
        boolean tmp = false;

        for (int i = 0; i < n; i++) {
            String target = st.nextToken();

            if (tmp == false && !target.equals("-") && !target.equals("+")) {
                sum += Integer.parseInt(target);
            }
            else if (target.equals("-") && tmp == false) {
                tmp = true;
            }
            else if (tmp == true && !target.equals("-") && !target.equals("+")) {
                minus += Integer.parseInt(target);
            }
            else if (target.equals("+")) {
                continue;
            }

        }

        System.out.println(sum - minus);


    }


}
