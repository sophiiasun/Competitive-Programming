#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
typedef long long int ll;
const int MN = 2e5+3;
int N, h[MN], a[MN]; ll dp[MN], bit[MN], ans = 0LL;
char _;

void upd(int idx, ll x) {
    for (; idx <= N; idx += (idx & -idx)) bit[idx] = max(bit[idx], x);
}

ll sum(int idx) {
    ll ret = 0;
    for (; idx; idx -= (idx & -idx)) ret = max(ret, bit[idx]);
    return ret;
}

int main() {
    scan(N); memset(bit, 0, sizeof(bit));
    for (int i = 1; i <= N; i++) scan(h[i]);
    for (int i = 1; i <= N; i++) scan(a[i]);
    for (int i = 1; i <= N; i++) {
        dp[i] = sum(h[i]-1) + a[i];
        upd(h[i], dp[i]);
    }
    for (int i = 1; i <= N; i++) ans = max(ans, dp[i]);
    printf("%lld\n", ans);
}