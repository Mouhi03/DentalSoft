# DentalSoft

### Application de gestion de cabinet dentaire

> Projet de programmation avancée en Java, EMSI Rabat.
> Développé par une équipe de quatre étudiants sous l'encadrement du **Pr. Omar EL MIDAOUI**.

---

## Sommaire
1. [Contexte](#contexte)
2. [Objectifs](#objectifs)
3. [Technologies](#technologies)
4. [Architecture](#architecture)
5. [Fonctionnalités](#fonctionnalités)
6. [Base de données](#base-de-données)
7. [Organisation du code](#organisation-du-code)
8. [Charte graphique et ergonomie](#charte-graphique-et-ergonomie)
9. [Installation et exécution](#installation-et-exécution)
10. [Scénario de démonstration](#scénario-de-démonstration)
11. [Équipe](#équipe)

---

## Contexte
La transition numérique des cabinets médicaux est devenue indispensable pour mieux organiser les dossiers des patients, planifier les rendez-vous et suivre les soins prodigués.
**DentalSoft** répond à ce besoin avec une **application de bureau (Java Swing)** qui permet au chirurgien-dentiste et à sa secrétaire de piloter les volets administratif, médical et financier du cabinet.

---

## Objectifs
- **Automatiser** la gestion des patients et de leurs dossiers médicaux.
- **Améliorer** la planification des rendez-vous ainsi que la facturation.
- **Garantir** le suivi complet du parcours du patient : consultations, ordonnances et certificats.
- **Proposer** une interface claire, intuitive et moderne grâce à Swing.
- **Mettre en pratique** les principes SOLID et une conception en couches (MVC, DAO, services).

---

## Technologies

| Catégorie            | Technologie                  |
|----------------------|------------------------------|
| Langage              | Java SE 25                   |
| Interface graphique  | Java Swing                   |
| Base de données      | MySQL 8.0                    |
| Accès aux données    | JDBC                         |
| Gestion de build     | Maven                        |
| Bibliothèques        | Lombok, JFreeChart, iTextPDF |
| Environnement (IDE)  | IntelliJ IDEA Ultimate 2025  |
| Méthodologie         | Agile (Scrum)                |

---

## Architecture
L'application repose sur une architecture **MVC multicouche** :

```
DentalSoft/
├─ config/          → Configuration et injection de dépendances
├─ entities/        → Entités métier (Patient, Dossier, RendezVous, etc.)
├─ repository/      → Accès aux données (DAO / JDBC)
├─ service/         → Logique métier (PatientService, FactureService, etc.)
├─ mvc/
│  ├─ controllers/  → Contrôleurs des modules d'interface
│  ├─ dto/          → Objets de transfert de données (DTO)
│  └─ ui/           → Interface utilisateur (Swing)
│     ├─ common/        → Palette et composants réutilisables
│     ├─ rdv/           → Vues du module Rendez-vous
│     ├─ caisse/        → Vues du module Caisse
│     ├─ dashboard/     → Vues du tableau de bord
│     ├─ .../           → Vues des autres modules
│     └─ patient/       → Vues du module Patient
└─ common/          → Exceptions, utilitaires, validateurs
```

Chaque couche ne dialogue qu'avec la couche située en dessous, conformément au principe d'inversion des dépendances (**DIP**).

---

## Fonctionnalités

### Espace Médecin
- Consultation complète du dossier patient
- Enregistrement et suivi des interventions
- Rédaction des ordonnances et des certificats
- ...

### Espace Secrétaire
- Gestion des rendez-vous
- Suivi des paiements et des factures
- Consultation du planning général
- ...

### Fonctionnalités communes
- Authentification et gestion des rôles
- Statistiques (patients, revenus, interventions)
- Export des rapports au format PDF
- Sauvegarde et restauration de la base de données
- ...

---

## Base de données
- **Schéma** : le fichier `schema.sql` crée l'ensemble des tables.
- **Données de test** : le fichier `seed.sql` insère des données initiales (patients, rendez-vous, factures, etc.).
- **Connexion JDBC** : les paramètres sont définis dans `db.properties`.

**Exemple de `db.properties`** :
```properties
db.url=jdbc:mysql://localhost:3306/DentalSoft
db.user=root
db.password=
```

---

## Organisation du code
Chaque module est découpé selon les packages suivants :
- `entities` : classes POJO (avec Lombok)
- `repository` : interfaces DAO et implémentations JDBC
- `service` : logique métier
- `mvc` : couche de présentation (Swing)
- `common` : utilitaires, exceptions et validateurs
- `config` : fabriques et contexte de l'application

---

## Charte graphique et ergonomie

**Palette de couleurs**
- Bleu : `#5E98B7`
- Blanc : `#FFFFFF`
- Gris : `#D9D9D9`
- Vert (validation) : `#81C784`
- Rouge (alerte) : `#E57373`

**Police**
- `Poppins`

**Règles d'interface**
- Fenêtres centrées à l'écran
- Champs correctement espacés
- Icônes homogènes (dossier `static/icones/`)
- Hiérarchie visuelle respectée

---

## Installation et exécution

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/IlyCodes/DentalSoft.git
   cd DentalSoft
   ```

2. **Préparer la base de données :**
    - Importer `schema.sql` dans MySQL
    - Adapter les paramètres dans `src/main/resources/db.properties`

3. **Compiler et lancer l'application :**
   ```bash
   mvn clean install
   java -jar target/DentalSoft-1.0-SNAPSHOT-shaded.jar
   ```

4. **Identifiants de test :**
   ```
   Utilisateur : admin@DentalSoft.org
   Mot de passe : admin123
   ```

---

## Scénario de démonstration

1. Se connecter avec un compte secrétaire
2. Ajouter un nouveau patient
3. Créer un rendez-vous
4. Enregistrer une consultation et établir une ordonnance
5. Générer une facture au format PDF
6. Afficher le tableau de bord (statistiques des patients et des revenus)

---

## Équipe

| Étudiant   | Rôle | Email |
|------------|------|-------|
| Étudiant 1 | ...  | ...   |
| Étudiant 2 | ...  | ...   |
| Étudiant 3 | ...  | ...   |
| Étudiant 4 | ...  | ...   |

---

© 2025 – **DentalSoft | EMSI Rabat**
Sous l'encadrement du **Pr. Omar El Midaoui**
