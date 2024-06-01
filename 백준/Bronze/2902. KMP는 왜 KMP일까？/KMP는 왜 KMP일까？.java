import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] name;
    static String name1;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        int countName = st.countTokens();
        for (int i = 0; i < countName ; i++) {
            System.out.print(st.nextToken().charAt(0));
        }
    }
}