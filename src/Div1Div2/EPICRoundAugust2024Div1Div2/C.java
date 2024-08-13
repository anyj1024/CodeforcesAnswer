package Div1Div2.EPICRoundAugust2024Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] circle = new long[n][2];
        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            long x = Long.parseLong(xy[0]), y = Long.parseLong(xy[1]);
            circle[i][0] = x;
            circle[i][1] = y;
        }
        String[] xyxy = br.readLine().split(" ");
        long xS = Long.parseLong(xyxy[0]), yS = Long.parseLong(xyxy[1]);
        long xT = Long.parseLong(xyxy[2]), yT = Long.parseLong(xyxy[3]);

        long distance = (xT - xS) * (xT - xS) + (yT - yS) * (yT - yS);
        for (int i = 0; i < circle.length; i++) {
            long dis = (circle[i][0] - xT) * (circle[i][0] - xT) + (circle[i][1] - yT) * (circle[i][1] - yT);
            if (dis <= distance) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}