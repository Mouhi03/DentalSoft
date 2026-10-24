package org.dentalsoft.entities.modules.cabinetMedicale;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.modules.staff.Staff;
import org.dentalsoft.entities.modules.charges.Charges;
import org.dentalsoft.entities.modules.revenues.Revenues;
import org.dentalsoft.entities.modules.statistiques.Statistiques;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CabinetMedicale extends BaseEntity {
    private String nom;
    private String email;
    private String logo;
    private String adresse;
    private String tel;
    private String tel2;
    private String siteWeb;
    private String instagram;
    private String facebook;
    private String description;
    private List<Staff> staff;
    private List<Charges> charges;
    private List<Revenues> revenues;
    private List<Statistiques> statistiques;
}
