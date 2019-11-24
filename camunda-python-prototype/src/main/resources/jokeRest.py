import requests
import json
import time

#Define API Endpoint
url = 'http://api.icndb.com/jokes/random'
data= '{}'

# Define Json

# Connect to the API (Fetch and Lock)
try:
    res = requests.get(url, json=data)
    print(res.status_code)

    #Get Body Text
    body = res.text    
    print(body)
except:
    print('joke not response')
            

