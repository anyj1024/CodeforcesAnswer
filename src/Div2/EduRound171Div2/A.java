package Div2.EduRound171Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
        System.out.print(sb.toString());
    }

    public static void solve() throws IOException {
        String[] xyz = br.readLine().split(" ");
        int X = Integer.parseInt(xyz[0]);
        int Y = Integer.parseInt(xyz[1]);
        int K = Integer.parseInt(xyz[2]);

        if (X >= K && Y >= K) {
            sb.append("0 0 ").append(K).append(" 0\n");
            sb.append("0 0 0 ").append(K).append("\n");
        } else {
            int ceilKsqrt2 = (int) Math.ceil((double) K / Math.sqrt(2));

            if (ceilKsqrt2 <= X && ceilKsqrt2 <= Y) {
                sb.append("0 0 ").append(ceilKsqrt2).append(" ").append(ceilKsqrt2).append("\n");
                sb.append("0 ").append(ceilKsqrt2).append(" ").append(ceilKsqrt2).append(" 0\n");
            } else {
                if (X >= K) {
                    int y_cd = (int) Math.ceil((double) K / Math.sqrt(2));
                    y_cd = Math.min(y_cd, Y);
                    sb.append("0 0 ").append(K).append(" 0\n");
                    sb.append("0 ").append(y_cd).append(" ").append(y_cd).append(" 0\n");
                } else if (Y >= K) {
                    int x_cd = (int) Math.ceil((double) K / Math.sqrt(2));
                    x_cd = Math.min(x_cd, X);
                    sb.append("0 0 0 ").append(K).append("\n");
                    sb.append(x_cd).append(" 0 0 ").append(x_cd).append("\n");
                } else {
                    int x_cd = Math.min(X, (int) Math.ceil((double) K / Math.sqrt(2)));
                    int y_cd = Math.min(Y, (int) Math.ceil((double) K / Math.sqrt(2)));
                    sb.append("0 0 ").append(x_cd).append(" ").append(y_cd).append("\n");
                    sb.append(x_cd).append(" 0 0 ").append(y_cd).append("\n");
                }
            }
        }
    }
}
