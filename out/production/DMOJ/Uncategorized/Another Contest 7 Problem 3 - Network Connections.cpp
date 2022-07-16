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

// network connections
const int MN = 1e5+3;
int N, M, sz[MN], par[MN], f[MN]; ll cost=0;
vi adj[MN]; priority_queue<pii, vector<pii>, greater<pii>> pq;

int find(int u) {
    return par[u] = u == par[u] ? par[u] : find(par[u]);
}

void merge(int a, int b) {
    a = find(a); b = find(b);
    if (sz[b] > sz[a]) swap(a, b);
    sz[a] += sz[b]; par[b] = a;
}

int main() {
    sc(N); sc(M);
    for (int i = 1; i <= N; i++) { sc(f[i]); par[i] = i; sz[i] = 1; }
    for (int i = 1, a, b; i <= M; i++) { sc(a); sc(b); merge(a, b); }
    for (int i = 1, a, b; i < N; i++) {
        a = find(i); b = find(i+1);
        if (a != b) pq.push({f[i+1] - f[i], i});
    }
    while (!pq.empty()) {
        pii cur = pq.top(); pq.pop();
        int a = find(cur.s), b = find(cur.s+1);
        if (a != b) { cost += cur.f; merge(a, b); }
    }
    printf("%lld\n", cost);
}