#include<iostream>
#include<set>
using namespace std;

int min (int arr[],int n)
{
    int ans=10;
    for (int i =0;i<n;i++)
    if (arr[i]<ans)
    ans=arr[i];
    return ans;
}

int max (int arr[],int n)
{
    int ans=0;
    for (int i =0;i<n;i++)
    if (arr[i]>ans)
    ans=arr[i];
    return ans;
}

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int arr[n];
        for (int i =0;i<n;i++)
        cin>>arr[i];

        float arr2[n][n];
        for (int i=0;i<n;i++)
            arr2[i][i]=-1;

        for (int i=0;i<n-1;i++)
            for(int j =i+1;j<n;j++)
            {
                if ((arr[i]-arr[j])>0)
                {
                    arr2[i][j]=float(j-i)/(arr[i]-arr[j]);
                }
                else
                {
                    arr2[i][j]=-1;
                }
            }
        for (int i=0;i<n-1;i++)
            for(int j =i+1;j<n;j++)
            arr2[j][i]=arr2[i][j];

        int affected[n];
        
        for (int i=0;i<n;i++)
        {
            set <int> s1;
            s1.insert(i);
            for (int j=0;j<n;j++)
            {
                if (arr2[i][j]>0)
                {
                    s1.insert(j);
                    for (int k=0;k<n;k++)
                    {
                        if (arr2[k][j]>arr2[i][j])
                        s1.insert(k);
                    }
                }
            }
            affected[i]=s1.size();
        }
        cout<<min(affected,n)<<" "<<max(affected,n)<<endl;
    }
}