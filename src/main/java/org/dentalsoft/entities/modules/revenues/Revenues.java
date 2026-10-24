package org.dentalsoft.entities.modules.revenues;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.cabinetMedicale.CabinetMedicale;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Revenues extends BaseEntity {
    private String titre;
    private String description;
    private Double montant;
    private LocalDateTime date;
    private CabinetMedicale cabinet;
}
