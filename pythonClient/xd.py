from zeep import Client
print("Odpowiedź z serwera:", Client('http://localhost:8080/JavaSoap/HelloWorldImplService?WSDL').service.getHelloWorldAsString("Super działa. Python 2 linijki XD"))
