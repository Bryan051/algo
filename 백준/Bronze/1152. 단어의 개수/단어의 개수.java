import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 단어의 개수
        // 공백 미포함 단어 세기
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        s = s.trim();
        String[] s_arr = s.split(" ");
        
        if(s_arr[0].equals("")) System.out.println(0);
        
        else System.out.println(s_arr.length);

    }

}