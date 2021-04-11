#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;
char _;

// binary search tree test

struct node {
    int v, rk, sz;
    node* c[2]; // left is c[0], right is c[1]
    node (int x) { v = x; rk = rand(); sz = 1; c[0] = c[1] = nullptr; }
};

struct treap {
    int getsz(node* rt) {
        return !rt ? 0 : rt -> sz;
    }
    void upd(node* rt) { // call when change subtree
        if (rt) rt -> sz = getsz(rt -> c[0]) + getsz(rt -> c[1]) + 1;
    }
    void rot(node *&rt, int dir) { // dir = 0 left rotation, dir = 1 right rotation
        node* ch = rt -> c[dir];
        rt -> c[dir] = ch -> c[!dir]; ch -> c[!dir] = rt;
        upd(rt); upd(ch); rt = ch;
    }
    void ins(node *&rt, node *x) {
        if (!rt) rt = x;
        else {
            int dir = rt -> v < x -> v; ins(rt -> c[dir], x);
            if (rt -> c[dir] -> rk > rt -> rk) rot(rt, dir);
        }
        upd(rt);
    }
    void print(node* rt) {
        if (!rt) return;
        print(rt -> c[0]);
        cout << rt -> v << " ";
        print(rt -> c[1]);
    }
    void del (node *&rt, int x) { // delete
        if (!rt) return;
        if (rt -> v == x) {
            if (!(rt -> c[0])) rt = rt -> c[1];
            else if (!(rt->c[1])) rt = rt -> c[0];
            else {
                int dir = rt -> c[1] -> rk > rt -> c[0] -> rk; rot(rt, dir);
                del(rt -> c[!dir], x);
            }
        } else if (rt -> v < x) del(rt -> c[1], x);
        else del(rt -> c[0], x);
        upd(rt);
    }
    int small(node* rt, int x) { // return xth smallest value
        if (getsz(rt -> c[0]) + 1 == x) return rt -> v;
        if (getsz(rt -> c[0]) + 1 < x) return small(rt -> c[1], x - getsz(rt -> c[0]) - 1);
        return small(rt -> c[0], x);
    }
    int first(node* rt, int x, int y) {
        if (!rt) return -1;
        if (rt -> v == x) {
            int tmp = first(rt -> c[0], x, y);
            return tmp == -1 ? y + getsz(rt -> c[0]) + 1 : tmp;
        } else if (rt -> v < x) return first(rt -> c[1], x, y + getsz(rt -> c[0]) + 1);
        return first(rt -> c[0], x, y);
    }
};

treap t; node* rt;
int N, M, lastAns = 0;

int main () {
    scanf("%d %d", &N, &M);
    for (int i = 1, x; i <= N; i++) { scan(x); t.ins(rt, new node(x)); }
    for (int i = 1, x; i <= M; i++) {
        char c; cin>>c; scanf("%d", &x); x ^= lastAns;
        if (c == 'I') t.ins(rt, new node(x));  // insert x
        else if (c == 'R') t.del(rt, x);  // delete x
        else if (c == 'S') printf("%d\n", lastAns = t.small(rt, x));  // output x'th smallest value
        else printf("%d\n", lastAns = t.first(rt, x, 0));  // output 1-based index of first occurence of x
    }
    t.print(rt);
    return 0;
}