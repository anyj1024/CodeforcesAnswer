package Div2.CFRound968Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(maximizeGoodPairs(s));
    }

    public static String maximizeGoodPairs(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        List<Character> sortedChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                sortedChars.add((char) (i + 'a'));
            }
        }
        sortedChars.sort((a, b) -> charCount[b - 'a'] - charCount[a - 'a']);

        StringBuilder result = new StringBuilder();

        char mostFrequent = sortedChars.get(0);
        for (int i = 0; i < charCount[mostFrequent - 'a']; i++) {
            result.append(mostFrequent);
        }

        int index = 0;
        for (int i = 1; i < sortedChars.size(); i++) {
            char c = sortedChars.get(i);
            for (int j = 0; j < charCount[c - 'a']; j++) {
                result.insert(index, c);
                index += 2;
                if (index >= result.length()) {
                    index = 1;
                }
            }
        }

        return result.toString();
    }
}