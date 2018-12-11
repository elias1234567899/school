/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "users")
@XmlRootElement
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer id_user;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "date_naiss")
    @Temporal(TemporalType.DATE)
    private Date date_naiss;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "tele1")
    private String tele1;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "tele2")
    private String tele2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user", fetch = FetchType.LAZY)
    private List<Cours> coursList;
    @JsonIgnore
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role id_role;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id_user", fetch = FetchType.LAZY)
    private Compte id_compte;

    public Users() {
    }

    public Users(Integer id) {
        this.id_user = id;
    }

    public Users(Integer id, String nom, String prenom, String adresse, String sexe, Date dateNaiss, String tele1, String tele2, String email) {
        this.id_user = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.sexe = sexe;
        this.date_naiss = dateNaiss;
        this.tele1 = tele1;
        this.tele2 = tele2;
        this.email = email;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id) {
        this.id_user = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaiss() {
        return date_naiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.date_naiss = dateNaiss;
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public String getTele2() {
        return tele2;
    }

    public void setTele2(String tele2) {
        this.tele2 = tele2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public Role getRole() {
        return id_role;
    }

    public void setRole(Role role) {
        this.id_role = role;
    }

    public Compte getCompte() {
        return id_compte;
    }

    public void setCompte(Compte compte) {
        this.id_compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_user != null ? id_user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id_user == null && other.id_user != null) || (this.id_user != null && !this.id_user.equals(other.id_user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Users[ id=" + id_user + " ]";
    }

}
