import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            set.add(a);
        }

        ArrayList<String> list = new ArrayList<>(set);

        MyComparator myComparator = new MyComparator();

        Collections.sort(list, myComparator);

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                //길이 다를때
                return Integer.compare(o1.length(),o2.length());
            }
            //길이 같을때
            return o1.compareTo(o2);
        }

    }

}
