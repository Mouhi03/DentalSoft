package org.dentalsoft.entities.modules.medecin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.modules.agendaMensuel.AgendaMensuel;
import org.dentalsoft.entities.modules.staff.Staff;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Medecin extends Staff {
    private String specialite;
    private AgendaMensuel agendaMensuel;
}
