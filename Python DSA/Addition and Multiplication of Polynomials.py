def orangecap(d):
    topscore=0
    playername=""
    unidict={}
    for i in d.values():
        for j in i:
            if j not in unidict:
                unidict[j]=i[j]
            else:
                unidict[j]+=i[j]
    for i in unidict:
        if(unidict[i]>topscore):
            topscore=unidict[i]
            playername=i
    return(playername,topscore) 

def addpoly(p1,p2):
   d1={}
   d2={}
   d3={}
   returnlist=[]
   for i in p1:
       d1[i[1]]=i[0]
   for i in p2:
       d2[i[1]]=i[0]
   for i in d1.keys():
       if i in d2.keys():
           d3[i]=d1[i]+d2[i]
       else:
           d3[i]=d1[i]
   for i in d2.keys():
       if i not in d1.keys():
           d3[i]=d2[i]    
   loopend=max(d3.keys())
   for i in range(loopend,-1,-1):
       if i in d3.keys():
          if(d3[i]!=0):
            returnlist.append((d3[i],i))
   return returnlist   
def multpoly(p1,p2):
   d1={}
   d2={}
   d3={}
   returnlist=[]
   for i in p1:
       d1[i[1]]=i[0]
   for i in p2:
       d2[i[1]]=i[0]
   try:     
     for i in d1.keys():
         for j in d2.keys():
             t1=i+j
             t2=d1[i]*d2[j]
             if t1 not in d3:
                 d3[t1]=t2
             else:
                 d3[t1]+=t2
               
     loopend=max(d3.keys())
     for i in range(loopend,-1,-1):
         if i in d3.keys():
            if(d3[i]!=0):
              returnlist.append((d3[i],i))
   except:
    pass
   return returnlist 