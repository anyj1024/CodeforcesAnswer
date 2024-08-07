package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] threeNumber = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, Integer.MAX_VALUE};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] lr = br.readLine().split(" ");
        int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
        long first = l, second = l + 1;

        long ans = 0;
        while (first != 0) {
            first /= 3;
            second *= 3;
            ans++;
        }
        while (second != 0) {
            second /= 3;
            ans++;
        }

        int left = l + 2, right = r;
        for (int i = 0; i < threeNumber.length; i++) {
//            if (threeNumber[i] < left) continue;
//            if (i > 0 && threeNumber[i - 1] > right) break;
            if (left >= threeNumber[i] && right < threeNumber[i + 1]) {
                ans += 1l * (right - left + 1) * (i + 1);
                break;
            } else if (left >= threeNumber[i] && left < threeNumber[i + 1]) {
                ans += 1l * (threeNumber[i + 1] - left) * (i + 1);
                left = threeNumber[i + 1];
            }

//            System.out.println("ans " + ans);
        }

        System.out.println(ans);
    }
}