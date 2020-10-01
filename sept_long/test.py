t=int(input())
arr=[]
for i in range (21):
    arr.append(2**i)
    
while (t>0):
    t=t-1
    n=int(input())

    print(1," ",arr[20])
    sum=int(input())
    sum=sum-arr[20]*n
    ans=0

    # if (sum%2!=0):
    #     ans+=1

    for i in range(1,20):
        sum2=sum+arr[i]*n
        print(1," ",arr[i])
        sum3=int(input())
        if (((sum2-sum3)/(arr[i]*2))%2!=0):
            ans+=arr[i]

    print(2," ",ans,"\n")
    result=int(input())
