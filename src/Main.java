import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        long a = Long.parseLong(abc[0]), b = Long.parseLong(abc[1]), c = Long.parseLong(abc[2]);


    }
}