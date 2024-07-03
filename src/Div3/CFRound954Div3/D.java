package Div3.CFRound954Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            char[] cs = br.readLine().toCharArray();

            getAns(cs);
        }
    }

    private static void getAns(char[] cs) {
        if (cs.length <= 2) {
            System.out.println(Integer.parseInt(new String(cs)));
            return;
        } else if (cs.length != 3 || cs[1] != '0'){
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '0') {
                    System.out.println(0);
                    return;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length - 1; i++) {
            int cur = (int) ((cs[i] - '0') * 10 + (cs[i + 1] - '0'));
//            System.out.println("      cur  " + cur);
            list.add(cur);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i), sum = 0;
            for (int j = 0; j < cs.length; j++) {
                if (j == i || j == i + 1) continue;
                int k = cs[j] - '0';
                if (k != 1) {
                    sum += k;
                }
            }
            sum = sum == 0 ? 1 : sum;
            ans = Math.min(ans, Math.min(sum * val, sum + val));
        }

        System.out.println(ans);
    }

}