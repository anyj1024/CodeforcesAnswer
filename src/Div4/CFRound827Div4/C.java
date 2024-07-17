package Div4.CFRound827Div4;

import java.io.IOException;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] ss = new String[8];
        for (int i = 0; i < 8; i++) {
            ss[i] = sc.next();
        }
        for (int i = 0; i < 8; i++) {
            if (ss[i].equals("RRRRRRRR")) {
                System.out.println("R");
                return;
            }
        }
        System.out.println("B");
    }
}