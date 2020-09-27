#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MN 100005
#define MM 1000005
#define inf 200000000
#define pb push_back
#define mp make_pair
#define ll long long int
#define ld long double
#define pii pair<int, int>
#define pll pair<ll, ll>
#define pld pair<ld, ld>
#define f first
#define s second
#define b back()

using namespace std;
char _;

// aliens

int N, M, K, dq[MN], pf, pb;
pll dp[MN];
vector<pii> poi; // points of interest

bool comp (pii x, pii y) { return (x.f < y.f || (x.f == y.f && x.s > y.s)); }
ll sq (ll i) { return i * i; }
ld func (int i) { return dp[i].f + sq(poi[i+1].f - 1) - sq(max(0, poi[i].s - poi[i+1].f + 1)); }
ld calc (int i, int j) { return (ld)(func(j) - func(i)) / (ld)(poi[j+1].f - poi[i+1].f); }
ll cost (int i, int j) { return max(0LL, sq(poi[j].s - poi[i].f + 1) - (i ? sq(max(0, poi[i-1].s - poi[i].f + 1)) : 0)); }

pll cht (ll m) {
    pf = pb = 0; dq[0] = 0;
    for (int i = 0; i < N; i++) {
        while (pf < pb && calc(dq[pf], dq[pf+1]) <= 2 * poi[i].s) pf++;
        dp[i] = min(mp(cost(0, i) + m, 1LL), mp(dp[dq[pf]].f + cost(dq[pf] + 1, i) + m, dp[dq[pf]].s + 1));
        while (pf < pb && calc(dq[pb-1], dq[pb]) >= calc(dq[pb], i)) pb--;
        dq[++pb] = i;
    }
    return dp[N-1];
}

ll solve () { // wqs binary search
    ll s = 0, e = 1e12, m; pll ans;
    while (s <= e) {
        m = (s + e) / 2;
        ans = cht(m);
        if (ans.s > K) s = m + 1;
        else e = m - 1;
    }
    return cht(s).f - K * s;
}

long long take_photos(int n, int m, int k, int* r, int* c) {
    M = m; K = k; vector<pii> tmp;
    for (int i = 0; i < N; i++) // keep points above diag
        tmp.pb(mp(max(r[i], c[i]), min(r[i], c[i])));
    sort(tmp.begin(), tmp.end(), comp);
    for (auto &i : tmp) { // discard redundant
        if (poi.empty() || i.f < poi.b.f || i.s > poi.b.s) poi.pb(i);
    }
    N = poi.size();
    return solve();
}

int main() {
    scan(N); scan(M); scan(K); vector<pii> tmp;
    for (int i = 0, r, c; i < N; i++) {
        scan(r); scan(c);
        if (r > c) tmp.pb(mp(c, r)); // keep all points on one side of diag axis
        else tmp.pb(mp(r, c));
    }
    sort(tmp.begin(), tmp.end(), comp);
    for (auto &i : tmp) { // discard redundant points
        if (poi.empty() || i.f < poi.b.f || i.s > poi.b.s) poi.pb(i);
    }
    N = poi.size();
    cout << solve() << "\n";
    return 0;
}
