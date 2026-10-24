package org.dentalsoft.entities.modules.situationFinanciere;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.SFStatut;
import org.dentalsoft.entities.enums.Promo;
import org.dentalsoft.entities.modules.patient.Patient;
import org.dentalsoft.entities.modules.facture.Facture;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SituationFinanciere extends BaseEntity {
    private Double totalDesActes;
    private Double totalPaye;
    private Double credit;
    private SFStatut statut;
    private Promo enPromo;
    private Patient patient;
    private List<Facture> factures;
}
