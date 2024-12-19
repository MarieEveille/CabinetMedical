# Microservice : Gateway

Ce microservice sert de point d'entrée unique pour l'ensemble des autres microservices (patients, praticiens, rendez-vous, dossiers médicaux). Il agit comme un proxy, permettant de router les requêtes vers le microservice approprié tout en centralisant la gestion des ports et des chemins d'accès.

Le Gateway tourne sur le port **8084**.

## Fonctionnement

### Objectif principal

Le Gateway simplifie les interactions entre le client et les microservices en fournissant une interface unique. Il :

- Route les requêtes vers le bon microservice en fonction de l'URL.
- Simplifie la gestion des services en masquant leurs ports spécifiques.
- Permet l'ajout futur de fonctionnalités comme l'authentification, la gestion des logs, ou la limitation du débit.

### Routage des requêtes

Les requêtes entrantes sur le port **8084** sont redirigées vers les microservices appropriés :

| Microservice          | Chemin d'accès du Gateway             | Port cible |
|-----------------------|----------------------------------------|------------|
| Patients              | `/api/patients/**`                   | 8080       |
| Praticiens            | `/api/praticiens/**`                 | 8081       |
| Rendez-vous          | `/api/rendezvous/**`                 | 8083       |
| Dossiers médicaux     | `/api/dossier-medical/**`            | 8082       |

### Exemple de configuration (application.yml)

```yaml
server:
  port: 8084

spring:
  cloud:
    gateway:
      routes:
        - id: patient-service
          uri: http://localhost:8080
          predicates:
            - Path=/api/patients/**

        - id: praticien-service
          uri: http://localhost:8081
          predicates:
            - Path=/api/praticiens/**

        - id: rendezvous-service
          uri: http://localhost:8083
          predicates:
            - Path=/api/rendezvous/**

        - id: dossier-medical-service
          uri: http://localhost:8082
          predicates:
            - Path=/api/dossier-medical/**
```



## Exemple de requêtes avec Postman

### Appel au microservice Patients

**Requête :**
```json
GET /api/patients/all
Headers:
  Content-Type: application/json
```
**Redirigé vers :** `http://localhost:8080/api/patients/all`

### Appel au microservice Praticiens

**Requête :**
```json
POST /api/praticiens/create
Headers:
  Content-Type: application/json
Body:
{
  "name": "Martin",
  "firstName": "Alice",
  "email": "alice.martin@example.com",
  "phone": "0123456789",
  "address": "10 Rue de Lyon"
}
```
**Redirigé vers :** `http://localhost:8081/api/praticiens/create`

### Appel au microservice Rendez-vous

**Requête :**
```json
GET /api/rendezvous/getRendezvous/1
Headers:
  Content-Type: application/json
```
**Redirigé vers :** `http://localhost:8083/api/rendezvous/getRendezvous/1`

### Appel au microservice Dossiers Médicaux

**Requête :**
```json
PUT /api/dossier-medical/update/1
Headers:
  Content-Type: application/json
Body:
{
  "id": 1,
  "idPatient": 1,
  "diagnostic": "Grippe"
}
```
**Redirigé vers :** `http://localhost:8082/api/dossier-medical/update/1`

