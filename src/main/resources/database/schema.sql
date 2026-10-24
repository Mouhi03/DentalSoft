CREATE TABLE Role
(
    id_role BIGINT PRIMARY KEY,
    libelle ENUM('ADMIN', 'MEDECIN', 'SECRETAIRE') NOT NULL,
);

CREATE TABLE Role_Privileges
(
    role_id   BIGINT,
    privilege VARCHAR(255),
    PRIMARY KEY (role_id, privilege),
    FOREIGN KEY (role_id) REFERENCES Role (id_role) ON DELETE CASCADE
);


CREATE TABLE CabinetMedicale
(
    id_cabinet  BIGINT PRIMARY KEY,
    nom         VARCHAR(255),
    email       VARCHAR(255),
    logo        VARCHAR(255),
    adresse     VARCHAR(255),
    tel         VARCHAR(50),
    tel2        VARCHAR(50),
    site_web    VARCHAR(255),
    instagram   VARCHAR(255),
    facebook    VARCHAR(255),
    description TEXT
);


CREATE TABLE Utilisateur
(
    id_user        BIGINT PRIMARY KEY,
    nom            VARCHAR(255),
    email          VARCHAR(255) UNIQUE,
    adresse        VARCHAR(255),
    cin            VARCHAR(50) UNIQUE,
    tel            VARCHAR(50),
    sexe           ENUM('HOMME', 'FEMME', 'AUTRE') NOT NULL,
    login          VARCHAR(100) UNIQUE,
    mot_de_passe   VARCHAR(255),
    date_login     DATE,
    date_naissance DATE,
    role_id        BIGINT,
    FOREIGN KEY (role_id) REFERENCES Role (id_role)
);

CREATE TABLE Staff
(
    id_user          BIGINT PRIMARY KEY,
    salaire          DECIMAL(10, 2),
    prime            DECIMAL(10, 2),
    date_recrutement DATE,
    solde_conge      INTEGER,
    cabinet_id       BIGINT,
    FOREIGN KEY (id_user) REFERENCES Utilisateur (id_user) ON DELETE CASCADE,
    FOREIGN KEY (cabinet_id) REFERENCES CabinetMedicale (id_cabinet)
);

CREATE TABLE Admin
(
    id_user BIGINT PRIMARY KEY,
    FOREIGN KEY (id_user) REFERENCES Utilisateur (id_user) ON DELETE CASCADE
);

CREATE TABLE Secretaire
(
    id_user    BIGINT PRIMARY KEY,
    num_cnss   VARCHAR(100),
    commission DECIMAL(10, 2),
    FOREIGN KEY (id_user) REFERENCES Staff (id_user) ON DELETE CASCADE
);

CREATE TABLE Medecin
(
    id_user    BIGINT PRIMARY KEY,
    specialite VARCHAR(255),
    FOREIGN KEY (id_user) REFERENCES Staff (id_user) ON DELETE CASCADE
);


CREATE TABLE Notification
(
    id       BIGINT PRIMARY KEY,
    titre    ENUM('RAPPEL', 'ALERTE', 'INFO') NOT NULL,
    message  TEXT,
    date     DATE,
    time     TIME,
    type     ENUM('EMAIL', 'SMS', 'APP') NOT NULL,
    priorite ENUM('HAUTE', 'MOYENNE', 'BASSE') NOT NULL DEFAULT 'NORMALE'
);

CREATE TABLE Utilisateur_Notification
(
    user_id         BIGINT,
    notification_id BIGINT,
    PRIMARY KEY (user_id, notification_id),
    FOREIGN KEY (user_id) REFERENCES Utilisateur (id_user),
    FOREIGN KEY (notification_id) REFERENCES Notification (id)
);


