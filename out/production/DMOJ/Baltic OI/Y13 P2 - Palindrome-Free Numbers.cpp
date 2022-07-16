#include<bits/stdc++.h>
#include <iostream>

typedef long long ll;

using namespace std;

const int MAX = 30;
int a[MAX], val;
ll high, low, dp[MAX][2][2][2][MAX][MAX];

ll run2(int p, bool b, bool pb, bool l, int pr, int ppr) {
    if (p == 0) return 1;
    ll &ret = dp[p][b][pb][l][pr][ppr];
    if (ret) return ret;
    int hi = l ? a[p] : 9;
    for (int i = 0; i <= hi; i++) {
        if ((b||i!=pr) && (pb||i!=ppr)) ret += run2(p-1, b&&!i, b, l&&i==a[p], i, pr);
    }
    return ret;
}

ll run(ll cur) {
    val = 0;
    memset(dp, 0, sizeof(dp));
    for (;cur;cur/=10) a[++val] = cur%10;
    return run2(val, 1, 1, 1, 0, 0);
}

int main(){
    scanf("%lld %lld", &low, &high);
    cout<<run(high) - run(low - 1)<<endl;

    return 0;
}