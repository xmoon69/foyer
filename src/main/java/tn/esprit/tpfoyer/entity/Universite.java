package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;

    String nomUniversite;

    String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    Foyer foyer;

    @Temporal(TemporalType.DATE) // Assure-toi d'utiliser l'import pour la gestion des dates
    Date dateCreation;


}


