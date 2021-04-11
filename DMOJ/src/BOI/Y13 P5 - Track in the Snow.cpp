#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

const int MN = 4003;
int H, W, ans = 0, d[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
bool vis[MN][MN];
char _, a[MN][MN];
queue<pair<int, int>> q[2];

bool val(int r, int c) {
    return r && c && r <= H && c <= W && !vis[r][c] && a[r][c] != '.';
}

void bfs() {
    while (!q[0].empty()) {
        int r = q[0].front().first, c = q[0].front().second; q[0].pop();
        for (auto &i : d) {
            int rr = r + i[0], cc = c + i[1];
            if (!val(rr, cc)) continue;
            vis[rr][cc] = 1;
            if (a[r][c] == a[rr][cc]) q[0].push({rr, cc});
            else q[1].push({rr, cc});
        }
    }
}

int main() {
    scan(H); scan(W);
    for (int i = 1; i <= H; i++) {
        for (int j = 1; j <= W; j++) cin>>a[i][j];
    }
    q[0].push({1, 1}); vis[1][1] = 1;
    while (1) {
        ans++; bfs();
        if (q[1].empty()) break;
        swap(q[0], q[1]);
    }
    printf("%d\n", ans);
}