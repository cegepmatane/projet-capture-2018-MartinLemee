from sense_hat import SenseHat
import urllib3 
import json
sense = SenseHat()
sense.clear()

temp = sense.get_temperature()

meteo = {'temperature':temp}
meteo = json.dumps(meteo).encode('utf-8');
#urllib3.request.urlopen('167.114.152.43:8080/CapteurTemperature/' + temp)

http = urllib3.PoolManager()
url = 'http://167.114.152.43:8080'
print(meteo)
response = http.request('POST', url, body=meteo, headers={'Content-Type' : 'application/json'})

