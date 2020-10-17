#include<iostream>
#include<bits/stdc++.h> 
using namespace std;
class tree{
    
}


int main(){
     int t;
    vector< vector<string>> dict;
    cout<<"For insert word in dict Press 1 \nFor search in dict Press 2\nFor Print all dict Press 3\nLetter starts with Press 4"<<endl;
    cin>>t;
	while(1){
        if(t == 1){
            insert_word(dict);
             sort(dict.begin(), dict.end());
        }
        else if(t == 2){
            search_word(dict);
        }
        else if(t == 3){
		cout<<endl;
            print_dict(dict);
        }
	else if(t == 4){
		print_ls(dict);
	}
	else{
		exit(0);
	}
	cout<<"\nFor insert word in dict Press 1 \nFor search in dict Press 2\nFor Print all dict Press 3\nLetter starts with Press 4"<<endl;
        cin>>t;
    }
}
