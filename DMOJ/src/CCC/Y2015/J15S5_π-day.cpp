#include<bits/stdc++.h>
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
typedef vector<vector<int>> vii;
char _;

const int MN = 253;
int N, K, a[MN][MN][MN];

int run(int n, int k, int p) {
    if (k == 1 || n == k) return 1;
    else if (a[n][k][p] == 0) {
        for (int i = p; i <= n / k; i++) {
            a[n][k][p] += run(n-i, k-1, i);
        }
    }
    return a[n][k][p];
}

int main() {
    sc(N); sc(K);
    printf("%d\n", run(N, K, 1));
}