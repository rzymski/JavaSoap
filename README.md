___
**Zalecane wersje Java 8, Glassfish 4.1, SoapUi-4.6.4**
___
# JavaSoap
W cz1 znajdują się zadania z JAXWS.pdf oraz 2 zadanie z JAXWScz2.pdf w folderze lavasoft  
W cz2 znajdują się zadania z JAXWScz2.pdf (z wyjątkime 2)  

W cz2 w celu wdrożenia aplikacji na serwer glassfish wykorzystano Inteliji premium.  
Integracja z Maven:
 - Kliknięcie prawym na nazwę projektu -> Add Framework support -> Maven -> ok

Po utworzeniu pliku pom.xml z <packaging>war</packaging>:
 - Maven -> Lifecycle -> clean i potem package

Stworzenie konfiguracji glassfisha:
 - Edit Configurations -> + -> Glassfish Server Local
 - JRE 1.8
 - Application server: GlassFish 4.1.0
 - Server Domain: domain1
 - Username: admin
 - Deployment -> + -> External Source i wybieramy z target/JavaSoap.war albo artifact JavaSoap:war -> ok -> Run

Można sprawdzić działanie serwera w:
- http://localhost:8080/JavaSoap/HelloWorldImplService

WSDL:
- http://localhost:8080/JavaSoap/HelloWorldImplService?WSDL

Tester Glassfisha:
- http://localhost:8080/JavaSoap/HelloWorldImplService?Tester

