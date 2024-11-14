
## 目录
- [A - Circuit](#a---Circuit)
- [B - Medians](#b---Medians)
- [C - Trinity](#c---Trinity)
- [D - ](#d---)
- [总结与思考](#总结与思考)

---

## A - Circuit
### 题目概述
Alice 刚刚制作了一个包含 `n` 个灯和 `2n` 个开关的电路。每个组件（灯或开关）有两种状态：开或关。灯和开关的排列方式如下：

- 每个灯连接 **恰好两个开关**。
- 每个开关连接 **恰好一个灯**。但并不知道每个开关连接到哪个灯。
- 当所有开关都处于关闭状态时，所有灯也都处于关闭状态。
- 如果一个开关被切换（从开到关，或从关到开），则它连接的灯的状态也会切换。

Alice 把电路带给她的姐姐 Iris，但只展示了这 `2n` 个开关的状态，并给了她一个谜题：在这种情况下，最多和最少可以点亮多少个灯？

Iris 非常了解妹妹的诡计，用不了一秒钟就给出了正确答案。你能做到吗？

### 解题思路
1. 核心思路就是遍历一遍数组，记录一下打开的开关数量`count`
2. 考虑最坏情况，最小亮灯个数，取决与打开开关的奇偶性
3. 考虑最好情况，是`count`和`(2 * n - count)`的最小值

### 代码实现
```java
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n * 2];
        String[] input = br.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            count += nums[i];
        }

        int max = Math.min(count, 2 * n - count);
        int min = count % 2;

        System.out.println(min + " " + max);
    }
}
```

### 复杂度分析
- **时间复杂度**：`O(n)`
- **空间复杂度**：`O(n)`


## B - Medians
### 题目概述
你有一个数组 `a = [1, 2, ..., n]`，其中 `n` 是奇数，并且有一个整数 `k`。

你的任务是选择一个奇数 `m` 并将数组 `a` 分成 `m` 个子数组 `b_1, b_2, ..., b_m`，使得：

- 数组 `a` 的每个元素都属于且仅属于一个子数组。
- 对于所有 `1 <= i <= m`， `|b_i|` 是奇数，即每个子数组的长度都是奇数。
- `median([median(b_1), median(b_2), ..., median(b_m)]) = k`，也就是说，所有子数组的中位数的中位数必须等于 `k`。其中，`median(c)` 表示数组 `c` 的中位数。

一个长度为 `n` 的数组的子数组 `a[l, r]` 表示为 `[a_l, a_{l+1}, ..., a_r]`，其中 `1 <= l <= r <= n`。

长度为奇数的数组的中位数是将数组按非降序排序后中间的元素。例如：`median([1, 2, 5, 4, 3]) = 3`，`median([3, 2, 1]) = 2`，`median([2, 1, 2, 2, 2]) = 2`。
### 解题思路
1. 重点是`n`和`m`都是奇数，这就避免了很多讨论，最直观的思路就是以k为分界线，左右两边均分为相同数量的组
2. 首先对与`n = 1`和`n = 2`的情况，我们可以特判，之后记录一下k左边的数字个数`lefCount`和右边的`rightCount`
3. 当两者任意一个为`0`时，显然不合条件，直接返回`-1`，到此反例和特例就判断结束了
4. 对于一般情况，由于`n`是奇数，去掉一个`k`后是偶数，那么`leftCount`和`rightCount`一定是同奇偶性的
5. 如果是奇数的话，可以将两边都分为`min(leftCount, rightCount)`组
6. 如果是偶数的话，一定可以分为两组，即`1 + odd`的形式

### 代码实现
```java
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);

        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(-1);
            return;
        }
        int leftCount = k - 1, rightCount = n - k;
        if ((leftCount == 0 && (rightCount & 1) == 0) || rightCount == 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = Math.min(leftCount, rightCount);
        if ((leftCount & 1) == 1) {
            System.out.println(count * 2 + 1);
            for (int i = 1; i <= count; i++) {
                sb.append(i).append(" ");
            }
            sb.append(k).append(" ");
            for (int i = 1; i <= count; i++) {
                sb.append(i + k).append(" ");
            }
        } else {
            count = 2;
            System.out.println(5);
            for (int i = 1; i <= count; i++) {
                sb.append(i).append(" ");
            }
            sb.append(k).append(" ");
            for (int i = 1; i <= count; i++) {
                sb.append(i + k).append(" ");
            }
        }
        System.out.println(sb);
    }
}
```

### 复杂度分析
- **时间复杂度**：`O(n)`
- **空间复杂度**：`O(n)`


## C - Trinity
### 题目概述
给定一个包含 `n` 个元素的数组 `a = [a_1, a_2, ..., a_n]`。

你可以进行任意次数（可以为 0）以下操作：

- 选择两个索引 `i` 和 `j`，其中 `1 <= i, j <= n`，然后将 `a_i` 赋值为 `a_j`。

要求找到使数组 `a` 满足以下条件的最小操作次数：

- 对于任意三个不同的索引 `(x, y, z)`（`1 <= x, y, z <= n, x ≠ y, y ≠ z, x ≠ z`），满足不等式 `a_x + a_y > a_z`、`a_y + a_z > a_x`、`a_z + a_x > a_y`。

换句话说，任意三个元素的组合都能组成一个非退化三角形。


### 解题思路
1. 先排序，问题转化为`a1 + a2 > an`，操作的上限是`n - 2`，因为我们可以将`a1`和`an`之间所有的元素都变为`an`
2. 考虑到与一般情况，则我们需要在数组中找到一对满足 `ai + ai+1 > aj` 条件的元素索引 `(i, j)`，其中 `i` 在前，`j` 在后。这对 `i, j` 确保了最小和次小的元素之和大于数组的最大值。

### 代码实现
```java
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(nums);
        int left = 0, ans = n - 2;
        for (int i = 2; i < n; i++) {
            while (i - left >= 2 && nums[left] + nums[left + 1] <= nums[i]) {
                left++;
            }
            ans = Math.min(ans, n - (i - left + 1));
        }
        System.out.println(ans);
    }
}
```

### 复杂度分析
- **时间复杂度**：`O(nlogn)`
- **空间复杂度**：`O(n)`


## D - 
### 题目概述

### 解题思路

### 代码实现
```java
```

### 复杂度分析
- **时间复杂度**：
- **空间复杂度**：


## 总结与思考
脑子卡了浆糊，c居然没写出来，掉打分~~~
