package Div4.CFRound784Div4;

import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 1399) {
                System.out.println("Division 4");
            } else if (n <= 1599 && n >= 1400) {
                System.out.println("Division 3");
            } else if (n <= 1899 && n >= 1600) {
                System.out.println("Division 2");
            } else {
                System.out.println("Division 1");
            }
        }
    }
}