CREATE TABLE Charges
(
    id_charge   BIGINT PRIMARY KEY AUTO_INCREMENT,
    titre       VARCHAR(255),
    description TEXT,
    montant     DECIMAL(10, 2),
    date        TIMESTAMP,
    cabinet_id  BIGINT,
    FOREIGN KEY (cabinet_id) REFERENCES CabinetMedicale (id_cabinet)
);

CREATE TABLE Revenues
(
    id_revenu   BIGINT PRIMARY KEY AUTO_INCREMENT,
    titre       VARCHAR(255),
    description TEXT,
    montant     DECIMAL(10, 2),
    date        TIMESTAMP,
    cabinet_id  BIGINT,
    FOREIGN KEY (cabinet_id) REFERENCES CabinetMedicale (id_cabinet)
);

CREATE TABLE Statistiques
(
    id          BIGINT PRIMARY KEY,
    nom         VARCHAR(255),
    categorie   ENUM('FINANCIER', 'PATIENT', 'OPERATION'),
    chiffre     DECIMAL(10, 2),
    date_calcul DATE,
    cabinet_id  BIGINT,
    FOREIGN KEY (cabinet_id) REFERENCES CabinetMedicale (id_cabinet)
);


CREATE TABLE Patient
(
    id_patient        BIGINT PRIMARY KEY,
    nom               VARCHAR(255),
    date_de_naissance DATE,
    sexe              ENUM('HOMME', 'FEMME', 'AUTRE') NOT NULL,
    adresse           VARCHAR(255),
    telephone         VARCHAR(50),
    assurance         ENUM('CNOPS', 'CNSS', 'Autre', 'Aucune') NOT NULL,
);

CREATE TABLE Antecedents
(
    id               BIGINT PRIMARY KEY,
    nom              VARCHAR(255),
    categorie        ENUM('ALLERGIE', 'MALADIE_CHRONIQUE', 'CONTRE_INDICATION',
                          'TRAITEMENT_EN_COURS', 'ANTECEDENT_CHIRURGICAL', 'ANTECEDENT_INFECTIEUX',
                          'ANTECEDENT_DENTAIRE', 'HABITUDE_DE_VIE', 'AUTRE'
                         ) NOT NULL,
    niveau_de_risque ENUM('ELEVE', 'MOYEN', 'FAIBLE') NOT NULL
);

CREATE TABLE Patient_Antecedents
(
    patient_id BIGINT NOT NULL,
    antecedent_id BIGINT NOT NULL,
    PRIMARY KEY (patient_id, antecedent_id),
    FOREIGN KEY (patient_id) REFERENCES Patients(id_patient) ON DELETE CASCADE,
    FOREIGN KEY (antecedent_id) REFERENCES Antecedents(id) ON DELETE CASCADE
);

CREATE TABLE DossierMedicale
(
    id_dm            BIGINT PRIMARY KEY,
    date_de_creation DATE,
    patient_id       BIGINT UNIQUE,
    sf_id       BIGINT UNIQUE,
    FOREIGN KEY (patient_id) REFERENCES Patient (id_patient)
    FOREIGN KEY (sf_id) REFERENCES SituationFinanciere (id_sf)
);

CREATE TABLE SituationFinanciere
(
    id_sf           BIGINT PRIMARY KEY,
    total_des_actes DECIMAL(10, 2),
    total_paye      DECIMAL(10, 2),
    credit          DECIMAL(10, 2),
    statut          ENUM('EN_ATTENTE_ACCEPTATION', 'DEVIS_ACCEPTE',
                         'DEVIS_REFUSE', 'PLAN_PAIEMENT_ACTIF',
                         'EN_RETARD', 'SOLDE', 'ANNULE'
                         ) NOT NULL,
    en_promo        ENUM('OUI', 'NON') NOT NULL
);


