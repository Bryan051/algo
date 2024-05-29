
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

//        STRAWBERRY, BANANA, LIME, PLUM 각각 X (1~5)
//        펼쳐진 카드의 개수 N , 과일의 종류 문자열 S, 과일의 갯수 X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> fruit = new HashMap<>();

        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            int existValue = fruit.getOrDefault(split[0], 0);
            fruit.put(split[0], existValue + Integer.parseInt(split[1]));
        }

        if (fruit.containsValue(5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}