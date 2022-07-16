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

const int MN = 2e5+3;
int N, D, dis[MN], ans;
vi adj[MN];

void dfs(int u) {
    deque<int> dq;
    for (int v : adj[u]) dfs(v), dq.pb(dis[v]+1);
    sort(dq.begin(), dq.end());
    while (dq.size() > 1 && dq[0] + dq[1] < D) ans--, dq.pop_front();
    dis[u] = dq.empty() ? 0 : dq[0] % D;
    if (!dis[u]) ans++;
}

int main() {
    sc(N); sc(D);
    for (int i = 1, a; i < N; i++) { sc(a); adj[a].pb(i); }
    dfs(0);
    printf("%d\n", ans);
}