#include<bits/stdc++.h>
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

typedef long long ll;

char _;
ll dp[100001], psaT[100001];

long double calc(ll a, ll b) {
    return ((long double)(dp[a] - dp[b])) / ((long double)(psaT[a] - psaT[b]));
}

int main(){
    ll N, S, pos = 0;
    scan(N); scan(S);
    ll T[100001], F[100001], psaF[100001];
    for (int i = 0; i < N; i++) { scan(T[i]); scan(F[i]); } // input
    for (int i = N-1; i >=0; i--) { psaT[i] = psaT[i+1] + T[i]; psaF[i] = psaF[i+1] + F[i]; } // psa
    //deque<int> dq;
    //dq.push_front(N);
    vector<ll>dq; dq.push_back(N);
    for (int i = N-1; i >= 0; i--) {
        while (pos <= (ll)dq.size()-2 && calc(dq[pos], dq[pos+1]) < (long double)psaF[i]) pos++;
        ll tmp = dq[pos];
        dp[i] = dp[tmp] + (S + psaT[i] - psaT[tmp]) * psaF[i];
        while (pos <= (ll)dq.size()-2 && calc(dq[dq.size()-2], dq[dq.size()-1]) > calc(dq[dq.size()-1], i)) dq.pop_back();
        dq.push_back(i);
    }
    cout<<dp[0]<<endl;
    return(0);
}