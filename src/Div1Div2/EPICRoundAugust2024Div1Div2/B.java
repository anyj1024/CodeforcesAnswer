package Div1Div2.EPICRoundAugust2024Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums1 = new int[n], nums2 = new int[n];
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(in1[i]);
            nums2[i] = Integer.parseInt(in2[i]);
        }

        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                count1++;
            }
            if (nums1[i] == nums2[n - i - 1]) {
                count2++;
            }
        }

        if (count1 == n || count2 == n) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }

}