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

const int MN = 2e5+3;
ll N, a, odd, even;

int main () {
    sc(N); 
    while (N--) {
        sc(a);
        if (a % 2 == 0) even += ceil(a/2);
        else odd += ceil(a/2);
    }
    printf(odd > even ? "Alice\n" : "Duke\n");
}