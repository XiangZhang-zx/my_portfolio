#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

const int N = 10100;

// data structure to store entry and exit times for a car
struct node {
    int eal[N];
    int lat[N];
    bool exi = false;
    int cnt = 0;
    int tot = 0;
};

// data structure to store input records
struct num {
    string id;
    int t;
    string type;
} record[N];

// map to keep track of car's existence and corresponding entry/exit times
unordered_map<string, bool> exi;
unordered_map<string, node> rec;

// set to keep track of all cars
unordered_set<string> car;

// function to fill up data structures with input data
void op() {
    for (int i = 0; i < n; i++) {
        string id = record[i].id, type = record[i].type;
        int t = record[i].t;
        int cnt = rec[id].cnt;

        if (type == "in") {
            if (exi[id] == true) {
                rec[id].eal[cnt] = t;
            } else {
                rec[id].eal[cnt] = t;
                exi[id] = true;
            }
        } else {
            if (exi[id] == true) {
                rec[id].lat[cnt] = t;
                rec[id].cnt++;
                exi[id] = false;
            }
        }
    }
}

// comparator function for sorting input records by time
bool cmp(num a, num b) {
    return a.t < b.t;
}

// comparator function for sorting car ids in alphabetical order
bool cmp2(string a, string b) {
    return a < b;
}

int main() {
    // Read input values
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        string id1, type;
        int h, m, s, t;
        cin >> id1;
        scanf("%d:%d:%d", &h, &m, &s);
        cin >> type;
        t = 3600 * h + 60 * m + s;
        car.insert(id1);
        record[i].id = id1;
        record[i].type = type;
        record[i].t = t;
    }

    // Sort the record array by time
    sort(record, record + n, cmp);

    // Perform operations on the record
    op();

    // Output the answers to the k queries
    for (int i = 0; i < k; i++) {
        string id1, type;
        int h, m, s;
        scanf("%d:%d:%d", &h, &m, &s);
        int t = 3600 * h + 60 * m + s;
        int ana = 0;
        for (auto &item : car) {
            auto &recar = rec[item];
            for (int j = 0; j < recar.cnt; j++) {
                if (recar.eal[j] <= t && recar.lat[j] >= t) ana++;
            }
        }
        cout << ana << endl;
    }

    // Calculate and store the total time parked for each car
    for (auto &item : car) {
        auto &recar = rec[item];
        for (int j = 0; j < recar.cnt; j++) {
            recar.tot += recar.lat[j] - recar.eal[j];
        }
    }

    // Find the car(s) with the longest total parking time
    vector<string> ans;
    int maxt = 0;
    for (auto &item : car) {
        auto &rcar = rec[item];
        if (rcar.tot > maxt) {
            maxt = rcar.tot;
            ans.clear();
            ans.push_back(item);
        } else if (rcar.tot == maxt) {
            ans.push_back(item);
        }
    }

    // Sort and output the car ID(s) with the longest total parking time and the time itself
    sort(ans.begin(), ans.end(), cmp2);
    cout << ans[0];
    for (int i = 1; i < ans.size(); i++)
        cout << " " << ans[i] << " ";
    printf("%02d:%02d:%02d", maxt / 3600, (maxt % 3600) / 60, maxt % 3600 % 60);

    return 0;
}

