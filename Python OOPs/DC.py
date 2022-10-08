# Libraries used PIL,requests and BytesIO
from PIL import Image
import requests
from io import BytesIO


url = 'https://media-exp1.licdn.com/dms/image/C5603AQG1d1snFnWIyg/profile-displayphoto-shrink_400_400/0/1609605095020?e=1670457600&v=beta&t=3Zi5jBlkvhChbTUFUaq6wPOT4jVwRmedUA3ZRtl88VA'
response = requests.get(url) # use any url having your image
img = Image.open(BytesIO(response.content))

print(img )
# write img only if you are using it in a python notebook.
