package Else.ICPC2324JakartaMirror;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        String s1 = "CCC";
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                char ch1 = grid[i1][j1];
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        if (i1 == i2 && j1 == j2) continue;
                        if (Math.abs(i1 - i2) > 1 || Math.abs(j1 - j2) > 1) continue;
                        char ch2 = grid[i2][j2];
                        for (int i3 = 0; i3 < 3; i3++) {
                            for (int j3 = 0; j3 < 3; j3++) {
                                if (i1 == i3 && j1 == j3) continue;
                                if (i2 == i3 && j2 == j3) continue;
                                if (Math.abs(i3 - i2) > 1 || Math.abs(j2 - j3) > 1) continue;
                                char ch3 = grid[i3][j3];
                                if (s1.charAt(0) > ch1 || (s1.charAt(0) == ch1 && ch2 < s1.charAt(1)) || (s1.charAt(0) == ch1 && s1.charAt(1) == ch2 && ch3 < s1.charAt(2))) {
                                    s1 = new String() + ch1 + ch2 + ch3;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(s1);
    }
}