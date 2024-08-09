package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        int[] nums = new int[n];
        Integer[] sortedNums = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            sortedNums[i] = nums[i];
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for (int i = 0; i < k; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]), y = Integer.parseInt(xy[1]);
            if (nums[x - 1] > nums[y - 1]) {
                map.get(x).add(y);
            } else if (nums[x - 1] < nums[y - 1]) {
                map.get(y).add(x);
            }
        }
//        System.out.println(map);
        Arrays.sort(sortedNums);
        for (int i = 1; i <= n; i++) {
            int rate = nums[i - 1];
            int left = 0, right = n - 1;
            int ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sortedNums[mid] < rate) {
                    left = mid + 1;
                    ans = left;
                } else {
                    right = mid - 1;
                }
            }

//            System.out.println(ans);
            System.out.print((ans - map.get(i).size()) + " ");
        }
        System.out.println();
    }
}