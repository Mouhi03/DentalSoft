package org.dentalsoft.entities.modules.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
.
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.ordonnance.Ordonnance;
import org.dentalsoft.entities.modules.medicament.Medicament;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Prescription extends BaseEntity {
    private int quantite;
    private String frequence;
    private int dureeEnJours;
    private Ordonnance ordonnance;
    private Medicament medicament;
}
