
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        한 단어에 대 소문자 구분 없이 가장 많이 겹친 알파벳 대문자 출력.
//        겹친 갯수가 같으면 " ? " 출력
        Scanner in = new Scanner(System.in);

        int[] arr = new int[26]; // 영문자의 개수
        String s = in.next();

        for (int i = 0; i < s.length(); i++) {

            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 대문자 일 때
                arr[s.charAt(i) - 'A']++;    // 해당 인덱스(알파벳, int[0]은 대문자A를 의미함.)의 값 1 증가
            } else {    // 소문자 범위 (대소구분 없기에 소문자a도 int[0]으로)
                arr[s.charAt(i) - 'a']++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65); // 대문자로 출력해야하므로 65를 더해준다.
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.print(ch);
    }
}