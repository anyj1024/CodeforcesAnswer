package Div1Div2.PinelyRound3Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" "), in3 = br.readLine().split(" ");
        Long[] nums1 = new Long[n], nums2 = new Long[n], key = new Long[n];
        for (int i = 0; i < n; i++) {
            long l = Long.parseLong(in1[i]), r = Long.parseLong(in2[i]), k = Long.parseLong(in3[i]);
            nums1[i] = l;
            nums2[i] = r;
            key[i] = k;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(key, Collections.reverseOrder());

        Deque<Long> stack = new ArrayDeque<>();
        Long[] lens = new Long[n];
        int l = 0, r = 0, index = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (l < n && r < n) {
                if (nums1[l] < nums2[r]) {
                    stack.push(nums1[l++]);
                } else {
                    lens[index++] = nums2[r++] - stack.pop();
                }
            } else {
                lens[index++] = nums2[r++] - stack.pop();
            }
        }

        Arrays.sort(lens);
        long ans = 0;
        for (int i = 0; i < lens.length; i++) {
            ans += lens[i] * key[i];
        }

        System.out.println(ans);
    }
}