#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;

//counting cycles
int N, ans; vector<int> adj[11]; bool vis[11]; char _;

void dfs (int u, int rt) {
    vis[u] = 1;
    for (int v : adj[u]) {
        if (v == rt) ans ++;
        if (!vis[v] && v > rt) dfs(v, rt);
    }
    vis[u] = 0;
}

int main() {
    scan(N);
    for (int i = 1, x; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin>>x; if (x) adj[i].pb(j);
        }
    }
    for (int i = 1; i <= N; i++) dfs(i, i);
    printf("%d\n", ans);
}