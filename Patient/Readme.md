# Microservice : Gestion des Patients

Ce microservice gère les informations relatives aux patients dans une application médicale. Il fournit des fonctionnalités de création, modification, suppression et consultation des patients ainsi qu'une interaction avec les dossiers médicaux.

## Fonctionnalités principales

1. **Consultation de tous les patients** :
    - Endpoint : `GET /api/patients/all`
    - Retourne la liste complète des patients enregistrés.

2. **Consultation d'un patient par ID** :
    - Endpoint : `GET /api/patients/getPatient/{id}`
    - Retourne les détails d'un patient spécifique.

3. **Création d'un patient** :
    - Endpoint : `POST /api/patients/create`
    - Reçoit un objet patient dans le corps de la requête et ajoute ce patient à la liste en mémoire.

4. **Modification d'un patient** :
    - Endpoint : `PUT /api/patients/update/{id}`
    - Met à jour les informations d'un patient existant.

5. **Suppression d'un patient** :
    - Endpoint : `DELETE /api/patients/delete/{id}`
    - Supprime un patient en fonction de son ID.

6. **Vérification de l'existence d'un patient** :
    - Endpoint : `GET /api/patients/{id}`
    - Vérifie si un patient existe dans la liste.

7. **Récupération du dossier médical d'un patient** :
    - Endpoint : `GET /api/patients/getDossierMedicalFromPatient/{id}`
    - Retourne le dossier médical associé à un patient donné via un client distant.

## Structure du projet

### Modèles

- **Patient** :
  Représente les informations de base d'un patient :
    - `id` : Identifiant unique.
    - `name` : Nom de famille.
    - `firstName` : Prénom.
    - `email` : Adresse e-mail.
    - `phone` : Numéro de téléphone.
    - `address` : Adresse complète.

- **DossierMedical** :
  Représente un dossier médical associé à un patient :
    - `id` : Identifiant unique du dossier.
    - `idPatient` : Identifiant du patient associé.
    - `diagnostic` : Diagnostic médical.

### Contrôleur

- **PatientController** :
  Gère les endpoints pour les opérations CRUD et la communication avec le microservice des dossiers médicaux.

## Technologies utilisées

- **Framework** : Spring Boot
- **Langage** : Java
- **Communication interservices** : RestTemplate (ou client spécifique pour les dossiers médicaux)
## Exemple de requêtes avec Postman

### Création d'un patient

**Requête :**
```json
POST /api/patients/create
Body:
{
  "name": "Dupont",
  "firstName": "Jean",
  "email": "jean.dupont@example.com",
  "phone": "0123456789",
  "address": "123 Rue de Paris"
}
```

### Récupération de tous les patients

**Requête :**
```json
GET /api/patients/all
```

### Consultation d'un patient par ID

**Requête :**
```json
GET /api/patients/getPatient/1
```

### Modification d'un patient

**Requête :**
```json
PUT /api/patients/update/1
Body:
{
  "name": "Durand",
  "firstName": "Pierre",
  "email": "pierre.durand@example.com",
  "phone": "0987654321",
  "address": "456 Avenue des Champs"
}
```

### Suppression d'un patient

**Requête :**
```json
DELETE /api/patients/delete/1
```

### Vérification de l'existence d'un patient

**Requête :**
```json
GET /api/patients/1
```

### Récupération du dossier médical d'un patient

**Requête :**
```json
GET /api/patients/getDossierMedicalFromPatient/1

```

