package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String time = br.readLine();

        int hour24 = Integer.parseInt(time.substring(0, 2)), minutes = Integer.parseInt(time.substring(3, 5));
        int hour12 = hour24 % 12;
        if (hour12 == 0) {
            hour12 = 12;
        }

        String type = hour24 >= 12 ? "PM" : "AM";
        System.out.println(String.format("%02d:%02d %s", hour12, minutes, type));
    }
}
