#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
typedef long long int ll;
char _;

const int MN = 1e6+3;
int N, a[MN], b[MN]; ll ans, sum;

int main () {
    sc(N);
    for (int i = 0; i < N; i++) sc(a[i]);
    for (int i = 0; i < N; i++) sc(b[i]);
    sort(a, a+N); sort(b, b+N);
    if (a[N-1] != b[N-1]) { printf("-1\n"); return 0; }
    for (int r = 0, c = 0; r < N; r++) {
        while (c < N && b[c] <= a[r]) { sum += b[c++]; }
        ans += sum + (ll)(N-c) * a[r];
    }
    printf("%lld\n", ans); return 0;
}