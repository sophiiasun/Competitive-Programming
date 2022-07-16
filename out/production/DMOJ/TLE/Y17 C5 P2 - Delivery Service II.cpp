#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back
#define inf INT_MAX

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> mat;
char _;

const int MN = 1e5+3;
int n, d, xr = inf, yr = -inf, xl = inf, yl = -inf, pos[MN], d1, d2;

int main() {
    cin >> n >> d;
    for (int i = 1; i <= n; i++) cin >> pos[i];
    for (int i = 1, x, y; i <= d; i++) {
        cin >> x >> y; x = pos[x]; y = pos[y];
        if (x < y) { xr = min(xr, x); yr = max(yr, y); }
        else { xl = min(xl, y); yl = max(yl, x); }
    }
    if (xl == inf) printf("%d\n", yr - xr);
    else if (xr == inf) printf("%d\n", yl-xl);
    else {
        d1 = max(yl, yr) - xl + max(yl, yr) - xr;
        d2 = yl - min(xl, xr) + yr - min(xl, xr);
        printf("%d\n", min(d1, d2));
    }
}