package Div3.CFRound891Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" "), input2 = br.readLine().split(" ");
        Long[][] nums = new Long[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = Long.parseLong(input1[i]) - Long.parseLong(input2[i]);
            nums[i][1] = i + 1l;
        }

        Arrays.sort(nums, (a, b) -> Long.compare(b[0], a[0]));
        long count = 0, value = nums[0][0];
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i][0] != value) break;
            count++;
            list.add(nums[i][1]);
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }
}