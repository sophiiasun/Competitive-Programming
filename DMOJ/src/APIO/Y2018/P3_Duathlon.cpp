#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;

const int MN = 1e5+1;
int N, M, cnt, idx, pos, dfn[MN], low[MN], sz[MN << 1], w[MN << 1], stk[MN << 1];
vector<int> adj[MN], adj2[MN];
ll ans = 0;
char _;

void tarjan (int u) {
    dfn[u] = low[u] = ++idx; stk[++pos] = u; w[u] = -1;
    for (int v : adj[u]) {
        if (dfn[v]) low[u] = min(low[u], dfn[v]);
        else {
            tarjan(v); low[u] = min(low[u], low[v]);
            if (low[v] == dfn[u]) {
                w[++cnt] = 0;
                for (int tmp; tmp != v;) {
                    tmp = stk[pos--]; w[cnt]++;
                    adj2[cnt].pb(tmp); adj[tmp].pb(cnt);
                }
                adj2[cnt].pb(u); adj2[u].pb(cnt); w[cnt]++;
            }
        }
    }
}

void dfs (int u, int p) {
    sz[u] = (u <= N);
    for (int v : adj2[u]) {
        if (v != p) {
            dfs(v, u); ans += (ll)w[u] * sz[u] * sz[v]; sz[u] += sz[v];
        }
    }
    ans += (ll)w[u] * sz[u] * (idx - sz[u]);
}

int main() {
    scan(N); scan(M); cnt = N;
    for (int i = 1; i <= N; i++) w[i] = -1;
    for (int i = 1, u, v; i <= M; i++) { scan(u); scan(v); adj[u].pb(v); adj[v].pb(u); }
    for (int i = 1; i <= N; i++) {
        if (dfn[i]) continue;
        idx = 0; pos = -1; tarjan(i); dfs(i, 0);
    }
    printf("%lld\n", ans<<1);
}