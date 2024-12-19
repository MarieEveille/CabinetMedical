# Microservice : Eureka Server

Ce microservice agit comme un serveur de registre Eureka, permettant aux autres microservices de s'enregistrer dynamiquement et de découvrir les services disponibles dans une architecture basée sur les microservices. Cela facilite la communication et l'équilibrage de charge.

Le service Eureka tourne sur le port **8761** par défaut.

## Fonctionnalités principales

1. **Enregistrement des services** :
   - Les microservices (patients, praticiens, rendez-vous, dossiers médicaux, gateway) s'enregistrent automatiquement auprès du serveur Eureka.

2. **Découverte des services** :
   - Les microservices peuvent utiliser Eureka pour découvrir d'autres services enregistrés en fonction de leur nom.

3. **Monitoring** :
   - L'interface web d'Eureka permet de visualiser l'état des services enregistrés (nom, statut, instances).

## Configuration du serveur Eureka

### Exemple de configuration (application.yml)

```yaml
server:
  port: 8761

spring:
  application:
    name: eureka-server
  cloud:
    netflix:
      eureka:
        server:
          enable-self-preservation: false
        client:
          register-with-eureka: false
          fetch-registry: false

eureka:
  instance:
    hostname: localhost
```

### Ajout de dépendances Maven

Assurez-vous que les dépendances nécessaires sont incluses dans le fichier `pom.xml` :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

### Annotation principale

Ajoutez l'annotation `@EnableEurekaServer` dans la classe principale du projet :

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

## Enregistrement d'un microservice auprès d'Eureka

Les microservices clients doivent être configurés pour s'enregistrer auprès du serveur Eureka. Exemple de configuration dans le fichier `application.yml` d'un microservice client :

```yaml
spring:
  application:
    name: patient-service

server:
  port: 8081

# Configuration Eureka
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```

Ajoutez la dépendance suivante dans le `pom.xml` du client :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

Ajoutez l'annotation `@EnableEurekaClient` ou `@EnableDiscoveryClient` dans la classe principale du client.

## Interface Web d'Eureka

- **URL d'accès** : `http://localhost:8761`
- L'interface affiche :
  - Les services enregistrés
  - Les instances disponibles
  - Les statuts de santé des services

## Installation

1. Clonez le dépôt :
   ```bash
   git clone <url-du-repo>
   ```
2. Naviguez dans le dossier du projet :
   ```bash
   cd eureka-server
   ```
3. Assurez-vous d'avoir Java 17 ou une version compatible.
4. Lancez l'application avec :
   ```bash
   ./mvnw spring-boot:run
   ```

## Contributions

Les contributions sont les bienvenues ! Merci de soumettre une pull request ou d'ouvrir une issue si vous rencontrez un problème.

## Licence

Ce projet est sous licence [MIT](LICENSE).
