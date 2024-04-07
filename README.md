___
**Zalecane wersje Java 8, Glassfish 4.1, SoapUi-4.6.4**
___
# JavaSoap
W cz1 znajdują się zadania z JAXWS.pdf oraz 2 zadanie z JAXWScz2.pdf w folderze lavasoft  
W cz2 znajdują się zadania z JAXWScz2.pdf (z wyjątkime 2)  
W cz3 znajdują się zadania z JAXWScz3.pdf

W cz2 w celu wdrożenia aplikacji na serwer glassfish wykorzystano Inteliji premium.  
Integracja z Maven:
 - Kliknięcie prawym na nazwę projektu -> Add Framework support -> Maven -> ok  
![Alt text](screens/addMaven.jpg?raw=true "Add Maven")

Po utworzeniu pliku pom.xml z &lt;packaging&gt;war&lt;/packaging&gt;:
 - Maven -> Lifecycle -> clean i potem package  
![Alt text](screens/mavenLifecycle.jpg?raw=true "Maven Lifecycle")  

Stworzenie konfiguracji glassfisha:
 - Edit Configurations -> + -> Glassfish Server Local  
   ![Alt text](screens/editConfiguration.jpg?raw=true "Konfiguracja cz.1")  
   ![Alt text](screens/editConfiguration2.jpg?raw=true "Konfiguracja cz.2")  
   Następnie proponowana konfiguracja:
   - JRE 1.8
   - Application server: GlassFish 4.1.0
   - Server Domain: domain1
   - Username: admin
   - Deployment -> + -> External Source i wybieramy z target/JavaSoap.war albo artifact JavaSoap:war -> ok -> Run  
  ![Alt text](screens/editConfiguration3.jpg?raw=true "Konfiguracja cz.3")  
  ![Alt text](screens/editConfiguration4.jpg?raw=true "Konfiguracja cz.4")


Część 1
======  
W części 1 WSDL:
- http://localhost:9999/ws/hello?WSDL

Wynik zadania 5 w cz.1  
![Alt text](screens/tcpMonitor.jpg?raw=true "Wynik zad 5 z cz.1")  


Część 2
======
W części 2 można sprawdzić działanie serwera w:
- http://localhost:8080/JavaSoap/HelloWorldImplService  

WSDL:
- http://localhost:8080/JavaSoap/HelloWorldImplService?WSDL

Tester Glassfisha:
- http://localhost:8080/JavaSoap/HelloWorldImplService?Tester

Przy włączonym serwerze można sprawdzić działanie klienta w pythonie znajdującego się w pythonClient.

Wynik zadania 1 w cz.2  
![Alt text](screens/cz2zad1Wynik.png?raw=true "Wynik zad 1 z cz.2")

Wynik zadania 2 w cz.2  
![Alt text](screens/cz2zad2Wynik.png?raw=true "Wynik zad 2 z cz.2")

Konfiguracja zadania 3 w cz.2  
![Alt text](screens/cz2zad3Konfiguracja1.jpg?raw=true "Konfiguracja1 zad 3 z cz.2")  
![Alt text](screens/cz2zad3Konfiguracja2.png?raw=true "Konfiguracja2 zad 3 z cz.2")  
Wynik zadania 3 w cz.2  
![Alt text](screens/cz2zad3Wynik.png?raw=true "Wynik zad 3 z cz.2")  

Wynik zadania 6 w cz.2  
![Alt text](screens/cz2zad6Wynik.png?raw=true "Wynik zad 6 z cz.2")


Część 3
======
W części 3 WSDL:
- http://localhost:9999/ws/server?WSDL

Wyniki zadań w cz.3
![Alt text](screens/cz3zadaniaWynik.png?raw=true "Wynik wszystkich zadań z części 3")  
Wyniki zadań w cz.3 w SoapUi  
![Alt text](screens/cz3zadaniaWynikSoapUi.png?raw=true "Wynik wszystkich zadań z części 3")  

Konfiguracja HTTP monitora:  
![Alt text](screens/cz3MonitorKonfiguracja1.jpg?raw=true "Konfiguracja monitora Http1")
![Alt text](screens/cz3MonitorKonfiguracja2.png?raw=true "Konfiguracja monitora Http2")  

W celu sprawdzenia działania programu przez SoapUi w programie też trzeba zmienić port  
&ensp;Przykładowo w **WebServiceClient2.java** trzeba wybrać w 21-22 linijce docelowy port:  
&emsp;private static final String WS_URL = "http://localhost:9999/ws/server"; // jeśli nie używamy SoaupUi  
&emsp;private static final String WS_URL = "http://localhost:8080/ws/server"; // przy użyciu SoapUi httpMonitor tunnel ustawionym na porcie 8080  

Działanie HTTP monitora:
![Alt text](screens/cz3Monitor.png?raw=true "Konfiguracja monitora Http1")  
