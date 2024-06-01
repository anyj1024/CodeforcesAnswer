package CFRound949Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);

            System.out.println(getAns(l, r));
        }
    }

    private static int getAns(int l, int r) {
        for (int i = 0; i < 31; i++) {
            if ((1 << i) > r) {
                return i - 1;
            }
        }
        return -1;
    }
}
