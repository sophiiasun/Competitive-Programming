#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
char _, c;
int N, M, Q, rnk[100005], par[100005];

struct node {
    int v, rk, sz;
    node* c[2]; // left is c[0], right is c[1]
    node (int x) { v = x; rk = rand(); sz = 1; c[0] = c[1] = nullptr; }
}; node *root[100005];

int getsz(node* rt) {
    return rt == nullptr ? 0 : rt -> sz;
}
int getrk(node* rt, int x) { // return xth smallest value
    if (!rt) return -1;
    if (getsz(rt -> c[0]) + 1 == x) return rt -> v;
    if (getsz(rt -> c[0]) + 1 < x) return getrk(rt -> c[1], x - getsz(rt -> c[0]) - 1);
    return getrk(rt -> c[0], x);
}
void upd(node* rt) { // call when change subtree
    if (rt) rt -> sz = getsz(rt -> c[0]) + getsz(rt -> c[1]) + 1;
}
node *rot(node *rt, int dir) { // dir = 0 left rotation, dir = 1 right rotation
    node *ch = rt -> c[dir]; rt -> c[dir] = ch -> c[!dir]; ch -> c[!dir] = rt;
    upd(rt); upd(ch); return ch;
}
void ins(node*& rt, int x) {
    if (!rt) rt = new node(x);
    else {
        int dir = x > rt -> v; ins(rt -> c[dir], x);
        if (rt -> c[dir] -> rk > rt -> rk) rt = rot(rt, dir);
    }
    upd(rt);
}
void combine (node*& keep, node*& mrge) {
    if (!mrge) return;
    combine(keep, mrge -> c[0]);
    combine(keep, mrge -> c[1]);
    ins(keep, mrge -> v);
}
void del (node*& rt) {
    if (rt -> c[0]) del(rt -> c[0]);
    if (rt -> c[1]) del(rt -> c[1]);
    rt = nullptr;
}
int find (int x) { return x == par[x] ? x : par[x] = find(par[x]); }
void merge (int x, int y) {
    int p1 = find(x), p2 = find(y);
    if (p1 == p2) return;
    if (getsz(root[p1]) < getsz(root[p2])) swap(p1, p2);
    combine(root[p1], root[p2]); par[p2] = p1; del(root[p2]);
}

int main() {
    scanf("%d %d", &N, &M);
    for (int i = 1, x; i <= N; i++) { scanf("%d", &x); rnk[x] = par[i] = i; ins(root[i], x); }
    for (int i = 1, x, y; i <= M; i++) { scanf("%d %d", &x, &y); merge(x, y); }
    scanf("%d", &Q);
    for (int i = 1, a, b; i <= Q; i++) {
        scanf(" %c %d %d", &c, &a, &b);
        if (c == 'B') merge(a, b);
        else {
            node* cur = root[find(a)];
            printf("%d\n", getsz(cur) < b ? -1 : rnk[getrk(cur, b)]);
        }
    }
    return 0;
}