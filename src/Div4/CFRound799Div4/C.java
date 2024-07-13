package Div4.CFRound799Div4;

import java.io.IOException;
import java.util.Scanner;

public class C {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        int n = 8;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(new String(board[i]));
//        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i + 1][j + 1] == '#' && board[i - 1][j - 1] == '#'
                        && board[i - 1][j + 1] == '#' && board[i + 1][j - 1] == '#') {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }

    }
}