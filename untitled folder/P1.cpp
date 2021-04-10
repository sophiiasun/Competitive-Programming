#include <bits/stdc++.h>
#include <iostream>
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

const int MN = 1e4+3;
int N, h[MN], w[MN];
double ans=0;

int main() {
     scanf("%d", &N);
     for (int i = 0; i <= N; i++) {
         scanf("%d", &h[i]);
     }
     for (int i = 0; i < N; i++) {
         scanf("%d", &w[i]);
     }
     for (int i = 0; i < N; i++) { // (l1+l2)h/2
         ans += (h[i]+h[i+1])*w[i]/2.0;
     }
     printf("%f\n", ans);
}