#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

const int MN = 1003;
int N, T, dp[MN];
char _;

int main() {
    scan(N); scan(T);
    for (int i = 1, v, h; i <= N; i++) {
        scan(v); scan(h);
        for (int j = T; j >= h; j--)
            dp[j] = max(dp[j], dp[j-h] + v);
    }
    printf("%d\n", dp[T]);
}