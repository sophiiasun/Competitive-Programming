#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back
#define ll long long

using namespace std;

const int MN = 1e5+3;
int N, a[MN], psa[MN], sfa[MN];
char _;

int main() {
    sc(N); int ans = 2e9;
    for (int i = 1; i <= N; i++) {
        sc(a[i]); psa[i] = psa[i-1] + a[i];
    }
    for (int i = N; i >= 1; i--) sfa[i] = sfa[i+1] + a[i];
    for (int i = 1; i < N; i++) {
        ans = min(ans, abs(psa[i] - sfa[i+1]));
    }
    printf("%d\n", ans);
}