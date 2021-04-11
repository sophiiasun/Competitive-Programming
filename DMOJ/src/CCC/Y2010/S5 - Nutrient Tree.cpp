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

// Nutrient tree
const int MN = 400, MM = 2503;
string s;
int X, dp[MN][MM], l[MM], r[MM], p;

void build(int rt) {
    while (p < s.size() && (s[p] == ' ' || s[p] == ')')) p++;
    if (s[p] == '(') { p++; build(rt * 2); build(rt * 2 + 1); }
    else {
        int num = 0;
        while (isdigit(s[p])) { num = num*10 + s[p] - '0'; p++; }
        for (int i = 0; i <= X; i++) dp[rt][i] = num + i;
    }
}

void solve(int rt) {
    if (dp[rt][0]) return;
    int lc = rt * 2, rc = rt * 2 + 1;
    solve(lc); solve(rc);
    memset(l, 0, sizeof(l)); memset(r, 0, sizeof(r));
    for (int i = 0; i <= X; i++) {
        for (int j = 0; j <= i; j++) {
            l[i] = max(l[i], min((j+1)*(j+1), dp[lc][i-j]));
        }
    }
    for (int i = 0; i <= X; i++) {
        for (int j = 0; j <= i; j++) {
            r[i] = max(r[i], min((j+1)*(j+1), dp[rc][i-j]));
        }
    }
    for (int i = 0; i <= X; i++) {
        for (int j = 0; j <= i; j++) {
            dp[rt][i] = max(dp[rt][i], l[j] + r[i-j]);
        }
    }
}

int main() {
    getline(cin, s); sc(X);
    build(1); solve(1);
    printf("%d\n", dp[1][X]);
}