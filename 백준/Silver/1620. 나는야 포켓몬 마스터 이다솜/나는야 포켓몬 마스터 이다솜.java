import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<>();
        Map<Integer, String> numToName = new HashMap<>();


        for (int i = 1; i < n + 1 ; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        for (int i = 0; i < m ; i++) {
            String a = br.readLine();
            // 이름으로 받아 온 경우
            if (a.charAt(0) >='A') {
                int num = nameToNum.get(a);
                sb.append(num).append("\n");
            }
            // 숫자로 받아 온 경우
            else {
                String ans = numToName.get(Integer.parseInt(a));
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }


}
