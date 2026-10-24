package org.dentalsoft.entities.modules.antecedents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.AntecedentsCategorie;
import org.dentalsoft.entities.enums.Risque;
import org.dentalsoft.entities.modules.patient.Patient;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Antecedents extends BaseEntity {
    private String nom;
    private AntecedentsCategorie categorie;
    private Risque niveauDeRisque;
    private Patient patient;
}
