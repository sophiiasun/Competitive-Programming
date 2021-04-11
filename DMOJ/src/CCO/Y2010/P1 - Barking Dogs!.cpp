#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

const int MN = 1002;
int D, w[MN], F, T, c[MN], t[MN];
vector<int> b[MN];
char _;

int main() {
    memset(c, 0, sizeof(c)); memset(t, -0x3f, sizeof(t));
    scan(D); for (int i = 1; i <= D; i++) scan(w[i]);
    scan(F); for (int i = 0, x, y; i < F; i++) { scan(x); scan(y); b[x].push_back(y); }
    scan(T); t[1] = 0;
    for (int i = 0; i <= T; i++) {
        for (int j = 1; j <= D; j++) {
            if (i != t[j]) continue;
            c[j]++;
            for (int k : b[j]) { if (i > t[k]) t[k] = w[k] + i; }
        }
    }
    for (int i = 1; i <= D; i++) printf("%d\n", c[i]);
}