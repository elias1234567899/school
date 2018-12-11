/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "groupe")
@XmlRootElement
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_groupe")
    private Integer id_groupe;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @Column(name = "nombre")
    private int nombre;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_groupe", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    //@JsonIgnore
    @JoinColumn(name = "id_niveau", referencedColumnName = "id_niveau")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Niveau id_niveau;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_groupe", fetch = FetchType.LAZY)
    private List<Cours> coursList;

    public Groupe() {
    }

    public Groupe(Integer id) {
        this.id_groupe = id;
    }

    public Groupe(Integer id, String libelle, int nombre) {
        this.id_groupe = id;
        this.libelle = libelle;
        this.nombre = nombre;
    }

    public Integer getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(Integer id) {
        this.id_groupe = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public Niveau getNiveau() {
        return id_niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.id_niveau = niveau;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_groupe != null ? id_groupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.id_groupe == null && other.id_groupe != null) || (this.id_groupe != null && !this.id_groupe.equals(other.id_groupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Groupe[ id=" + id_groupe + " ]";
    }

}
