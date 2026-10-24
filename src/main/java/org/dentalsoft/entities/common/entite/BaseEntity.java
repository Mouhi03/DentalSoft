package org.dentalsoft.entities.common.entite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder // Use @SuperBuilder for inheritance-aware builders
public class BaseEntity {
    private Long id;
    private LocalDate dateCreation;
    private LocalDateTime dateDerniereModification;
    private String modifiePar;
    private String creePar;
}
