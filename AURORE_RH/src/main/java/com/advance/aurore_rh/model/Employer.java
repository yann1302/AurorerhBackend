package com.advance.aurore_rh.model;


import com.advance.aurore_rh.model.lnk.EmployerFormation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_EMPLOYER")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employer extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;


    private String photo;

    private Date date_naissance;

    @Column(length = 50)
    private String lieu_naissance;

    @Column(length = 50)
    private String statut_matrimoniale;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private long numero;

    @Column(length = 50)
    private String type_contrat;

    @Column()
    private Date date_debut;

    private  Date date_fin;

    @Column(length = 50)
    private String ville_exertion;

    @Column(length = 50)
    private String nationalite;

    @Column(length = 50)
    private String matricule;

    @Column(length = 50)
    private String sexe;

    @Column(length = 50)
    private long nbr_enfant;

    @Column(length = 50)
    private String profession;

    private String poste;

    @OneToOne
    @JoinColumn(name = "user_id" )
    private User user;


//    @ManyToMany
//    @JoinTable(
//            name = "LNK_Employer_Formation",
//            joinColumns = @JoinColumn(name = "employer_id"),
//            inverseJoinColumns = @JoinColumn(name = "formation_id")
//    )
//    private List<Formation> formations;

    @OneToMany(mappedBy = "employer")
    private List<EmployerFormation> employerFormations;

    @ManyToMany
    @JoinTable(
            name = "LNCK_EMPLOYER_NOTEPROFESSIONEL",
            joinColumns = @JoinColumn(name = "employer_id"),
            inverseJoinColumns = @JoinColumn(name = "noteprofessionel_id")
    )
    private List<NoteProfessionel> noteProfessionels;

    @OneToMany(mappedBy = "employer")
    private List<Conger> congers;

    @OneToMany(targetEntity = Sanction.class, mappedBy = "employer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<Sanction> sanctions;

    public static final class EmployerBuilder {
        private long id;
        private String nom;
        private String prenom;
        private String photo;
        private Date date_naissance;
        private String lieu_naissance;
        private String statut_matrimoniale;
        private String adresse;
        private long numero;
        private String type_contrat;
        private Date date_debut;
        private Date date_fin;
        private String ville_exertion;
        private String nationalite;
        private String matricule;
        private String sexe;
        private long nbr_enfant;
        private String profession;
        private String poste;
        private User user;
        private List<EmployerFormation> employerFormations;
        private List<NoteProfessionel> noteProfessionels;
        private List<Conger> congers;
        private List<Sanction> sanctions;

        private EmployerBuilder() {
        }

        public static EmployerBuilder anEmployer() {
            return new EmployerBuilder();
        }

        public EmployerBuilder id(long id) {
            this.id = id;
            return this;
        }

        public EmployerBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public EmployerBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EmployerBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public EmployerBuilder date_naissance(Date date_naissance) {
            this.date_naissance = date_naissance;
            return this;
        }

        public EmployerBuilder lieu_naissance(String lieu_naissance) {
            this.lieu_naissance = lieu_naissance;
            return this;
        }

        public EmployerBuilder statut_matrimoniale(String statut_matrimoniale) {
            this.statut_matrimoniale = statut_matrimoniale;
            return this;
        }

        public EmployerBuilder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public EmployerBuilder numero(long numero) {
            this.numero = numero;
            return this;
        }

        public EmployerBuilder type_contrat(String type_contrat) {
            this.type_contrat = type_contrat;
            return this;
        }

        public EmployerBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public EmployerBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public EmployerBuilder ville_exertion(String ville_exertion) {
            this.ville_exertion = ville_exertion;
            return this;
        }

        public EmployerBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        public EmployerBuilder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public EmployerBuilder sexe(String sexe) {
            this.sexe = sexe;
            return this;
        }

        public EmployerBuilder nbr_enfant(long nbr_enfant) {
            this.nbr_enfant = nbr_enfant;
            return this;
        }

        public EmployerBuilder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public EmployerBuilder poste(String poste) {
            this.poste = poste;
            return this;
        }

        public EmployerBuilder user(User user) {
            this.user = user;
            return this;
        }

        public EmployerBuilder employerFormations(List<EmployerFormation> employerFormations) {
            this.employerFormations = employerFormations;
            return this;
        }

        public EmployerBuilder noteProfessionels(List<NoteProfessionel> noteProfessionels) {
            this.noteProfessionels = noteProfessionels;
            return this;
        }

        public EmployerBuilder congers(List<Conger> congers) {
            this.congers = congers;
            return this;
        }

        public EmployerBuilder sanctions(List<Sanction> sanctions) {
            this.sanctions = sanctions;
            return this;
        }

        public Employer build() {
            Employer employer = new Employer();
            employer.setId(id);
            employer.setNom(nom);
            employer.setPrenom(prenom);
            employer.setPhoto(photo);
            employer.setDate_naissance(date_naissance);
            employer.setLieu_naissance(lieu_naissance);
            employer.setStatut_matrimoniale(statut_matrimoniale);
            employer.setAdresse(adresse);
            employer.setNumero(numero);
            employer.setType_contrat(type_contrat);
            employer.setDate_debut(date_debut);
            employer.setDate_fin(date_fin);
            employer.setVille_exertion(ville_exertion);
            employer.setNationalite(nationalite);
            employer.setMatricule(matricule);
            employer.setSexe(sexe);
            employer.setNbr_enfant(nbr_enfant);
            employer.setProfession(profession);
            employer.setPoste(poste);
            employer.setUser(user);
            employer.setEmployerFormations(employerFormations);
            employer.setNoteProfessionels(noteProfessionels);
            employer.setCongers(congers);
            employer.setSanctions(sanctions);
            return employer;
        }
    }
}
