#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second

using namespace std;

const int MN = 2005;
int N, bit[MN][MN], ans = 0, mod = (int)1e9+7;

void upd(int r, int c, int t) {
    for (int i = r; i <= r + c; i += (i & -i)) bit[r+c-1][i] += t;
}

int sum (int i, int r, int c) {
    int ret = 0;
    for (; i; i -= (i & -i)) { ret = (ret + bit[r+c-1][i]) % mod; }
    return ret;
}

int main() {
    scanf("%d", &N);
    for (int i = 0, op, r, c, t; i < N; i++) {
        scanf("%d %d %d %d", &op, &r, &c, &t);
        if (op == 1) upd(r, c, t);
        else ans = (ans + sum(r, r, c) - sum(r-t-1, r, c) + mod) % mod;
    }
    printf("%d", ans);
    return 0;
}