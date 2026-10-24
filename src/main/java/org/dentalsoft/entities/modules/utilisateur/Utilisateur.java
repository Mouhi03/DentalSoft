package org.dentalsoft.entities.modules.utilisateur;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dentalsoft.entities.common.entite.BaseEntity;
import org.dentalsoft.entities.enums.Sexe;
import org.dentalsoft.entities.modules.role.Role;
import org.dentalsoft.entities.modules.notification.Notification;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Utilisateur extends BaseEntity {
    private String nom;
    private String email;
    private String adresse;
    private String cin;
    private String tel;
    private Sexe sexe;
    private String login;
    private String motDePasse;
    private LocalDate dateLogin;
    private LocalDate dateNaissance;
    private Role role;
    private List<Notification> notifications;
}
