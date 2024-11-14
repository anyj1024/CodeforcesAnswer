package Div3.CFRound981Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    static final int MOD = 1_000_000_007;
    static Map<Integer, Integer> map1 = new HashMap<>();
    static Map<Integer, List<Integer>> map2 = new HashMap<>();
    static Map<Integer, Integer> map3 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] nArr = new long[t];
        int[] kArr = new int[t];
        Set<Integer> kSet = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String[] tokens = br.readLine().split(" ");
            nArr[i] = Long.parseLong(tokens[0]);
            kArr[i] = Integer.parseInt(tokens[1]);
            kSet.add(kArr[i]);
        }

        for (int k : kSet) {
            getKKK(k);
        }

        for (int i = 0; i < t; i++) {
            long n = nArr[i];
            int k = kArr[i];
            long result = compute(n, k);
            System.out.println(result);
        }
    }

    static void getKKK(int k) {
        List<Integer> positions = new ArrayList<>();

        if (k == 1) {
            map1.put(k, 1);
            positions.add(1);
            map2.put(k, positions);
            map3.put(k, 1);
            return;
        }

        int prev = 1 % k, curr = 1 % k;
        int initPrev = prev, initCurr = curr;
        int period = 0, maxPeriod = 6 * k;

        if (prev == 0) positions.add(1);

        if (curr == 0) positions.add(2);

        for (int i = 3; i <= maxPeriod + 3; i++) {
            int temp = curr;
            curr = (prev + curr) % k;
            prev = temp;

            if (curr == 0) {
                positions.add(i);
            }

            if (prev == initPrev && curr == initCurr) {
                period = i - 2;
                break;
            }
        }

        if (period == 0) {
            period = maxPeriod;
        }

        map1.put(k, period);
        map2.put(k, positions);
        map3.put(k, positions.size());
    }

    private static long compute(long n, int k) {
        if (k == 1) {
            return n % MOD;
        }

        int period = map1.get(k);
        List<Integer> positions = map2.get(k);
        int zeroCnt = map3.get(k);

        long fullCycles = (n - 1) / zeroCnt;
        int indexInPeriod = (int) ((n - 1) % zeroCnt);
        long position = positions.get(indexInPeriod);

        long ans = (position % MOD + (fullCycles % MOD) * (period % MOD)) % MOD;
        return ans;
    }
}
