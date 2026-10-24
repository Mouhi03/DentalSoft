package org.dentalsoft.entities.modules.statistiques;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.StatistiqueCategorie;
import org.dentalsoft.entities.modules.agendaMensuel.AgendaMensuel;
import org.dentalsoft.entities.modules.cabinetMedicale.CabinetMedicale;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Statistiques extends BaseEntity {
    private String nom;
    private StatistiqueCategorie categorie;
    private Double chiffre;
    private LocalDate dateCalcul;
    private CabinetMedicale cabinet;
    private AgendaMensuel agendaMensuel;
}
