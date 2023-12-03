## QuoteRetriever Documentation
Micronaut service to retrieve quotes from a mongoDB database.

# Installation
For running this service in your localhost, you will need to install:
- Docker
- Maven
- MongoDB Compass

1. Once you have installed the previous tools, you will need Docker for pulling the mongo image running:
   `docker pull mongo`
   Starting the container can be done either through Docker Desktop or using:
   `docker run -d -p 27017:27017 --name mongodb mongo`
   You can, of course, customize the ports to use and name of the container if desired.
2. Please make sure to configure the application.properties file of the project with your mongodb.uri.
   `i.e.: mongodb.uri=mongodb://localhost:27017/quotes`
3. Finally, you can run the application and start testing the endpoints using any desired HTTP client. There's a ready postman collection you can access to through the following link:
   [https://elements.getpostman.com/redirect?entityId=31544508-3cb0be29-7232-45e7-a97e-729031adaf73&entityType=collection](https://elements.getpostman.com/redirect?entityId=31544508-3cb0be29-7232-45e7-a97e-729031adaf73&entityType=collection)

## Micronaut 4.2.0 Documentation

- [User Guide](https://docs.micronaut.io/4.2.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.2.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.2.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature mongo-sync documentation

- [Micronaut MongoDB Synchronous Driver documentation](https://micronaut-projects.github.io/micronaut-mongodb/latest/guide/index.html)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature data-mongodb documentation

- [Micronaut Data MongoDB documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/#mongo)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature mongo-reactive documentation

- [Micronaut MongoDB Reactive Driver documentation](https://micronaut-projects.github.io/micronaut-mongodb/latest/guide/index.html)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature ksp documentation

- [Micronaut Kotlin Symbol Processing (KSP) documentation](https://docs.micronaut.io/latest/guide/#kotlin)

- [https://kotlinlang.org/docs/ksp-overview.html](https://kotlinlang.org/docs/ksp-overview.html)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


