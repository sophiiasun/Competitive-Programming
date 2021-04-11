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

const int MN = 150000+3;
int N, bit[MN<<1]; ll sum=0, ans=0;

void upd(ll i) {
    for (i += MN; i <= MN<<1; i += i & -i) bit[i]++;
}

ll query(ll i) {
    ll ret = 0;
    for (i += MN; i; i -= i & -i) ret += bit[i];
    return ret;
}

int main () {
    sc(N); upd(0);
    for (int i = 1, x; i <= N; i++) {
        sc(x);
        sum += (x == 1 ? 1 : -1);
        ans += query(sum-1);
        upd(sum);
    }
    printf("%lld\n", ans);
}