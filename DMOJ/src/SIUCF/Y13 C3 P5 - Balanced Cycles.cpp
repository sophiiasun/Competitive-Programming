#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MN 100005
#define mp make_pair
#define pb push_back
#define ll long long
#define f first
#define s second

// balanced cycles

using namespace std;
char _;

int N, dis[MN]; ll ans = 0LL;
set<pair<int, int>> adj[MN];
vector<int> vec;
map<int, int> cnt;

int dfs (int cur, int pre) {
    dis[cur] = 1;
    for (auto &i : adj[cur]) {
        if (i.f != pre) dis[cur] += dfs(i.f, cur);
    }
    return dis[cur];
}

int centroid (int cur, int pre, int n) {
    for (auto &i : adj[cur]) {
        if (i.f != pre && dis[i.f] > n/2) return centroid(i.f, cur, n);
    }
    return cur;
}

void dfs2 (int cur, int pre, int sum) {
    vec.pb(sum);
    ans += cnt[1-sum] + cnt[-1-sum];
    for (auto &i : adj[cur]) {
        if (i.f != pre) dfs2(i.f, cur, sum+i.s);
    }
}

void solve(int cur, int pre) {
    int d = dfs(cur, -1), ctrd = centroid(cur, -1, d);
    cnt.clear(); cnt[0] = 1;
    for (auto i : adj[ctrd]) {
        vec.clear();
        dfs2 (i.f, ctrd, i.s);
        for (auto j : vec) cnt[j]++;
    }

    vector<pair<int, int>> hold(adj[ctrd].begin(), adj[ctrd].end());
    for (auto i : hold) {
        adj[ctrd].erase(i); adj[i.f].erase(mp(ctrd, i.s));
        solve(i.f, cur);
    }
}

int main () {
    scan(N);
    for (int i = 1, a, b; i < N; i++) {
        scan(a); scan(b); char c; cin>>c; int d = (c == 'r' ? 1 : -1);
        adj[a].insert(mp(b, d)); adj[b].insert(mp(a, d));
    }
    solve(1, -1);
    cout<<(ans-N+1)<<"\n";
    return 0;
}