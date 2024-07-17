package Div4.CFRound827Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(s[i]));
        }
        Collections.sort(nums, Collections.reverseOrder());
        visited[0] = true;

        int prev = nums.get(0);
        List<Integer> ans = new ArrayList<>();
        ans.add(prev);

        while (true) {
            int  position = -1, last = prev;
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if ((prev | nums.get(i)) > last) {
                    last = prev | nums.get(i);
                    position = i;
                }
            }

            if (position == -1) break;
            ans.add(nums.get(position));
            visited[position] = true;
            prev |= nums.get(position);
        }

        for (int num : ans) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            System.out.print(nums.get(i) + " ");
        }

        System.out.println();
    }

}