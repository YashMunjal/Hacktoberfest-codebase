#include<iostream>
#include<math.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--)
    {
        long long int n;
        cin>>n;
        long long int ans=0;
        
        if ((n%4==0) || ((n+1)%4==0))
        {
            long long int sum=n*(n+1)/4;
            long long int k = floor((sqrt(1+8*sum)-1)/2);
            long long int sum2=k*(k+1)/2;

            if (sum==sum2)
            {
                ans+=sum2-k;
                ans+=(n-k)*(n-k-1)/2;
            }
            ans+=n-k;
        }
        cout<<ans<<"\n";
    }
    return 0;
}
