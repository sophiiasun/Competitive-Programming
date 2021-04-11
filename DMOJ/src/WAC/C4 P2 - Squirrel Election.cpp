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
typedef vector<vector<int>> vii;
char _;

const int MN = 5e3+3;
const ll inf = 1e16;
int N, tot=0, v[MN], p[MN];
ll dp[MN][MN], ans=inf;

int main() {
    sc(N);
    for (int i = 1; i <= N; i++) {
        sc(v[i]); sc(p[i]);
        v[i] = v[i]/2+1; tot += p[i];
    }
    for (int i = 0; i <= N; i++) fill(dp[i], dp[i]+tot+1, inf);
    for (int i = 0; i <= N; i++) dp[i][0] = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= tot; j++) {
            if (j < p[i]) dp[i][j] = dp[i-1][j];
            else dp[i][j] = min(dp[i-1][j], dp[i-1][j-p[i]] + v[i]);
        }
    }
    for (int i = tot/2+1; i <= tot; i++) ans = min(ans, dp[N][i]);
    printf("%lld\n", ans);
}