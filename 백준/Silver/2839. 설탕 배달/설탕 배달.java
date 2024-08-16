import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int pb = 0;
        while (n>0) {
            if (n % 5 == 0) {
                pb += n / 5;
                break;
            } else {
                n -= 3;
                pb++;
            }
            if (n < 0) {
                pb = -1;
            }
        }
        bw.write(pb + "");
        bw.flush();
        bw.close();
    }

}