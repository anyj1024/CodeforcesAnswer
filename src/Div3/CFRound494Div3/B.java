package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] abx = br.readLine().split(" ");
        int a = Integer.parseInt(abx[0]), b = Integer.parseInt(abx[1]), x = Integer.parseInt(abx[2]);

        int[] ans1 = new int[a + b], ans2 = new int[a + b];
        int c10 = a - 1, c11 = b, c20 = a, c21 = b - 1;

//        ans1[1] = 1;
        ans1 = getArray(c10, c11, x, ans1);

        ans2[0] = 1;
        ans2 = getArray(c20, c21, x, ans2);

        if (check(ans1, x)) {
            for (int i = 0; i < a + b; i++) {
                System.out.print(ans1[i]);
            }
        } else {
            for (int i = 0; i < a + b; i++) {
                System.out.print(ans2[i]);
            }
        }
        System.out.println();
    }

    private static int[] getArray(int c0, int c1, int k, int[] ans1) {
        int n = c0 + c1 + 1;
        for (int i = 1; i < n; i++) {
            if (k >= 2) {
                ans1[i] = (ans1[i - 1] == 1 ? 0 : 1);
                if (ans1[i] == 0) c0--;
                else c1--;
                k--;
            } else {
                if (ans1[i - 1] == 0) {
                    while (c0-- != 0) {
                        ans1[i] = 0;
                        i++;
                    }
                    while (c1-- != 0) {
                        ans1[i] = 1;
                        i++;
                    }
                } else {
                    while (c1-- != 0) {
                        ans1[i] = 1;
                        i++;
                    }
                    while (c0-- != 0) {
                        ans1[i] = 0;
                        i++;
                    }
                }
                break;
            }
        }
        return ans1;
    }

    private static boolean check(int[] nums, int target) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
        }
        return count == target;
    }
}
