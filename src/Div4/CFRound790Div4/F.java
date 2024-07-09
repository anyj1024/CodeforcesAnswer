package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
            int[] nums = new int[n];
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }

            getAns(nums, k);
        }

    }

    private static void getAns(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                set.add(entry.getKey());
            }
        }
        for (int key : set) {
            map.remove(key);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }
        int left = list.get(0), right = list.get(0), maxLen = 1;
        int l = left, r = right, len = 1;
//        for (int num : list) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                len++;
                r = list.get(i);
            } else {
                len = 1;
                l = list.get(i);
                r = l;
            }
            if (len > maxLen) {
                maxLen = len;
                left = l;
                right = r;
            }
        }
        System.out.println(left + " " + right);
    }
}