#include<iostream>
#include<set>
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;

        long long int arr[n];
        for (int i =0;i<n;i++)
        cin>>arr[i];

        set<long long int> s1;
        for (int i =0;i<n;i++)
        s1.insert(arr[i]);

        if (s1.find(0)!=s1.end())
        cout<<s1.size()-1<<endl;
        else
        {
         cout<<s1.size()<<endl;   
        }
                
    }
}