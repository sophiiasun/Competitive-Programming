#include <bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back
#define mp make_pair
#define ins insert

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<vector<int>> vii;
typedef map<int, int> mii;
char _;

const int MN = 5e4+3;
int N, dia=0, len[MN]; ll cnt[MN], ans=0;
vi adj[MN];

void dfs(int u, int p) {
    len[u] = 0; cnt[u] = 1;
    for (int v : adj[u]) {
        if (v == p) continue;
        dfs(v, u);
        if (len[v] + len[u] + 1 > dia) {
            dia = len[v] + len[u] + 1; ans = cnt[v] * cnt[u];
        } else if (len[v] + len[u] + 1 == dia) ans += cnt[v] * cnt[u];
        if (len[v] + 1 > len[u]) {
            len[u] = len[v] + 1; cnt[u] = cnt[v];
        } else if (len[v] + 1 == len[u]) cnt[u] += cnt[v];
    }
}

int main() {
    sc(N);
    for (int i = 1, u, v; i < N; i++) {
        sc(u); sc(v);
        adj[u].pb(v); adj[v].pb(u);
    }
    dfs(1, 0);
    printf("%d\n", ans);
}