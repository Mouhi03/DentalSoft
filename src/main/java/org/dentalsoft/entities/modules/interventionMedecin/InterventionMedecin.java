package org.dentalsoft.entities.modules.interventionMedecin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.consultation.Consultation;
import org.dentalsoft.entities.modules.acte.Acte;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InterventionMedecin extends BaseEntity {
    private Double prixDePatient;
    private Integer numDent;
    private Consultation consultation;
    private Acte acte;
}
