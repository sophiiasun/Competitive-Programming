// can bob sort it
#include<bits/stdc++.h>
#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define f first
#define s second
#define pb push_back

using namespace std;
typedef long long int ll;

const int MN = 1e5+3;
int N, a1[MN], a2[MN], cnt=0;
char _;

int main() {
    sc(N);
    for (int i = 0; i < N; i++) {
        sc(a1[i]); a2[i] = a1[i];
    }
    sort(a1, a1+N);
    for (int i = 0; i < N; i++) {
        if (a1[i] != a2[i]) cnt++;
    }
    if (cnt==0 || cnt==2) printf("YES\n");
    else printf("NO\n");
}