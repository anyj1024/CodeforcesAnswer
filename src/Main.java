import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[3][n];

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<Integer>[] graph = new ArrayList[2 * n + 1];
        for (int i = 0; i <= 2 * n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int x = board[0][i];
            int y = board[1][i];
            int z = board[2][i];

            graph[getId(-x, n)].add(getId(y, n));
            graph[getId(-x, n)].add(getId(z, n));
            graph[getId(-y, n)].add(getId(x, n));
            graph[getId(-y, n)].add(getId(z, n));
            graph[getId(-z, n)].add(getId(x, n));
            graph[getId(-z, n)].add(getId(y, n));
        }

        TarjanSCC tarjanSCC = new TarjanSCC(graph, 2 * n);

        boolean isSatisfiable = true;
        for (int i = 1; i <= n; i++) {
            if (tarjanSCC.belong[getId(i, n)] == tarjanSCC.belong[getId(-i, n)]) {
                isSatisfiable = false;
                break;
            }
        }

        System.out.println(isSatisfiable ? "YES" : "NO");
    }

    private static int getId(int x, int n) {
        return (x < 0) ? -x + n : x;
    }
}

class TarjanSCC {
    private final List<Integer>[] graph;
    private final int[] dfn;
    private final int[] low;
    private final boolean[] inStack;
    private final Stack<Integer> stack;
    public final int[] belong;
    private int index;
    private int sccCount;

    public TarjanSCC(List<Integer>[] graph, int size) {
        this.graph = graph;
        this.dfn = new int[size + 1];
        this.low = new int[size + 1];
        this.inStack = new boolean[size + 1];
        this.stack = new Stack<>();
        this.belong = new int[size + 1];
        this.index = 0;
        this.sccCount = 0;

        for (int i = 1; i <= size; i++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }
    }

    private void tarjan(int u) {
        dfn[u] = low[u] = ++index;
        stack.push(u);
        inStack[u] = true;

        for (int v : graph[u]) {
            if (dfn[v] == 0) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }

        if (low[u] == dfn[u]) {
            int node;
            sccCount++;
            do {
                node = stack.pop();
                inStack[node] = false;
                belong[node] = sccCount;
            } while (node != u);
        }
    }
}
