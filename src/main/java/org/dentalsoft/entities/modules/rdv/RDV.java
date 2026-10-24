package org.dentalsoft.entities.modules.rdv;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.RdvStatut;
import org.dentalsoft.entities.modules.dossierMedicale.DossierMedicale;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RDV extends BaseEntity {
    private LocalDate date;
    private LocalTime heure;
    private String motif;
    private RdvStatut statut;
    private String noteMedecin;
    private DossierMedicale dossier;
}
