#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MN 100005
#define mp make_pair
#define ll long long int
#define ld long double
#define pii pair<int, int>
#define pll pair<ll, ll>
#define f first
#define s second
#define b back()

using namespace std;
char _;

// aliens

int N, M, K, dq[MN], pf, pb;
vector<pii> poi; // points of interest
pll dp[MN];
bool comp (pii x, pii y) { return (x.f < y.f || (x.f == y.f && x.s > y.s)); }
ll sq (ll i) { return i * i; }
ll func (int i) { return dp[i].f + sq(poi[i+1].f - 1) - sq(max(0, poi[i].s - poi[i+1].f + 1)); }
ld calc (int i, int j) { return (ld)(func(j) - func(i)) / (ld)(poi[j+1].f - poi[i+1].f); }
ll cost (int i, int j) { return max(0LL, sq(poi[j].s - poi[i].f + 1) - (i>0)*(sq(max(0, poi[i-1].s - poi[i].f + 1)))); }

pll cht (ll m) {
    pf = 0; pb = 0;
    for (int i = 0; i < N; i++) {
        dp[i] = mp(cost(0, i) + m, 1LL);
        while (pf < pb - 1 && calc(dq[pf], dq[pf+1]) < 2 * poi[i].s) pf++;
        ll tmp = dp[dq[pf]].f + cost(dq[pf] + 1, i) + m;
        if (pf < pb && tmp < dp[i].f) dp[i] = mp(tmp, dp[dq[pf]].s + 1);
        while (pf < pb - 1 && calc(dq[pb-2], dq[pb-1]) > calc(dq[pb-1], i)) pb--;
        dq[pb++] = i;
    }
    return dp[N-1];
}

ll solve () { // wqs binary search
    ll l = 0, r = 1e13, m;
    while (l <= r) {
        m = (l + r) >> 1;
        if (cht(m).s > K) l = m + 1;
        else r = m - 1;
    }
    return cht(l).f - K * l;
}

long long take_photos(int n, int m, int k, int* r, int* c) {
    M = m; K = k; vector<pii> tmp;
    for (int i = 0; i < n; i++) { // keep points above diag
        if (r[i] > c[i]) tmp.push_back(mp(c[i], r[i])); // keep all points on one side of diag axis
        else tmp.push_back(mp(r[i], c[i]));
    }
    sort(tmp.begin(), tmp.end(), comp);
    for (auto &i : tmp) { // discard redundant
        if (poi.empty() || i.f < poi.b.f || i.s > poi.b.s) poi.push_back(i);
    }
    N = poi.size();
    return solve();
}

int main() {
    scan(N); scan(M); scan(K); vector<pii> tmp;
    for (int i = 0, r, c; i < N; i++) {
        scan(r); scan(c);
        if (r > c) tmp.push_back(mp(c, r)); // keep all points on one side of diag axis
        else tmp.push_back(mp(r, c));
    }
    sort(tmp.begin(), tmp.end(), comp);
    for (auto &i : tmp) { // discard redundant points
        if (poi.empty() || i.f < poi.b.f || i.s > poi.b.s) poi.push_back(i);
    }
    N = poi.size();
    cout<<solve()<<"\n";
    return 0;
}