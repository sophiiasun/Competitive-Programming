#include <bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back
#define mp make_pair
#define ins insert

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<vector<int>> vii;
typedef map<int, int> mii;
char _;

const int MN = 1003;
int N, M, T, Q;
vi mapp[MN];
queue<pii> q;
bool vis[MN];

int main() {
    sc(N); sc(M); sc(T);
    for (int i = 0, a, b; i < M; i++) { sc(a); sc(b); mapp[a - 1].push_back(b - 1); }
    sc(Q);
    for (int i = 0, a, b; i < Q; i++) {
        sc(a); sc(b); memset(vis, 0, sizeof(vis));
        pii st = {a - 1, b - 1};
        q.push({st.f, 0});
        bool found = 0;
        while (!q.empty()) {
            pii cur = q.front(); q.pop();
            if (cur.f == st.s) {
                printf("%d\n", cur.s);
                found = 1; continue;
            }
            for (int j : mapp[cur.f]) {
                if (!vis[j]) {
                    q.push({j, cur.s + T});
                    vis[j] = 1;
                }
            }
        }
        if (!found) printf("Not enough hallways!\n");
        while (!q.empty()) q.pop();
    }
}