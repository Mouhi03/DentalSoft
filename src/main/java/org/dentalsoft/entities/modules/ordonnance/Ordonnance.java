package org.dentalsoft.entities.modules.ordonnance;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.dossierMedicale.DossierMedicale;
import org.dentalsoft.entities.modules.prescription.Prescription;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Ordonnance extends BaseEntity {
    private LocalDate date;
    private DossierMedicale dossier;
    private List<Prescription> prescriptions;
}
