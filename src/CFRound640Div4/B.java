package CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);

            getAns(n, k);
        }
    }

    private static void getAns(int n, int k) {
        int sum1 = k - 1, sum2 = 2 * k - 2;
        if ((((n - sum1) & 1) ==  0 || n - sum1 <= 0) && ((((n - sum2) & 1) == 1) || n - sum2 <= 0)) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        if ((n - sum1 & 1) == 1) {
            for (int i = 1; i <= k - 1; i++) {
                System.out.print(1 + " ");
            }
            System.out.println(n - sum1);
        } else {
            for (int i = 1; i <= k - 1; i++) {
                System.out.print(2 + " ");
            }
            System.out.println(n - sum2);
        }
    }
}
