from zeep import Client

# Adres URL usługi
url = 'http://localhost:8080/JavaSoap/HelloWorldImplService?WSDL'
# Tworzymy klienta SOAP
client = Client(url)

try:
    response = client.service.getHelloWorldAsString("Pizza")
    print("Odpowiedź z serwera:", response)
except Exception as e:
    print("Wystąpił błąd:", e)

try:
    response = client.service.getProducts()
    if response:
        print(response)
        print("Lista produktów:")
        for product in response:
            print("- Nazwa:", product['nazwa'])
            print("- Cena:", product['cena'])
            print("- Opis:", product['opis'])
            print()
    else:
        print("Brak produktów.")
except Exception as e:
    print("Wystąpił błąd:", e)
