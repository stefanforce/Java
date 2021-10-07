import urllib
from urllib import request
from urllib import parse
import requests

query = {'key': '45', 'value': '30', 'mock': 'false', 'sync': 'true'}
querystring = parse.urlencode(query)
url= "http://localhost:8080/Lab1/hello" + "?" + querystring
response = request.urlopen(url)
data = response.read()
html=data.decode("UTF-8")
print(html)
