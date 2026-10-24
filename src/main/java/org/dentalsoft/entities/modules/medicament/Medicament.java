package org.dentalsoft.entities.modules.medicament;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.FormeMedicament;
import org.dentalsoft.entities.modules.prescription.Prescription;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Medicament extends BaseEntity {
    private String nom;
    private String laboratoire;
    private String type;
    private FormeMedicament forme;
    private boolean remboursable;
    private Double prixUnitaire;
    private List<Prescription> prescriptions;
}
