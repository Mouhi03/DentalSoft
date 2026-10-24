package org.dentalsoft.entities.modules.acte;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.interventionMedecin.InterventionMedecin;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Acte extends BaseEntity {
    private String libelle;
    private String categorie;
    private Double prixDeBase;
    private List<InterventionMedecin> interventions;
}
