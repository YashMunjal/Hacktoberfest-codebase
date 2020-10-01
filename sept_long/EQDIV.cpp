#include<iostream>
#include<math.h>
using namespace std;
void swap (int &a,int &b)
{
    a=a+b;
    b=a-b;
    a=a-b;
}
bool check (int arr[],int n,int diff)
{
    long long int sum1=0;
    long long int sum0=0;
    for (int i=0;i<n;i++)
    {
        if (arr[i]==1)
        sum1+=i+1;
        else
        sum0+=i+1;
    }

        if (diff==abs(sum0-sum1))
        return true;
        else
        return false;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t,k;
    cin>>k;
    cin>>t;
    while(t--)
    {
        long long int n;
        cin>>n; 
        long long int sum=n*(n+1)/4;
        long long int l = floor((sqrt(1+8*sum)-1)/2);
        long long int suml=l*(l+1)/2;

        int diff;
        if ((n%4==0)||((n+1)%4==0))
        diff=0;
        else
        diff=1;

        int arr[n];
        for (int i=0;i<l;i++)
        arr[i]=1;
        for (int i=l;i<n;i++)
        arr[i]=0;

        int t=sum-suml;
        if (t>0)
        swap(arr[l],arr[l-t]);

        cout<<diff<<"\n";
        for (int i=0;i<n;i++)
        cout<<arr[i];
        cout<<"\n";
    }
    return 0;
}
