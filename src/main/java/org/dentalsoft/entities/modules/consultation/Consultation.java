package org.dentalsoft.entities.modules.consultation;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.ConsultationStatut;
import org.dentalsoft.entities.modules.dossierMedicale.DossierMedicale;
import org.dentalsoft.entities.modules.interventionMedecin.InterventionMedecin;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Consultation extends BaseEntity {
    private LocalDate date;
    private ConsultationStatut statut;
    private String observationMedecin;
    private DossierMedicale dossier;
    private InterventionMedecin interventionMedecin;
}
