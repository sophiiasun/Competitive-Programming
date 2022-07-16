#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

const int MN = 500005;
int N, bitf[MN], bitb[MN]; ll ans = 0LL;

void upd (int bit[], int idx, int val) {
    for (; idx <= MN; idx += (idx & -idx)) bit[idx] += val;
}

ll sum (int bit[], int idx) {
    ll ret = 0;
    for (; idx; idx -= (idx & -idx)) ret += bit[idx];
    return ret;
}

int main() {
    scanf("%d", &N);
    for (int i = 0, x; i < N; i++) {
        scanf("%d", &x);
        ans += min(sum(bitf, x), sum(bitb, N - x + 1));
        upd(bitf, x, 1); upd(bitb, N - x + 1, 1);
    }
    printf("%lld", ans);

    return 0;
}