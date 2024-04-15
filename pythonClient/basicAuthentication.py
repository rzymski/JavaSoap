from zeep import Client
from requests.auth import HTTPBasicAuth

# URL of the WSDL file
wsdl_url = 'http://localhost:8080/JavaSoap/HelloWorldImplService?wsdl'

# Create a Zeep client
client = Client(wsdl=wsdl_url)

# Set up basic authentication credentials
username = 'admin'
password = 'admin'
auth = HTTPBasicAuth(username, password)

# Add the authentication to the Zeep transport
client.transport.session.auth = auth

try:
    # Call the SOAP method directly
    zapytanie = "wiadomosc klienta"
    response = client.service.getHelloWorldAsString(zapytanie)
    print("Klient wysłał:", zapytanie)
    print("Klient otrzymał:", response)
except Exception as e:
    print("An error occurred:", e)


