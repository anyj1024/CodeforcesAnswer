package Div4.CFRound898Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]), a = Integer.parseInt(nab[1]), b = Integer.parseInt(nab[2]);
        int[] degrees = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]), v = Integer.parseInt(uv[1]);
            degrees[u]++;
            degrees[v]++;
            graph[u].add(v);
            graph[v].add(u);
        }

        if (a == b) {
            System.out.println("NO");
            return;
        }

        boolean[] visited = new boolean[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 1) {
                queue.offerFirst(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                degrees[next]--;
                if (degrees[next] <= 1 && !visited[next]) {
                    queue.offerFirst(next);
                    visited[next] = true;
                }
            }
        }

        Set<Integer> set  = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                set.add(i);
            }
        }

//        System.out.println(set.toString());

        if (set.contains(b)) {
            System.out.println("YES");
            return;
        }
        queue = new ArrayDeque<>();
        queue.offerFirst(b);
        visited = new boolean[n + 1];
        visited[b] = true;

        Set<Integer> nodes = new HashSet<>();
        int step = 0;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = queue.pollLast();
                for (int next : graph[cur]) {
                    if (visited[next]) continue;
                    if (set.contains(next)) {
                        found = true;
                        nodes.add(next);
                    }
                    visited[next] = true;
                    queue.offerFirst(next);
                }
            }
        }

        found = false;
        queue = new ArrayDeque<>();
        visited = new boolean[n + 1];
        visited[a] = true;
        queue.offerFirst(a);
        int seekDistance = 0;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            seekDistance++;
            for (int i = 0; i < size; i++) {
                int cur = queue.pollLast();
                for (int next : graph[cur]) {
                    if (visited[next]) continue;
                    if (nodes.contains(next)) {
                        found = true;
                        nodes.add(next);
                    }
                    visited[next] = true;
                    queue.offerFirst(next);
                }
            }
        }
        if (nodes.contains(a)) seekDistance = 0;
//        System.out.println(step + "  " + seekDistance);
        if (seekDistance > step) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}