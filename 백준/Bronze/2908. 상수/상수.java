import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer a = new StringBuffer(st.nextToken()).reverse();
        StringBuffer b = new StringBuffer(st.nextToken()).reverse();

        int n = Integer.parseInt(String.valueOf(a));
        int m = Integer.parseInt(String.valueOf(b));

        System.out.println(Math.max(n, m));

    }

}