import sys

def main():
    t = 1
    while t > 0:
        solve()
        t -= 1

def solve():
    n = int(sys.stdin.readline())
    s = sys.stdin.readline()
    ans = 0
    sum_digits = 0

    for i in range(n):
        cur = int(s[i])
        sum_digits = sum_digits * 10 + cur * (i + 1)
        ans += sum_digits

    print(ans)

if __name__ == "__main__":
    main()
