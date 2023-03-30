// This program checks if a binary tree is a valid binary tree by checking its preorder and postorder traversal.
// The binary tree is constructed from the given preorder and postorder traversal.
// It also checks if the binary tree is identical to the given inorder traversal.
// If the binary tree is not valid, it prints an error message.
// If the binary tree is valid, it checks if it is identical to the given postorder traversal.
// If it is identical, it prints "Yes", otherwise it prints "No".
#include<cstring>
#include<algorithm>
#include<iostream>

using namespace std;

const int  N=50;
int pre[N],post[N],in[N],a[N],book[N];
int cnt; 
int flag=true;
bool flag1=true;
int n;

void build(int il,int ir,int pl,int pr){
	// This function constructs a binary tree from its preorder and postorder traversal.
	if(pl>n||pr>n){return ;}
	int root=pre[pl];
    int t=book[pre[pl]];
    if(il<t)build(il,t-1,pl+1,(t-il-1)+pl+1);
    if(t<ir)build(t+1,ir,pr-(ir-t-1),pr);
    a[cnt++]=in[t];
    return;
}
void judge(int pl,int pr,int pol,int por){
	// This function checks if the binary tree is a valid binary tree.
	if(pl>pr) return;
	if(pl==pr) return;
	if(por<0||pol<0||pr<0||pl<0) return;
	if(pre[pl]!=post[por]) flag=false;
	int i=pl;
	while(pre[i]!=post[por-1]&&i<=pr)i++;
    if(i>pr){
			flag=false;
			return ;
    }
	judge(pl+1,i-1,pol,pol+(i-1-(pl+1)));
	judge(i,pr,por-1-(pr-i),por-1);
	return ;
}
void judge2(int il,int ir,int pl,int pr){
	// This function checks if the binary tree is identical to the given inorder 
	if(pl>pr) return;
	if(ir<0||il<0||pr<0||pl<0) return;
	int root=pre[pl];
	int i=pl;
	int t=il;
	while(pre[pl]!=in[t]){
		t++;
		if(t>ir){
			flag1=false;
			return ;
		} 
	}
    judge2(il,t-1,pl+1,(t-il-1)+pl+1);
    judge2(t+1,ir,pr-(ir-t-1),pr);
    a[cnt++]=root;
	return ;
}
int main(){
     cin>>n;
    for(int i=0;i<n;i++){
        cin>>pre[i];
    }
    for(int i=0;i<n;i++){
        cin>>post[i];
    }
       judge(0,n-1,0,n-1);
    int k;
    cin>>k;
    if(!flag){
    	printf("Are you kidding me?\n");
		for(int i=0;i<k;i++){
    		cnt=0;
    		memset(a,0,sizeof(a));
       		flag=true;
        	for(int i=0;i<n;i++){
        	     cin>>in[i];
        	     book[in[i]]=i;
        	}
        	flag1=true;
        	judge2(0,n-1,0,n-1);
        	if(flag1==false)printf("You must be kidding me!\n");
        	else{
        		printf("%d",a[0]);
        		for(int i=1;i<n;i++) printf(" %d",a[i]);
        		printf("\n");
			}
		}
	}
    
	else{
		    for(int i=0;i<k;i++){
    		 cnt=0;
    		 memset(a,0,sizeof(a));
       		  bool flag=true;
        	 for(int i=0;i<n;i++){
        	     cin>>in[i];
        	     book[in[i]]=i; 
        	 }
        	build(0,n-1,0,n-1);
        	for(int i=0;i<n;i++){
        	        if(a[i]!=post[i]){
        	            flag=false;
        	             break;
            	    }
        	 }
    	    if(flag) printf("Yes\n");
    	    else printf("No\n");
    		}
	}
    return 0;
}

