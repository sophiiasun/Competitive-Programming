#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define pb push_back

using namespace std;
typedef long long int ll;

const int MN = 100003; char _;
int N, M, dfn[MN], low[MN], cnt=0, ans=0;
vector<int> adj[MN]; bool b[MN];

void tarjan(int u, int p) {
    dfn[u] = low[u] = ++cnt; int v = 0;
    for (int i : adj[u]) {
        if (i == p) continue;
        if (!dfn[i]) {
            v++; tarjan(i, u);
            if (low[i] < low[u]) low[u] = low[i];
            if (u != p && dfn[u] <= low[i]) b[u] = 1;
        } else if (dfn[i] < low[u]) low[u] = dfn[i];
    }
    if (u == p && v > 1) b[u] = 1;
}

int main() {
    scan(N); scan(M);
    for (int i = 1, a, b; i <= M; i++) { scan(a); scan(b); adj[a].pb(b); adj[b].pb(a); }
    for (int i = 1; i <= N; i++) { if (!dfn[i]) tarjan(i, i); }
    for (int i = 1; i <= N; i++) { if (b[i]) ans++; }
    printf("%d\n", ans);
    for (int i = 1; i <= N; i++) { if (b[i]) printf("%d\n", i); }
}