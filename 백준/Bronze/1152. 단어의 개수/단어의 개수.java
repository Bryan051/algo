
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        // 단어의 개수
        // 공백 미포함 단어 세기
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(s, " ");

        System.out.println(st.countTokens());



    }

}