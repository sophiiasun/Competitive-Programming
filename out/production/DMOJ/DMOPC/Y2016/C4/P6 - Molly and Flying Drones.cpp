#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
typedef long long ll;
char _;
const int M = 1e6+5;
int N, Q, h[M]; ll psa[M];
stack<int> stk;

int main(){
    scan(N); scan(Q);
    for (int i = 1; i <= N; i++) scan(h[i]);
    for (int i = 1; i <= N; i++) {
        while(!stk.empty() && h[i] < h[stk.top()]) {
            int idx = stk.top(); stk.pop();
            int l = stk.empty() ? 0 : stk.top();
            psa[h[idx]] += (ll)(idx-l) * (ll)(i-idx);
        }
        stk.push(i);
    }
    while (!stk.empty()) {
        int idx = stk.top(); stk.pop();
        int l = stk.empty() ? 0 : stk.top();
        psa[h[idx]] += (ll)(idx - l) * (N+1-idx);
    }
    for (int i = 1; i < M; i++) psa[i] += psa[i-1];
    for (int i = 1, x, y; i <= Q; i++) {
        scan(x); scan(y);
        cout<<psa[y] - psa[x-1]<<endl;
    }

    return 0;
}