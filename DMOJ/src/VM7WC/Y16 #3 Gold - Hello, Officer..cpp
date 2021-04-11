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

const int MN = 2e3+2, inf = 0x3f3f3f3f;
int N, M, B, Q, dis[MN];
vector<pii> adj[MN];
priority_queue<pii> pq;

int main() {
    sc(N); sc(M); sc(B); sc(Q); memset(dis, inf, sizeof(dis));
    for (int i = 1, x, y, z; i <= M; i++) {
        sc(x); sc(y); sc(z);
        adj[x].pb({z, y}); adj[y].pb({z, x});
    }
    dis[B] = 0;
    pq.push({0, B});
    while (!pq.empty()) {
        pii u = pq.top(); pq.pop();
//        cout<<u.f<<" "<<u.s<<"\n";
        for (pii v : adj[u.s]) {
            if (dis[u.s] + v.f >= dis[v.s]) continue;
            dis[v.s] = dis[u.s] + v.f;
            pq.push({dis[v.s], v.s});
        }
    }
    for (int i = 1, x; i <= Q; i++) {
        sc(x);
        printf("%d\n", dis[x] == inf ? -1 : dis[x]);
    }
}