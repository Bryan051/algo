import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int movie = 666; //영화 제목이 들어갈 변수
        int count = 1; //반복문 카운트 셀 변수

        while (n > count) {
            movie++;

            if (String.valueOf(movie).contains("666")) {
                count++;
            }
        }

        bw.write(movie + "");
        bw.flush();
        bw.close();
    }
}