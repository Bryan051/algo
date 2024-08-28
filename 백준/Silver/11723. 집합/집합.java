
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < m ; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            if (split[0].equals("add")) {

                int a = Integer.parseInt(split[1]);
                if (set.contains(a)) continue;
                set.add(a);

            } else if (split[0].equals("remove")) {

                int a = Integer.parseInt(split[1]);
                if (!set.contains(a)) continue;
                set.remove(a);

            } else if (split[0].equals("check")) {

                int a = Integer.parseInt(split[1]);
                if (set.contains(a)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }

            } else if (split[0].equals("toggle")) {

                int a = Integer.parseInt(split[1]);
                if (set.contains(a)) {
                    set.remove(a);
                } else {
                    set.add(a);
                }

            } else if (split[0].equals("all")) {

                for (int j = 1; j < 21; j++) {
                    set.add(j);
                }

            } else  {
                set.clear();
            }
        }

        System.out.println(sb);

    }


}

