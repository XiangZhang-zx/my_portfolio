#include<cstring>
#include<algorithm>
#include<iostream>
#include<unordered_set>
using namespace std;
const int N=13,M=1010;
unordered_set<int> s; // set of numbers that have already been chosen
int ana[N]; // array of winning players
bool c[N]; // array indicating whether a player is still in the game
int ju[N][M]; // matrix of player numbers
int main(){
    memset(c,true,sizeof(c)); // set all players to still in the game
    int a,b,n,m;
    cin>>a>>b;
    s.insert(a);s.insert(b); // insert initial numbers into set of chosen numbers
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            scanf("%d",&ju[i][j]); // read player numbers
        }
    }
    for(int j=1;j<=m;j++){
        for(int i=1;i<=n;i++){
        	if(c[i]){ // if player is still in the game
                bool flag=false;int num=ju[i][j];
                if(s.count(num)) flag=false; // if number has already been chosen, player is out
                else for(auto item:s){
                    if(s.count(item+num)) {flag=true;break;} // if sum of two previously chosen numbers equals current number, player wins
                }
                if(!flag){
                	c[i]=false;
                    printf("Round #%d: %d is out.\n",j,i); // output that player is out
                }
                if(flag)s.insert(num); // add chosen number to set of chosen numbers
			}
        }
    }
    int cnt=0;
    bool suc=false;
    for(int i=1;i<=n;i++){
        if(c[i]){ // if player is still in the game
	        suc=true;
            ana[cnt++]=i; // add winning player number to array
        }
    }
    if(suc){
        cout<<"Winner(s):";
        for(int i=0;i<cnt;i++) cout<<" "<<ana[i]; // output winning player number(s)
    }
    else cout<<"No winner."; // output if there is no winner
    return 0;
}

