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

const int MN = 1e5+3;
int N, Q, a, b, sz[MN], par[MN];
char op;

int find(int u) {
    return par[u] = u == par[u] ? par[u] : find(par[u]);
}

void merge(int a, int b) {
    a = find(a); b = find(b);
    if (a == b) return;
    if (sz[b] > sz[a]) swap(a, b);
    sz[a] += sz[b]; par[b] = a;
}

int main() {
    cin>>N>>Q;
    for (int i = 1; i <= N; i++) { par[i] = i; sz[i] = 1; }
    while(Q--) {
        cin>>op>>a>>b;
        if (op == 'A') merge(a, b);
        else cout<<(find(a) == find(b) ? "Y\n" : "N\n");
    }
}