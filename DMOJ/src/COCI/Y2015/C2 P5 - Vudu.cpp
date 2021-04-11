#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
typedef long long int ll;

const int MN = 1000003;
int N, P, sz, bit[MN]; ll psa[MN], ans = 0LL, ord[MN];
char _;

void upd(int i) {
    for (; i <= N + 1; i+= i & -i) bit[i]++;
}

int sum (int i) {
    int ret = 0;
    for (; i; i -= i & -i) ret += bit[i];
    return ret;
}

int main() {
    scan(N);
    for (int i = 1; i <= N; i++) scan(psa[i]);
    scan(P);
    for (int i = 1; i <= N; i++) {
        psa[i] = psa[i] - P + psa[i-1]; ord[i] = psa[i];
    }
    sort(ord, ord+N+1);
    sz = unique(ord, ord + N + 1) - ord;
    for (int i = 0; i <= N; i++) {
        int rk = lower_bound(ord, ord+sz, psa[i]) - ord + 1;
        ans += sum(rk); upd(rk);
    }
    printf("%lld\n", ans);
}