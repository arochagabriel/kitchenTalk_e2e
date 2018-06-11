# KitchenTalk! 
by. Gabriel Arocha


Este proyecto tiene como finalidad mostrar el framework que uso actualmente para realizar pruebas funcionales automatizadas a nivel web.


# Ingredientes a utilizar!

  - [Selenium](https://www.seleniumhq.org/)
  - [Cucumber](https://cucumber.io/)
  - Hamcrest/Junit
  - [Docker](https://www.docker.com/what-docker)
  - Gradle
  - Java
  - VNC 

# Preparación
1) Descargar e instalar [Docker](https://docs.docker.com/install/) de acuerdo a tu S.O 
2) Instalar [Gradle](https://gradle.org/install/) y [VNC](https://www.realvnc.com/es/connect/download/viewer/)
3) Usaremos Selenium GRID para estar familiarizado en ambientes CI/CD con un tipo de arquitectura escalable, mantenible, multibrowser. Descargamos las imagenes:

### [Selenium HUB](https://github.com/SeleniumHQ/docker-selenium/tree/master/Hub)
```sh
$ docker run -d -p 4444:4444 --name selenium-hub selenium/hub
```
Para validar que nuesto HUB esta arriba, podemos acceder a la siguiente url http://127.0.0.1:4444
### [Selenium Node-Chrome/debug](https://github.com/SeleniumHQ/docker-selenium/tree/master/NodeChromeDebug)
Este nodo nos permitirá conectarnos mediante VNC (debes instalarlo, la clave por defecto es "secret"), para visualizar la repodruccion de nuestras pruebas. Para ambientes de produccion NO es recomendable.
```sh
$ docker run -d -p 5900:5900 --link selenium-hub:hub --name chrome -v /dev/shm:/dev/shm selenium/node-chrome-debug
```
4) Ejecutamos nuestras pruebas situandonos en nuestro proyecto, y para ejecutarlo de forma secuencial escribimos
```sh
$ gradle clean build runInSequence
```
Si deseamos correrlo en paralelo escribimos (debes tener añadido dos o mas nodos)
```sh
$ gradle clean build runInParallel
```
Happy Testing!


