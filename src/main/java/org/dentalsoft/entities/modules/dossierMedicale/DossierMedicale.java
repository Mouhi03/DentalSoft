package org.dentalsoft.entities.modules.dossierMedicale;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.patient.Patient;
import org.dentalsoft.entities.modules.consultation.Consultation;
import org.dentalsoft.entities.modules.rdv.RDV;
import org.dentalsoft.entities.modules.ordonnance.Ordonnance;
import org.dentalsoft.entities.modules.certificat.Certificat;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DossierMedicale extends BaseEntity {
    // 'dateDeCreation' is now inherited from BaseEntity
    private Patient patient;
    private List<Consultation> consultations;
    private List<RDV> rdvs;
    private List<Ordonnance> ordonnances;
    private List<Certificat> certificats;
}
