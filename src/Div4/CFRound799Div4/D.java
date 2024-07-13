package Div4.CFRound799Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] s = br.readLine().split(" ");
        int minutes = Integer.parseInt(s[1]);
        String[] time = s[0].split(":");
        int hour = Integer.parseInt(time[0]), minute = Integer.parseInt(time[1]);
        int ans = 0;
        if (s[0].charAt(0) == s[0].charAt(4) && s[0].charAt(1) == s[0].charAt(3)) {
//                System.out.println(times);
            ans++;
        }
        for (int i = 1; (i * minutes) % 1440 != 0; i++) {
            String times = toStringTime(timeToMinutes(hour, minute) + i * minutes);
            if (times.charAt(0) == times.charAt(4) && times.charAt(1) == times.charAt(3)) {
//                System.out.println(times);
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int timeToMinutes(int hour, int minute){
        return hour * 60 + minute;
    }

    private static String toStringTime(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60, minute = time % 60;
        hour %= 24;
        if (hour < 10) {
            sb.append('0');
        }
        sb.append(hour).append(":");
        if (minute < 10) {
            sb.append('0');
        }
        sb.append(minute);
        return sb.toString();
    }
}