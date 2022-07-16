#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

int N, M; ll bit[100005], a[100005], cnt[100005];

void upd (ll *b, int idx, int val) {
    while (idx <= 100000) {
        b[idx] += val;
        idx += (idx & -idx);
    }
}

ll sum (ll *b, int idx) {
    long long int sum = 0;
    while (idx) {
        sum += b[idx];
        idx -= (idx & -idx);
    }
    return sum;
}

void init () {
    memset(bit, 0, sizeof(bit));
    for (int i = 1; i <= N; i++) { upd(bit, i, a[i]); upd(cnt, a[i], 1); }
}

int main () {
    scanf("%d %d", &N, &M);
    for (int i = 1; i <= N; i++) { scanf("%d", &a[i]);  }
    init();
    for (int i = 0, x, y; i < M; i++) {
        char c; cin >> c;
        if (c == 'C') { scanf("%d %d", &x, &y); upd(bit, x, y - a[x]); upd(cnt, a[x], -1); upd(cnt, a[x] = y, 1); }
        else if (c == 'S') { scanf("%d %d", &x, &y); printf("%lld\n", (sum(bit, y) - sum(bit, x-1))); }
        else { scanf("%d", &x); printf("%lld\n", sum(cnt, x)); }
    }
}