CREATE TABLE Facture
(
    id_facture              BIGINT PRIMARY KEY,
    total_facture           DECIMAL(10, 2),
    total_paye              DECIMAL(10, 2),
    reste                   DECIMAL(10, 2),
    statut                  ENUM('EMISE', 'SOLDEE',
                                 'EN_RETARD', 'ANNULEE) NOT NULL,
    date_facture            TIMESTAMP,
    situation_financiere_id BIGINT,
    consultation_id BIGINT,
    FOREIGN KEY (situation_financiere_id) REFERENCES SituationFinanciere (id_sf)
    FOREIGN KEY (consultation_id) REFERENCES Consultation (id_consultation)
);

CREATE TABLE Consultation
(
    id_consultation     BIGINT PRIMARY KEY,
    date                DATE,
    statut              ENUM('PLANIFIEE',
                             'CONFIRMEE',
                             'TERMINEE',
                             'ANNULEE',
                             'NON_HONOREE') NOT NULL,
    observation_medecin TEXT,
    dossier_id          BIGINT,
    FOREIGN KEY (dossier_id) REFERENCES DossierMedicale (id_dm)
);


CREATE TABLE Acte
(
    id_acte      BIGINT PRIMARY KEY,
    libelle      VARCHAR(255),
    categorie    VARCHAR(100),
    prix_de_base DECIMAL(10, 2)
);

CREATE TABLE InterventionMedecin
(
    id_im           BIGINT PRIMARY KEY,
    prix_de_patient DECIMAL(10, 2),
    num_dent        INTEGER,
    consultation_id BIGINT UNIQUE,
    acte_id         BIGINT,
    FOREIGN KEY (consultation_id) REFERENCES Consultation (id_consultation),
    FOREIGN KEY (acte_id) REFERENCES Acte (id_acte)
);


CREATE TABLE RDV
(
    id_rdv       BIGINT PRIMARY KEY,
    date         DATE,
    heure        TIME,
    motif        VARCHAR(255),
    statut       ENUM('PLANIFIEE',
                      'CONFIRMEE',
                      'EN_SALLE_ATTENTE',
                      'EN_RETARD',
                      'TERMINEE',
                      'ANNULEE_PATIENT',
                      'ANNULEE_CABINET',
                      'NON_HONOREE') NOT NULL,
    note_medecin TEXT,
    dossier_id   BIGINT,
    consultation_id   BIGINT,
    FOREIGN KEY (dossier_id) REFERENCES DossierMedicale (id_dm)
    FOREIGN KEY (consultation_id) REFERENCES Consultation (id_consultation)
);


CREATE TABLE Ordonnance
(
    id_ord     BIGINT PRIMARY KEY,
    date       DATE,
    dossier_id BIGINT,
    consultation_id   BIGINT,
    FOREIGN KEY (dossier_id) REFERENCES DossierMedicale (id_dm)
    FOREIGN KEY (consultation_id) REFERENCES Consultation (id_consultation)
);

CREATE TABLE Medicament
(
    id_mc         BIGINT PRIMARY KEY,
    nom           VARCHAR(255),
    laboratoire   VARCHAR(255),
    type          VARCHAR(100),
    forme         ENUM('COMPRIME', 'GOUTTES', 'SIROP', 'INJECTION') NOT NULL,
    remboursable  BOOLEAN,
    prix_unitaire DECIMAL(10, 2)
);

CREATE TABLE Prescription
(
    id_pr          BIGINT PRIMARY KEY,
    quantite       INTEGER,
    frequence      VARCHAR(255),
    duree_en_jours INTEGER,
    ordonnance_id  BIGINT,
    medicament_id  BIGINT,
    FOREIGN KEY (ordonnance_id) REFERENCES Ordonnance (id_ord),
    FOREIGN KEY (medicament_id) REFERENCES Medicament (id_mc)
);


CREATE TABLE Certificat
(
    id_certif    BIGINT PRIMARY KEY,
    date_debut   DATE,
    date_fin     DATE,
    duree        INTEGER,
    note_medecin TEXT,
    dossier_id   BIGINT,
    FOREIGN KEY (dossier_id) REFERENCES DossierMedicale (id_dm)
);