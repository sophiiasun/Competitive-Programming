#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

const int MN = 3005;
int M, N, op, x, r, c, R, C, a[MN][MN]; long long int bit[MN][MN], ans;
char _;

void upd(int r, int C, int x) {
    for (; r <= M; r += (r & -r)) {
        for (int c = C; c <= N; c += (c & -c)) bit[r][c] += x;
    }
}

long long int sum(int r, int C) {
    long long int ret = 0LL;
    for (; r; r -= (r & -r)) {
        for (int c = C; c; c -= (c & -c)) ret += bit[r][c];
    }
    return ret;
}

int main() {
    cin >> M >> N >> op;
    while (op) {
        if (op == 1) {
            cin >> r >> c >> x;
            if ((r + c) % 2 != 0) { upd(r, c, -a[r][c] + x); a[r][c] = x; }
            else { upd(r, c, -a[r][c] - x); a[r][c] = -x; }
        } else {
            cin >> r >> c >> R >> C;
            ans = sum(R, C) - sum(R, c-1) - sum(r-1, C) + sum(r-1, c-1);
            printf("%lld\n", (r + c) % 2 != 0 ? ans : (-ans));
        }
        cin>>op;
    }
}