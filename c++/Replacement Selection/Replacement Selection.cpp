#include<cstring>
#include<algorithm>
#include<iostream>
#include<vector>
#include<unordered_map>
#include<queue>

using namespace std;

const int N = 100010;
int n, k, maxrun;
priority_queue<int, vector<int>, greater<int>> v[N], ana[N];
vector<int> ans;
unordered_map<int, int> ne[N];
bool ifs[N];

// Adds value to the corresponding run using the replacement selection algorithm
void add(int r, int run){
    if (v[run].size() <= k-1 && ifs[run]){
        v[run].push(r);
        ana[run].push(r);
    }
    else{
        ifs[run] = false;
        if (!v[run].empty()){
            int e = v[run].top(); v[run].pop();
            if (r < e) add(r, run+1);
            else {
                ana[run].push(r);
                v[run].push(r);
            }
        }
        else add(r, run+1); 
    }
    if (run > maxrun) maxrun = run;
}

int main(){
    cin >> n >> k;
    memset(ifs, true, sizeof(ifs));

    // Reading input values
    for (int i = 0; i < n; i++){
        int test;
        scanf("%d", &test);
        add(test, 1);
    }

    // Printing the sorted runs
    for (int i = 1; i <= maxrun; i++){
        vector<int> ans;
        while (!ana[i].empty()){
            int e = ana[i].top();
            ana[i].pop();
            ans.push_back(e);
        }
        printf("%d", ans[0]);
        for (int j = 1; j < ans.size(); j++){
            printf(" %d", ans[j]);
        }
        cout << endl;
    }
    return 0;
}

