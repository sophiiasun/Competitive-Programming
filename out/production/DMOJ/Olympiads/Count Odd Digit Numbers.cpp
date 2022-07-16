#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
//#define s second
#define pb push_back

using namespace std;
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> mat;
char _;

string s; ll sz; ll num, ans=0;

int main() {
    sc(num); s = to_string(num); sz = s.size();
    if (sz % 2 == 1) { ans += num - pow(10, --sz) + 1; }
    sz -= 2;
    while (sz >= 0) {
        ll t = pow(10, sz);
        ans += 9 * t; sz-=2;
    }
    printf("%lld\n", ans);
}