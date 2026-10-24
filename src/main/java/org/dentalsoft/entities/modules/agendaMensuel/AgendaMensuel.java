package org.dentalsoft.entities.modules.agendaMensuel;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dentalsoft.entities.enums.Mois;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaMensuel {
    private Mois mois;
    private List<LocalDate> joursNonDisponible;
}
