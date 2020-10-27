t=int(input())
for a in range(t):
  n,m=input().split()
  n=int(n)
  m=int(m)
  row_start=0
  column_start=0  
  if int(n)>0 and int(m)>0:
    li=[[int(x) for x in input().split()] for i in range(n)]
    for row in range((n//2)+1):
        row_start+=1
        for col in range(row_start-1,m):
            print(li[row][col], end=' ')    
        n=n-1
        for ele in range(row_start,n+1):
            print(li[ele][col],end=' ')  
        m-=1    
        for ele in range(m-1,column_start-1,-1):
            print(li[n][ele],end=' ')
        for ele in range(n-1,row_start-1,-1):
           print(li[ele][column_start],end=' ')
        column_start+=1
  print()
