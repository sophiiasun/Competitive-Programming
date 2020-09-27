#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
char _;

const int MN = 200005;
int N, Q, pos = 0; long long int ans[MN], psa[MN], bit[MN];
pair<int, int> entries[MN];

struct S {
    int i, l, r, k;
    S() {};
    bool operator<(const S &s) { return k < s.k; }
} queries[MN];

void upd (int idx, int v) {
    for (; idx <= MN; idx += (idx & -idx)) bit[idx] += v;
}

long long int sum (int idx) {
    long long int ret = 0;
    for (; idx; idx -= (idx & -idx)) ret += bit[idx];
    return ret;
}

int main() {
    scan(N); scan(Q); memset(bit, 0LL, sizeof(bit));
    for (int i = 0, x; i < N; i++) {
        scan(x); entries[i] = {x, i + 1};
        psa[i + 1] = psa[i] + x;
    }
    for (int i = 0; i < Q; i++) {
        queries[i].i = i; scanf("%d %d %d", &queries[i].l, &queries[i].r, &queries[i].k);
    }
    sort(entries, entries + N); sort(queries, queries + Q);
    for (int i = 0; i < Q; i++) {
        while (pos < N && entries[pos].first < queries[i].k) {
            upd(entries[pos].second, entries[pos].first);
            pos++;
        }
        ans[queries[i].i] = psa[queries[i].r] - psa[queries[i].l-1] - 2 * (sum(queries[i].r) - sum(queries[i].l-1));
    }
    for (int i = 0; i < Q; i++) {
        printf("%lld\n", ans[i]);
    }

    return 0;
}