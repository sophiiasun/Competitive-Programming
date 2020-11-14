#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;

char _;
const int MN = 1e3+3, INF = 0x3f3f3f3f;
int N, M, R, C, dis[MN][MN], r1, c1, r2, c2, dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
char a[MN][MN]; bool bs = 0, be = 0;
queue<pii> q;

bool val(int r, int c) {
    return r > 0 && c > 0 && r <= N && c <= M && a[r][c] != '#' && dis[r][c] == INF;
}

int main() {
    sc(N); sc(M); memset(dis, INF, sizeof(dis));
    for (int i = 1, x; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%c", &a[i][j]);
            if (a[i][j] == 'P') { R = i; C = j; }
            else if (a[i][j] == 'O') { r1 = i; c1 = j; }
            else if (a[i][j] == 'X') { r2 = i; c2 = j; }
        }
        scanf("%c", &x);
    }
    q.push({R, C}); dis[R][C] = 0;
    while (!q.empty()) {
        pii u = q.front(); q.pop();
        if (a[u.f][u.s] == 'O') { bs = 1; }
        if (a[u.f][u.s] == 'X') { be = 1; }
        if (bs && be) break;
        for (int i = 0, r, c; i < 4; i++) {
            r = u.f + dir[i][0]; c = u.s + dir[i][1];
            if (!val(r, c)) continue;
            dis[r][c] = dis[u.f][u.s] + 1;
            q.push({r, c});
        }
    }
    if (bs && be) printf("%d\n", dis[r1][c1] + dis[r2][c2]);
    else printf("-1\n");
}