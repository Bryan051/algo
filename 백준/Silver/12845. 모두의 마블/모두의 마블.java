import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    1. 순서가 매겨진 여러장의 카드. 각각 레벨이 있다.
    2. a 카드에 b 카드를 붙일 수 있다.
    3. 두 카드는 인접한 카드여야한다.
    4. 업그레이드 된 카드 a 의 레벨은 변하지 않는다.
    5. 카드 합성을 할 때마다 두 카드 '레벨의 합만큼' 골드를 받는다.
    6. 카드가 한장 남았을 때 골드를 최대한 많이 받을 수 있게.
    -- 레벨이 높아지는 카드랑 번저 합치면 유리
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Integer[] card = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card,Collections.reverseOrder());
        int sum = 0;
        int highest = card[0];
        for (int i = 1; i < n; i++) {
            sum += highest + card[i];
            int tmp = Math.max(highest, card[i]);
            highest = tmp;
        }
        System.out.println(sum);
    }



}












