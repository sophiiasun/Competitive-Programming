#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MAXN 200005
#define MAXK 1000005
#define mp make_pair
#define pb push_back
#define ll long long
#define f first
#define s second

using namespace std;
char _;

vector<pair<int, int>> adj[MAXN], branch;
int NN, KK, dis[MAXN], inf = (int)2e9, val[MAXK], edge[MAXK], mrk;

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

int dfs2(int cur, int pre, int dis, int cnt, int tmp, vector<pair<int, int>> &vec) {
    if (dis > KK) return inf;
    int ans = inf;
    if (KK - dis >= 0 && val[KK - dis] == tmp) ans = min(ans, cnt + edge[KK - dis]);
    vec.pb(mp(dis, cur));
    for (auto i : adj[cur]) {
        if (i.f != pre) ans = min(ans, dfs2(i.f, cur, i.s + dis, cnt+1, tmp, vec));
    }
    return ans;
}

int solve (int cur, int pre) { // centroid decomposition
    int n = dfs(cur, -1), ctrd = centroid(cur, -1, n), ans = inf, tmp = val[0] = ++mrk; edge[0] = 0;
    for (auto &i : adj[ctrd]) {
        vector<pair<int, int>> vec;
        ans = min(ans, dfs2(i.f, ctrd, i.s, 1, tmp, vec));
        for (auto j : branch) {
            if (val[j.f] != tmp || edge[j.f] > j.s) { val[j.f] = tmp; edge[j.f] = j.s; }
        }
    }
//    vector<pair<int, int>> hold(adj[cur].begin(), adj[cur].end());
    for (auto i : adj[ctrd]) {
        adj[ctrd].erase(adj[ctrd].begin() + i); adj[i.f].erase(mp(ctrd, i.s));
        ans = min(ans, solve(i.f, ctrd));
    }
    return ans;
}

int best_path(int N, int K, int H[][2], int L[]) {
    NN = N; KK = K;
    for (int i = 0, a, b; i < N-1; i++) { adj[H[i][0]].pb(mp(H[i][1], L[i])); adj[H[i][1]].pb(mp(H[i][0], L[i])); } // build adj
    int ans = solve(0, K);
    return (ans == inf ? -1 : ans);
}

int main () {
    return 0;
}