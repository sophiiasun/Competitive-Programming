#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define pb push_back

using namespace std;
typedef long long int ll;

const int MN = 200003;
int N, day[MN], bit[MN]; vector<int> vec[MN]; priority_queue<int> pq; ll ans = 0;
char _;

void upd(int i, int x) {
    for (; i <= N; i += i & -i) bit[i] += x;
}

int query(int i) {
    int ret = 0;
    for (; i; i -= i & -i) ret += bit[i];
    return ret;
}

int main () {
    scan(N);
    for (int i = 1, x; i <= N; i++) {
        scan(x); vec[x].pb(i);
    }
    for (int i = N; i > 0; i--) {
        for (int j : vec[i]) pq.push(j);
        if (pq.empty()) { printf("-1\n"); return 0; }
        day[i] = pq.top(); pq.pop();
    }
    for (int i = N; i > 0; i--) {
        ans += query(day[i]);
        upd(day[i], 1);
    }
    printf("%lld\n", ans);
}