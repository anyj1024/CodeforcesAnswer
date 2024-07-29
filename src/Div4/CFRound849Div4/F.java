package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    //懒更新线段树
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        int[] nums = new int[n + 1];
        int[] operations = new int[n + 1];
        String[] ns = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(ns[i - 1]);
            operations[i] = 0;
        }

        SegmentTree segmentTree = new SegmentTree(operations);

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int type = Integer.parseInt(query[0]);
            if (type == 1) {
                int left = Integer.parseInt(query[1]), right = Integer.parseInt(query[2]);
                segmentTree.update(left, right);
            } else {
                int index = Integer.parseInt(query[1]);
                int count = segmentTree.query(index);
                count = Math.min(count, 3);
                int ans = nums[index];
                while (count-- > 0) {
                    int number = ans;
                    ans = 0;
                    while (number != 0) {
                        ans += number % 10;
                        number /= 10;
                    }
                }
                System.out.println(ans);
            }
        }
    }

    public static class SegmentTree {
        private int[] tree;
        private int[] lazy;
        private int n;

        public SegmentTree(int[] nums) {
            this.n = nums.length;
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        public void update(int l, int r) {
            update(1, 1, n - 1, l, r);
        }

        private void update(int node, int start, int end, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }

            if (start > r || end < l) return;

            if (l <= start && end <= r) {
                tree[node] += (end - start + 1);
                if (start != end) {
                    lazy[node * 2] += 1;
                    lazy[node * 2 + 1] += 1;
                }
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r);
            update(node * 2 + 1, mid + 1, end, l, r);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public int query(int index) {
            return query(1, 1, n - 1, index, index);
        }

        private int query(int node, int start, int end, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (end - start + 1) * lazy[node];
                if (start != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }
                lazy[node] = 0;
            }

            if (start > r || end < l) return 0;
            if (l <= start && end <= r) return tree[node];

            int mid = (start + end) / 2;
            int p1 = query(node * 2, start, mid, l, r);
            int p2 = query(node * 2 + 1, mid + 1, end, l, r);
            return p1 + p2;
        }
    }
}