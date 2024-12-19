# Microservice : Gestion des Rendez-vous

Ce microservice gère les rendez-vous entre patients et praticiens dans une application médicale. Il fournit des fonctionnalités pour créer, modifier, supprimer et consulter les rendez-vous.

## Fonctionnalités principales

1. **Consultation de tous les rendez-vous** :
   - Endpoint : `GET /api/rendezvous/all`
   - Retourne la liste complète des rendez-vous enregistrés.

2. **Consultation d'un rendez-vous par ID** :
   - Endpoint : `GET /api/rendezvous/getRendezvous/{id}`
   - Retourne les détails d'un rendez-vous spécifique.

3. **Consultation des rendez-vous par patient** :
   - Endpoint : `GET /api/rendezvous/getRendezvousByPatient/{idPatient}`
   - Retourne la liste des rendez-vous associés à un patient donné.

4. **Consultation des rendez-vous par praticien** :
   - Endpoint : `GET /api/rendezvous/getRendezvousByPraticien/{idPraticien}`
   - Retourne la liste des rendez-vous associés à un praticien donné.

5. **Création d'un rendez-vous** :
   - Endpoint : `POST /api/rendezvous/create`
   - Reçoit un objet rendez-vous dans le corps de la requête et l'ajoute à la liste en mémoire.

6. **Modification d'un rendez-vous** :
   - Endpoint : `PUT /api/rendezvous/update/{id}`
   - Met à jour les informations d'un rendez-vous existant.

7. **Suppression d'un rendez-vous** :
   - Endpoint : `DELETE /api/rendezvous/delete/{id}`
   - Supprime un rendez-vous en fonction de son ID.

## Structure du projet

### Modèles

- **Rendezvous** :
  Représente les informations relatives à un rendez-vous :
  - `id` : Identifiant unique.
  - `idPatient` : Identifiant du patient associé.
  - `idPraticien` : Identifiant du praticien associé.
  - `dateHeure` : Date et heure du rendez-vous.

### Contrôleur

- **RendezvousController** :
  Gère les endpoints pour les opérations CRUD sur les rendez-vous et les consultations basées sur les patients ou praticiens.

## Technologies utilisées

- **Framework** : Spring Boot
- **Langage** : Java


## Exemple de requêtes avec Postman

### Création d'un rendez-vous

**Requête :**
```json
POST /api/rendezvous/create

Body:
{
  "idPatient": 1,
  "idPraticien": 2,
  "dateHeure": "2024-12-20T15:30:00"
}
```

### Consultation de tous les rendez-vous

**Requête :**
```json
GET /api/rendezvous/all

```

### Consultation d'un rendez-vous par ID

**Requête :**
```json
GET /api/rendezvous/getRendezvous/1

```

### Consultation des rendez-vous par patient

**Requête :**
```json
GET /api/rendezvous/getRendezvousByPatient/1

```

### Consultation des rendez-vous par praticien

**Requête :**
```json
GET /api/rendezvous/getRendezvousByPraticien/2

```

### Modification d'un rendez-vous

**Requête :**
```json
PUT /api/rendezvous/update/1

Body:
{
  "idPatient": 1,
  "idPraticien": 3,
  "dateHeure": "2024-12-21T10:00:00"
}
```

### Suppression d'un rendez-vous

**Requête :**
```json
DELETE /api/rendezvous/delete/1
```


