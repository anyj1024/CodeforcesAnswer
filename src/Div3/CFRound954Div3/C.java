package Div3.CFRound954Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
            char[] s = br.readLine().toCharArray();
            int[] ind = new int[m];
            String[] s2 = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                ind[i] = Integer.parseInt(s2[i]);
            }
            char[] c = br.readLine().toCharArray();

            TreeSet<Integer> set = new TreeSet<>();
            for (int index : ind) set.add(index);

            Arrays.sort(c);
            int i = 0;
            for (int index : set) {
                s[index - 1] = c[i++];
            }

            System.out.println(new String(s));
        }
    }
}
