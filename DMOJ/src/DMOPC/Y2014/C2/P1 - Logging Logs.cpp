#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> mat;
char _;

int D, T, a[51];

int main() {
    sc(D);
    for (int i = 1; i <= D; i++) {
        sc(T);
        for (int j = 1, x; j <= T; j++) { sc(x); a[i] += x; }
    }
    for (int i = 1; i <= D; i++) {
        if (!a[i]) printf("Weekend\n");
        else printf("Day %d: %d\n", i, a[i]);
    }
}