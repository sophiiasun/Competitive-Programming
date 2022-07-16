#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second

using namespace std;

const int MN = 3005;
int M, N, r, c, x, R, C;
long long int psa[MN][MN];

int main() {
    memset(psa, 0, sizeof(psa)); // odd is -, even is +
    scanf("%d %d", &M, &N);
    scanf("%d %d %d", &r, &c, &x);
    while (r) {
        if ((r + c) & 1) psa[r][c] = x;
        else psa[r][c] -= x;
        scanf("%d %d %d", &r, &c, &x);
    }
    for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
    }
    scanf("%d %d %d %d", &r, &c, &R, &C);
    while (r) {
        long long val = psa[R][C] - psa[r-1][C] - psa[R][c-1] + psa[r-1][c-1];
        printf("%lld\n", ((r + c) & 1) ? val : -val);
        scanf("%d %d %d %d", &r, &c, &R, &C);
    }
}