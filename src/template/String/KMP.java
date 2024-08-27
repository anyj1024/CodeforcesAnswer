package template.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNextArray("ABACAABAD")));
        System.out.println(KMP("ADSABACAABADASDSDABACAABADSDABACAABABACAABADAD", "ABACAABAD"));
        System.out.println(KMP("AAAAAA", "AAA"));
    }

    public static List<Integer> KMP(String str, String dest) {
        List<Integer> kmpRes = new ArrayList<>();
        int[] next = getNextArray(dest);
        for (int i = 0, j = 0; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if (j == dest.length()) {
                kmpRes.add(i - j + 1);
                i -= dest.length() - 1;
                j = 0;
            }
        }
        return kmpRes;
    }

    public static int[] getNextArray(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
