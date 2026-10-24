package org.dentalsoft.entities.modules.notification;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.NotificationTitre;
import org.dentalsoft.entities.enums.NotificationType;
import org.dentalsoft.entities.enums.Priorite;
import org.dentalsoft.entities.modules.utilisateur.Utilisateur;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Notification extends BaseEntity {
    private NotificationTitre titre;
    private String message;
    private LocalDate date;
    private LocalTime time;
    private NotificationType type;
    private Priorite priorite;
    private List<Utilisateur> utilisateurs;
}
