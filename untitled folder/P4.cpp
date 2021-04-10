#include <bits/stdc++.h>
#include <iostream>
#define f first
//#define s second
#define pb push_back
#define mp make_pair
#define ins insert

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<vector<int>> vii;
typedef map<int, int> mii;
//char _;

const int MN = 1e6+3;
int N, mn = INT_MAX, mx=0, dis[MN];
ll ans = LONG_LONG_MAX, tmp;

struct S { int p, w, d; };
S vec[MN];
map<int, int> mpp;

int main() {
    scanf("%d", &N);
    if (N == 1) { printf("0\n"); return 0; }
    for (int i = 0, p, w, d; i < N; i++) {
        scanf("%d %d %d", &p, &w, &d);
        vec[i].w = w; vec[i].p = p; vec[i].d = d;
        mn = min(mn, p); mx = max(mx, p);
    }
    for (int i = mn; i <= mx; i++) { // i = position
        tmp = 0;
        for (int j = 0; j < N; j++) { // s is each person
            S &c = vec[j];
            if (abs(i-c.p) <= c.d) continue;
            if (i > c.p) tmp += (i-c.d-c.p)*c.w;
            else tmp += (c.p-i-c.d)*c.w;
        }
        ans = min(ans, tmp);
    }
    printf("%lld\n", ans);
}