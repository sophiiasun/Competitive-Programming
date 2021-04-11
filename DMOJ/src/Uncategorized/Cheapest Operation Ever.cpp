#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

typedef long long ll;

char _;
ll dp[100005], arr[100005], N, H;

long double calc(int b, int a) {
    long double tmp = ((long double)(dp[a-1] - dp[b-1] + arr[a]*arr[a] - arr[b]*arr[b]) / (long double)((arr[a] - arr[b]) * 2.0));
    return tmp;
}

int main(){
    scan(N); scan(H);
    for (int i = 1; i <= N; i++) scan(arr[i]);
    deque<int> dq;
    for (int i = 1; i <= N; i++) {
        dq.push_back(i);
        while (dq.size() >= 2) {
            int first = dq[0], second = dq[1]; dq.pop_front();
            if (calc(first, second) > (long double)arr[i]) { dq.push_front(first); break; }
        }
        int f = dq[0];
        dp[i] = dp[f-1] + (arr[i] - arr[f])*(arr[i] - arr[f]) + H;
        while (dq.size() >= 2) {
            int first = dq[dq.size()-1], second = dq[dq.size()-2]; dq.pop_back();
            if (calc(second, first) < calc(first, i)) { dq.push_back(first); break; }
        }
        dq.push_back(i);
    }
    cout<<dp[N]<<endl;
    return(0);
}