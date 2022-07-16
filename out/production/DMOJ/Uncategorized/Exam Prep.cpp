#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> mat;
char _;

const int MN = 1e6+3;
int N, Q, par[MN], sz[MN], opt, a, b;
ll av[MN];

int find(int a) {
    return par[a] = a == par[a] ? par[a] : find(par[a]);
}

void merge(int a, int b) {
    int p1 = find(a), p2 = find(b);
    if (p1 == p2) return;
    par[p1] = p2; av[p2] += av[p1]; sz[p2] += sz[p1];
}

int main() {
    sc(N); sc(Q);
    for (int i = 1; i <= N; i++) { sc(av[i]); par[i] = i; sz[i] = 1; }
    while (Q--) {
        sc(opt); sc(a);
        if (opt == 1) { sc(b); merge(a, b); }
        else if (opt == 2) printf("%d\n", sz[find(a)]);
        else printf("%lld\n", av[find(a)]);
    }
}