#include <iostream>
#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)

using namespace std;

int xs, ys, xe, ye, T;
char _;

bool val (int x, int y) {
    return (xs <= x && ys <= y && x <= xs+xe && y <= ys+ye);
}

int main() {
    sc(xs); sc(ys); sc(xe); sc(ye); sc(T);
    int x = 0, y = 0;
    while (--T) {
        if (xs - x > ys - y) { x += 2; y++; }
        else { x++; y += 2; }
        if (val(x, y)) { printf("YES\n"); return 0; }
    }
    printf("NO\n"); return 0;
}