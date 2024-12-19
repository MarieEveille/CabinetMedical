# Microservice : Gestion des Dossiers Médicaux

Ce microservice gère les dossiers médicaux des patients dans une application médicale. Il fournit des fonctionnalités pour créer, consulter, modifier et supprimer les dossiers médicaux.

## Fonctionnalités principales

1. **Consultation de tous les dossiers médicaux** :
   - Endpoint : `GET /api/dossier-medical/all`
   - Retourne la liste complète des dossiers médicaux enregistrés.

2. **Consultation d'un dossier médical par ID** :
   - Endpoint : `GET /api/dossier-medical/getDossierMedical/{id}`
   - Retourne les détails d'un dossier médical spécifique.

3. **Consultation d'un dossier médical par patient** :
   - Endpoint : `GET /api/dossier-medical/getDossierMedicalByPatient/{idPatient}`
   - Retourne le dossier médical associé à un patient donné.

4. **Création d'un dossier médical** :
   - Endpoint : `POST /api/dossier-medical/create/{idPatient}/{diagnostic}`
   - Crée un dossier médical pour un patient donné avec le diagnostic spécifié.

5. **Modification d'un dossier médical** :
   - Endpoint : `PUT /api/dossier-medical/update/{id}`
   - Met à jour les informations d'un dossier médical existant.

6. **Suppression d'un dossier médical** :
   - Endpoint : `DELETE /api/dossier-medical/delete/{id}`
   - Supprime un dossier médical en fonction de son ID.

## Structure du projet

### Modèles

- **DossierMedical** :
  Représente les informations relatives à un dossier médical :
  - `id` : Identifiant unique.
  - `idPatient` : Identifiant du patient associé.
  - `diagnostic` : Diagnostic médical associé au patient.

### Contrôleur

- **DossierMedicalController** :
  Gère les endpoints pour les opérations CRUD sur les dossiers médicaux et les consultations basées sur les patients.

## Technologies utilisées

- **Framework** : Spring Boot
- **Langage** : Java


## Exemple de requêtes avec Postman

### Création d'un dossier médical

**Requête :**
```json
POST /api/dossier-medical/create/1/Toux
```

### Consultation de tous les dossiers médicaux

**Requête :**
```json
GET /api/dossier-medical/all
```

### Consultation d'un dossier médical par ID

**Requête :**
```json
GET /api/dossier-medical/getDossierMedical/1
```

### Consultation d'un dossier médical par patient

**Requête :**
```json
GET /api/dossier-medical/getDossierMedicalByPatient/1
```

### Modification d'un dossier médical

**Requête :**
```json
PUT /api/dossier-medical/update/1

Body:
{
  "id": 1,
  "idPatient": 1,
  "diagnostic": "Grippe"
}
```

### Suppression d'un dossier médical

**Requête :**
```json
DELETE /api/dossier-medical/delete/1
```

