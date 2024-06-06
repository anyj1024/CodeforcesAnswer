import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
            String s1 = br.readLine();

            getAns(n, k, s1 + s1);
        }
    }

    private static void getAns(int n, int k, String s) {
        if (n == k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (s.charAt(i) - '0');
            }
            if (cnt == 0 || cnt == k) {
                System.out.println(n);
                return;
            }
        }
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb1.append("0");
            sb2.append("1");
        }
        String t1 = sb1.toString(), t2 = sb2.toString();

        int left = 0, right = 2 * n - 2 * k;
        int index = -1;
        for (int i = left; i <= right; i++) {
            String sub1 = s.substring(i, i + k);
            String sub2 = s.substring(i + k, i + 2 * k);

            if ((sub1.equals(t1) && sub2.equals(t2))
                || (sub1.equals(t2) && sub2.equals(t1))) {
                if (i == 0) {
                    index = n;
                } else {
                    index = i;
                    break;
                }
            }
        }

        System.out.println(index);
    }
}
