import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n / 3 % 2 == 1) {
            if (n % 3 == 1) {
                System.out.println("CY");
            }else
            System.out.println("SK");
        } else if (n / 3 % 2 == 0 ) {
            if (n % 3 == 1) {
                System.out.println("SK");
            }else
            System.out.println("CY");
        }
    }


}