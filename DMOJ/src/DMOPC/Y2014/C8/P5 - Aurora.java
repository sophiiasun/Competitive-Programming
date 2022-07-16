//#include <bits/stdc++.h>
//#include <iostream>
//#define sc(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
//#define f first
//#define s second
//#define pb push_back
//#define mp make_pair
//#define ins insert
//
//using namespace std;
//typedef long long int ll;
//typedef pair<int, int> pii;
//typedef vector<int> vi;
//typedef vector<vector<int>> vii;
//typedef map<int, int> mii;
//char _;
//
//const int MN = 1e5+3;
//int N, M, arr[MN]; ll A, B, C, t[MN], tt = 0, tb, tc, save=0;
//bool over;
//
//int main() {
//    sc(N); sc(M); sc(A); sc(B); sc(C);
//    for (int i = 1; i <= N; i++) sc(arr[i]);
//    sort(arr+1, arr+N+1);
//    t[1] = A * (arr[1] - 1);
//    for (int i = 2; i <= N; i++) {
//        if (arr[i] != arr[i-1]) t[i] = A * (arr[i] - arr[i-1]);
//        t[i] += t[i-1] + C;
//    }
//    for (int i = 1; i <= N; i++) {
//        if (!over) {
//            t[i] -= tt; tb = B * (arr[i] - 1); tc = C * (N - i);
//            if (tb <= tc + t[i]) tt += C, t[i] = tb;
//            else over = 1, save = tt * (N-i);
//        }
//        t[i] += t[i-1];
//    }
//    cout<<t[N]-save<<"\n";
//}