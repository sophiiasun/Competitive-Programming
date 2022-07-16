// count multiples
#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;

const int MN = 1e5+3;
ll x, y, A, B, cntA, cntB, cntAB, tmp;
char _;

ll gcf(ll a, ll b) {
    int t;
    while (b != 0) {
        t = b; b = a % b; a = t;
    }
    return a;
}

ll lcm(ll a, ll b) {
    return (a*b) / gcf(a, b);
}

int main() {
    sc(x); sc(y); sc(A); sc(B);
    tmp = lcm(A, B); x--;
    cntA = y/A - x/A;
    cntB = y/B - x/B;
    cntAB = y/tmp - x/tmp;
//    cout<<tmp<<" "<<cntA<<" "<<cntB<<" "<<cntAB<<"\n";
    printf("%lld\n", cntA + cntB - cntAB);
}