#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second

using namespace std;

const int MN = 21, MK = 32;
int N, K, arr[MN], low[MN], dfn[MN], ans = 0, idx = 1, cnt = 1, freq[MN];
bool inStack[MN], vis[MN], id[MN];
char _;
vector<int> adj[MN];
stack<int> stk;

void tarjan (int src) {
    stk.push(src);
    arr[src] = dfn[src] = idx++;
    inStack[src] = vis[src] = 1;
    for (auto &i : adj[src]) {
        if (dfn[i] == -1) { tarjan(i); arr[src] = min(arr[src], arr[i]); }
        else if (inStack[i]) arr[src] = min(arr[src], dfn[i]);
    }
    if (dfn[src] == arr[src]) {
        while (stk.top() != src) {
            int tmp = stk.top(); stk.pop();
            low[tmp] = cnt; inStack[tmp] = 0; freq[cnt]++;
        }
        int tmp = stk.top(); stk.pop();
        low[tmp] = cnt; inStack[tmp] = 0; freq[cnt++]++;
    }
}

int main() {
    scan(N); scan(K);
    memset(dfn, -1, sizeof(dfn)); memset(arr, -1, sizeof(arr)); memset(freq, 0, sizeof(freq));
    for (int i = 0, x, y, X, Y; i < K; i++) { // in win -> lose order
        scan(x); scan(y); scan(X); scan(Y);
        if (X > Y) adj[x].push_back(y);
        else adj[y].push_back(x);
    }
    for (int i = 1; i <= N; i++) { if (!vis[i]) tarjan(i); }
    for (int i = 1; i <= N; i++) if (freq[i] > 1) ans += freq[i];
    printf("%d\n", ans);
}