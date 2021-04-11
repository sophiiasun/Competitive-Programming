#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<ll>> mat;
char _;

const int mod = 1e9+7;
ll T, a, b, c, k;

ll binpow(ll x, ll exp) {
    if (exp == 0) return 1;
    ll ret = binpow(x, exp/2) % mod;
    if (exp % 2) return (((ret * ret) % mod) * x) % mod ;
    else return (ret * ret) % mod;
}

int main() {
    sc(T);
    for (int i = 0; i < T; i++ ) {
        sc(a); sc(b); sc(c); sc(k);
        if (c - b == b - a) // arithmetic
            printf("%lld\n", (a + ((k - 1) * (b - a))%mod) % mod);
        else
            printf("%lld\n", (a * binpow(b/a, k-1)) % mod);
    }
}