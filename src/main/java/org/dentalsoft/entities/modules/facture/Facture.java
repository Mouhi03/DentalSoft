package org.dentalsoft.entities.modules.facture;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.FactureStatut;
import org.dentalsoft.entities.modules.situationFinanciere.SituationFinanciere;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Facture extends BaseEntity {
    private Double totalFacture;
    private Double totalPaye;
    private Double reste;
    private FactureStatut statut;
    private LocalDateTime dateFacture;
    private SituationFinanciere situationFinanciere;
}
