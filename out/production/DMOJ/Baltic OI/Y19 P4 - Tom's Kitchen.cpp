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

const int MN = 303, MM = 1e5+3, inf = 0x3f3f3f;
int N, M, K, a[MN], b[MN], dp[MM], sum1, sum2;

int main(){
    sc(N); sc(M); sc(K); memset(dp, -inf, sizeof(dp));
    for (int i = 1; i <= N; i++) {
        sc(a[i]); sum1 += a[i];
        if (a[i] < K) { cout<<"Impossible\n"; return 0; }
    }
    dp[0] = 0;
    for (int i = 1; i <= M; i++) {
        sc(b[i]);
        for (int j = MM-1; j >= b[i]; j--) dp[j] = max(dp[j], dp[j-b[i]] + min(b[i], N));
    }
    for (int i = sum1; i < MM; i++) {
        if (dp[i] >= N*K) { cout<<(i-sum1)<<"\n"; return 0; }
    }
    printf("Impossible\n");
    return 0;
}