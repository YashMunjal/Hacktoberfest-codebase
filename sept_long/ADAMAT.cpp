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
        int arr[n][n];
        for (int i=0;i<n;i++)
        for (int j=0;j<n;j++)
        cin>>arr[i][j];

        bool arr1[n][n];
        for (int i=0;i<n;i++)
        for (int j=0;j<n;j++)
        arr1[i][j]= i*n+j+1==arr[i][j];        
        bool arr2[n-1];
        for (int i=1;i<n;i++)
        arr2[i-1]=arr1[i][0];

        int j=0;
        for (int i=n-2;i>=0;i--)
        {
            if(arr2[i]==true)
            continue;
            else
            {
                j=i;
                break;
            }
        }
        
        if (j==0 and arr2[j]==true)
        {
            cout<<j<<endl;
            continue;        
        }
        else
        {
            int count=1;
            bool chk=false;
            for (int i=j-1;i>=0;i--)
            {
                if (arr2[i]==chk)
                continue;
                else
                {
                    count++;
                    chk=arr2[i];
                }
            }
            cout<<count<<endl;
        }
    }
}