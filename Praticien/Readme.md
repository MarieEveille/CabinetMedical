# Microservice : Gestion des Praticiens

Ce microservice gère les informations relatives aux praticiens dans une application médicale. Il fournit des fonctionnalités de création, modification, suppression et consultation des praticiens ainsi qu'une interaction avec les dossiers médicaux des patients.

## Fonctionnalités principales

1. **Consultation de tous les praticiens** :
   - Endpoint : `GET /api/praticiens/all`
   - Retourne la liste complète des praticiens enregistrés.

2. **Consultation d'un praticien par ID** :
   - Endpoint : `GET /api/praticiens/getPraticien/{id}`
   - Retourne les détails d'un praticien spécifique.

3. **Création d'un praticien** :
   - Endpoint : `POST /api/praticiens/create`
   - Reçoit un objet praticien dans le corps de la requête et ajoute ce praticien à la liste en mémoire.

4. **Modification d'un praticien** :
   - Endpoint : `PUT /api/praticiens/update/{id}`
   - Met à jour les informations d'un praticien existant.

5. **Suppression d'un praticien** :
   - Endpoint : `DELETE /api/praticiens/delete/{id}`
   - Supprime un praticien en fonction de son ID.

6. **Vérification de l'existence d'un praticien** :
   - Endpoint : `GET /api/praticiens/{id}`
   - Vérifie si un praticien existe dans la liste.

7. **Récupération du dossier médical d'un praticien** :
   - Endpoint : `GET /api/praticiens/getDossierMedicalFromPraticien/{id}`
   - Retourne le dossier médical associé à un praticien donné via un client distant.

8. **Récupération d'un dossier médical pour un patient** :
   - Endpoint : `GET /api/praticiens/getDossierForPatient/{id}`
   - Retourne le dossier médical associé à un patient donné.

9. **Création d'un dossier médical pour un patient** :
   - Endpoint : `POST /api/praticiens/createDossierForPatient/{id}/{diagnostic}`
   - Crée un dossier médical pour un patient donné avec le diagnostic spécifié.

10. **Mise à jour d'un dossier médical pour un patient** :
    - Endpoint : `PUT /api/praticiens/updateDossierForPatient/{id}`
    - Met à jour le dossier médical d'un patient existant.

## Structure du projet

### Modèles

- **Praticien** :
  Représente les informations de base d'un praticien :
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

- **PraticienController** :
  Gère les endpoints pour les opérations CRUD sur les praticiens ainsi que les interactions avec les dossiers médicaux.

## Technologies utilisées

- **Framework** : Spring Boot
- **Langage** : Java
- **Communication interservices** : RestTemplate (ou client spécifique pour les dossiers médicaux)

## Exemple de requêtes avec Postman

### Création d'un praticien

**Requête :**
```json
POST /api/praticiens/create

Body:
{
  "name": "Martin",
  "firstName": "Alice",
  "email": "alice.martin@example.com",
  "phone": "0123456789",
  "address": "10 Rue de Lyon"
}
```

### Consultation de tous les praticiens

**Requête :**
```json
GET /api/praticiens/all
```

### Consultation d'un praticien par ID

**Requête :**
```json
GET /api/praticiens/getPraticien/1
```

### Modification d'un praticien

**Requête :**
```json
PUT /api/praticiens/update/1

Body:
{
  "name": "Durand",
  "firstName": "Paul",
  "email": "paul.durand@example.com",
  "phone": "0987654321",
  "address": "20 Avenue des Champs"
}
```

### Suppression d'un praticien

**Requête :**
```json
DELETE /api/praticiens/delete/1
```

### Récupération d'un dossier médical pour un praticien

**Requête :**
```json
GET /api/praticiens/getDossierMedicalFromPraticien/1
```

### Création d'un dossier médical pour un patient

**Requête :**
```json
POST /api/praticiens/createDossierForPatient/1/Toux
```

### Mise à jour d'un dossier médical pour un patient

**Requête :**
```json
PUT /api/praticiens/updateDossierForPatient/1

Body:
{
  "id": 1,
  "idPatient": 1,
  "diagnostic": "Grippe"
}
```
