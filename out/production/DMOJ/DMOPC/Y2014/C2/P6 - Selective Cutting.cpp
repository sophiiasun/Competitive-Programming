#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second

using namespace std;

const int MN = 100005;
int N, Q, idx = 0, bit[MN], ans[MN];
pair<int, int> entries[MN];

struct qu {
    int i, a, b, q;
    qu () {};
    bool operator< (const qu &o) { return o.q < q; }
} queries[MN];

void upd(int idx, int v) {
    for (; idx <= MN; idx += (idx & -idx)) bit[idx] += v;
}

int sum(int idx) {
    int ret = 0;
    for (; idx; idx -= (idx & -idx)) ret += bit[idx];
    return ret;
}

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++) { scanf("%d", &entries[i-1].first); entries[i-1].second = i; }
    scanf("%d", &Q);
    for (int i = 1; i <= Q; i++) { scanf("%d %d %d", &queries[i-1].a, &queries[i-1].b, &queries[i-1].q); queries[i-1].i = i; }
    sort(entries, entries + N); sort(queries, queries + Q);
    reverse(entries, entries + N);
    for (int i = 0; i < Q; i++) {
        while (idx < N && entries[idx].first >= queries[i].q) { upd(entries[idx].second, entries[idx].first); idx++; }
        ans[queries[i].i-1] = sum(queries[i].b + 1) - sum(queries[i].a);
    }
    for (int i = 0; i < Q; i++) printf("%d\n", ans[i]);
}