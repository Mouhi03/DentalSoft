package org.dentalsoft.entities.modules.patient;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.Sexe;
import org.dentalsoft.entities.enums.Assurance;
import org.dentalsoft.entities.modules.antecedents.Antecedents;
import org.dentalsoft.entities.modules.dossierMedicale.DossierMedicale;
import org.dentalsoft.entities.modules.situationFinanciere.SituationFinanciere;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Patient extends BaseEntity {
    private String nom;
    private LocalDate dateDeNaissance;
    private Sexe sexe;
    private String adresse;
    private String telephone;
    private Assurance assurance;
    private List<Antecedents> antecedents;
    private DossierMedicale dossierMedicale;
    private SituationFinanciere situationFinanciere;
}
