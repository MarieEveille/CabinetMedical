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

## Enregistrement d'un microservice auprès d'Eureka

Les microservices clients doivent être configurés pour s'enregistrer auprès du serveur Eureka.


## Interface Web d'Eureka

- **URL d'accès** : `http://localhost:8761`
- L'interface affiche :
  - Les services enregistrés
  - Les instances disponibles
  - Les statuts de santé des services




