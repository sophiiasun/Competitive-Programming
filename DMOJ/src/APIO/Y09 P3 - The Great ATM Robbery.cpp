#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MAXN 500001

using namespace std;

typedef long long ll;

char _;

int N, M, S, P, low[MAXN], cash[MAXN], c[MAXN], arr[MAXN], dfn[MAXN], ans=0, cnt=1, idx=1;
vector<bool> vis(MAXN), inStack(MAXN), p(MAXN);
vector<int> adj[MAXN], dag[MAXN-498000];
stack<int> stk;

void scc (int src) {
    stk.push(src);
    arr[src] = dfn[src] = idx++;
    inStack[src] = vis[src] = true;
    for (int i : adj[src]) {
        if (dfn[i] == -1) {
            scc(i); arr[src] = min(arr[src], arr[i]);
        } else if (inStack[i]) arr[src] = min(arr[src], dfn[i]);
    }
//    cout<<"test: "<<cnt<<endl;
    if (dfn[src] == arr[src]) {
        while (stk.top() != src) {
            // from same
            int tmp = stk.top(); stk.pop();
            low[tmp] = cnt; inStack[tmp] = false;
        }
        //from new
        int tmp = stk.top(); stk.pop();
        low[tmp] = cnt++; inStack[tmp] = false;
    }
}

void build() {
    for (int i = 1; i <= N; i++) {
        for (int j : adj[i]) { if (low[i] != low[j]) dag[low[i]].push_back(low[j]); }
        adj[i].clear();
    }
}

void bfs() {
    queue<int> q;
    fill(vis.begin(), vis.end(), false);
    S = low[S]; q.push(S); vis[S] = true; cash[S] += c[S];
    while (!q.empty()) {
        int curr = q.front(); q.pop();
        vis[curr] = false;
        if (p[curr]) ans = max(ans, (int)cash[curr]);
        for (int i : dag[curr]) {
            if (cash[curr] + (int)c[i] <= cash[i]) continue;
            cash[i] = cash[curr] + (int)c[i];
            if (!vis[i]) { vis[i] = true; q.push(i); }
        }
    }
}

int main(){
    scan(N); scan(M);
    int a, b;
    for (int i = 1; i <= M; i++) { scan(a); scan(b); adj[a].push_back(b); }
    memset(dfn, -1, sizeof(dfn)); memset(arr, -1, sizeof(arr));
    for (int i = 1; i <= N; i++) { if (!vis[i]) scc(i); }
//    for (int i = 1; i <= N; i++) cout<<low[i]<<" ";
    build();
    for (int i = 1; i <= N; i++) { scan(a); c[low[i]] += a; }
    scan(S); scan(P);
    for (int i = 1; i <= P; i++) { scan(a); p[low[a]] = true; }
    bfs();
    cout<<ans<<endl;
}