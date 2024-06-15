import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s = "";

        for (int i = 0; i < s1.length(); i++) {
            s += s1.charAt(i);
            s += s2.charAt(i);
        }
        while (s.length() > 2) {
            String tmp = "";
            for (int i = 0; i < s.length()-1; i++) {
                int n = Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i+1));
                tmp += Integer.toString(n % 10);
            }
            s = tmp;
        }
        System.out.println(s);

    }
}