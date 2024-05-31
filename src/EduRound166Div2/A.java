package EduRound166Div2;

import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            char[] cs = br.readLine().toCharArray();

            System.out.println(getAns(cs, n));
        }
    }

    private static String getAns(char[] cs, int n) {
        boolean hasAlphaDigit = false;
        char lastChar = 0;

        for (int i = 0; i < cs.length; i++) {
            if ((Character.isDigit(cs[i]) && hasAlphaDigit) || cs[i] < lastChar) {
                return "NO";
            }
            lastChar = cs[i];
        }

        return "YES";
    }
}
