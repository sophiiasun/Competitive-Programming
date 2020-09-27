#include<bits/stdc++.h>
#include <iostream>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define MAXV 1500000000
#define mp make_pair
#define ll long long

char _;

using namespace std;

int main(){
    int N, M, S, E, a, b;
    scan(N); scan(M);
    vector<int> arr[N];
    scan(S); scan(a); arr[S].push_back(a);
    scan(E); scan(b); arr[E].push_back(b);
    for (int i = 0; i < M-2; i++) {scan(a); scan(b); arr[a].push_back(b);}
//    set<int> arr[N];
//    scan(S); scan(a); arr[S].insert(a);
//    scan(E); scan(b); arr[E].insert(b);
//    for (int i = 0; i < M-2; i++) {scan(a); scan(b); arr[a].insert(b);}

    // dedup
    for (int i = 0; i < N; i++) {
        sort(arr[i].begin(), arr[i].end());
        auto last = unique(arr[i].begin(), arr[i].end());
        arr[i].erase(last, arr[i].end());
    }

    ll dis[N];
    memset(dis, 0x3f3f3f, sizeof(dis));
    priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;
    pq.push(mp(0, S)); dis[S] = 0;
    while (!pq.empty()) {
        ll d = pq.top().first, n = pq.top().second; pq.pop();
        if (n == E) { cout<<d<<endl; return 0; }
        if (dis[n] < d) continue;
        for (int jump : arr[n]) {
            for (int i = 1; n + i * jump < N; i++) { // Go through each possible jump by Doge i
                int j = i * jump + n;
                if (dis[n] + i < dis[j]) { // Takes less jumps
                    dis[j] = dis[n] + i; pq.push(mp(dis[j], j));
//                    if (arr[j].find(jump) != arr[j].end()) break;
                }
                if (find(arr[j].begin(), arr[j].end(), jump) != arr[j].end()) break;
            }
            for (int i = 1; n - i * jump >= 0; i++) { // Go through each possible jump by Doge i
                int j = n - i * jump;
                if (dis[n] + i < dis[j]) {
                    dis[j] = dis[n] + i; pq.push(mp(dis[j], j));
//                    if (arr[j].find(jump) != arr[j].end()) break;
                }
                if (find(arr[j].begin(), arr[j].end(), jump) != arr[j].end()) break;
            }
        }
    }

    cout<<-1<<endl;

    return 0;
}