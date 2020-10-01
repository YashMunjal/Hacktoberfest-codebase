API_key ="" # get api key here

from googleapiclient.discovery import build
import json
import csv

service = build('youtube', 'v3', developerKey=API_key)
requst=service.commentThreads().list(
    part='snippet',
    videoId='Iot0eF6EoNA',
    order='relevance',
    maxResults=100
)
response=requst.execute()
# print(type(response))
# info=json.dumps(response["items"],indent="  ")
data=response["items"]
# print(type(data))


comnts=[]
for i in data:
    author=i['snippet']["topLevelComment"]['snippet']["authorDisplayName"]
    cmt=i['snippet']["topLevelComment"]['snippet']["textOriginal"]
    likes=i['snippet']["topLevelComment"]['snippet']["likeCount"]
    publish_time=i['snippet']["topLevelComment"]['snippet']["publishedAt"]
    edit_time=i['snippet']["topLevelComment"]['snippet']["updatedAt"]
    edit_Status=publish_time==edit_time
    replies=i['snippet']["totalReplyCount"]
    reply_status=i['snippet']["canReply"]
    public_status=i['snippet']["isPublic"]
    comnts.append((author,cmt,likes,publish_time,edit_time,edit_Status,replies,reply_status,public_status))

while (len(comnts)<50000):
    if len(comnts)%500==0:
        print(len(comnts))
    requst=service.commentThreads().list_next(requst,response)

    try:
        response=requst.execute()
        data=response["items"]
    except:
        print("We are Done")
        break

    for i in data:
        author=i['snippet']["topLevelComment"]['snippet']["authorDisplayName"]
        cmt=i['snippet']["topLevelComment"]['snippet']["textOriginal"]
        likes=i['snippet']["topLevelComment"]['snippet']["likeCount"]
        publish_time=i['snippet']["topLevelComment"]['snippet']["publishedAt"]
        edit_time=i['snippet']["topLevelComment"]['snippet']["updatedAt"]
        edit_Status=publish_time!=edit_time
        replies=i['snippet']["totalReplyCount"]
        reply_status=i['snippet']["canReply"]
        public_status=i['snippet']["isPublic"]
        comnts.append((author,cmt,likes,publish_time,edit_time,edit_Status,replies,reply_status,public_status))

with open ('Comments.csv','w',encoding='utf-8-sig') as f:
    writer=csv.writer(f)
    writer.writerow(['Author','Comment','Likes','Publish_Time','Edit_Time','Edit_Status','Replies','Reply_Status','Public_Status'])
    writer.writerows(comnts)
    print("Done")
