#include<bits/stdc++.h>
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
char _;

const int MN = 1e5+3;
int N, inf = 0x3f3f3f3f, ans=0;
bool vis[MN];
vi adj[MN];
queue<int> q;

int main() {
    sc(N); // memset(dis, inf, sizeof(dis));
    for (int i = 1, x, y; i < N; i++) {
        sc(x); sc(y);
        adj[x].pb(y); adj[y].pb(x);
    }
    vis[1] = 1;
    q.push(1);
    while (!q.empty()) {
        int cur = q.front(); q.pop();
        int sz = 0;
        for (int i : adj[cur]) {
            if (vis[i]) continue;
            q.push(i); vis[i] = 1; sz++;
        }
        ans += sz <= 0 ? 0 : ceil(log2(sz+1));
        ans += sz;
    }
    printf("%d\n", ans);
}