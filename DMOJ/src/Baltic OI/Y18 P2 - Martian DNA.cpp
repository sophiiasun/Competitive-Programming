#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MN 200005
#define mp make_pair
#define pb push_back
#define ll long long
#define f first
#define s second

using namespace std;
char _;

int N, K, R, ori[MN], a[MN], freq[MN], ans = (int)2e9, cnt;

int main() {
    scan(N); scan(K); scan(R); cnt = R;
    for (int i = 1; i <= N; i++) scan(a[i]);
    for (int i = 1, x, y; i <= R; i++) { scan(x); scan(y); ori[x] = y; }
    for (int pf = 1, pb = 1; pb <= N; pb++) {
        if (++freq[a[pb]] == ori[a[pb]]) cnt--;
        while (pf <= pb && freq[a[pf]] > ori[a[pf]]) { freq[a[pf]]--; pf++; }
        if (!cnt) ans = min(ans, pb - pf + 1);
    }
    if (ans == (int)2e9) cout<<"impossible"<<"\n";
    else cout<<ans<<"\n";
    return 0;
}