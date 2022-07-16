#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;

char _;
const int MN = 103, MM = 2e4+1, MT = 8643;
int N, M, T, t[MN], add = 0;
double v[MN], dp[MT<<1];
bool b[MM][MN];

int main() {
    sc(N); sc(M); sc(T); memset(b, sizeof(b), 0); memset(dp, sizeof(dp), 0);
    for (int i = 1; i <= N; i++) sc(t[i]);
    for (int i = 1, x; i <= M; i++) {
        sc(x); if (!x) add++;
        for (int j = 1, y; j <= x; j++) {
            sc(y); v[y] += (1.0/x);
        }
    }
    for (int i = 1; i <= N; i++) {
        for (int j = T; j >= t[i]; j--) dp[j] = max(dp[j], dp[j-t[i]] + v[i]);
    }
    cout<<fixed<<setprecision(2)<<dp[T]+add<<"\n";
}