package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            char[][] cs = new char[n][m];
            for (int i = 0; i < n; i++) {
                cs[i] = br.readLine().toCharArray();
            }

            getAns(cs);
        }
    }

    private static void getAns(char[][] cs) {
        int n = cs.length, m = cs[0].length;
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (cs[i][j] == '*') {
                    int index = i;
                    while (index < n - 1 && cs[index + 1][j] == '.' && cs[index][j] == '*') {
                        cs[index + 1][j] = '*';
                        cs[index][j] = '.';
                        index++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cs[i][j]);
            }
            System.out.println();
        }
    }
}
