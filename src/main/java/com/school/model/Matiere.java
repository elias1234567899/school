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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "matiere")
@XmlRootElement
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matiere")
    private Integer id_matiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libelle")
    private String libelle;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_matiere", fetch = FetchType.LAZY)
    private List<Cours> coursList;

    public Matiere() {
    }

    public Matiere(Integer id) {
        this.id_matiere = id;
    }

    public Matiere(Integer id, String libelle) {
        this.id_matiere = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id_matiere;
    }

    public void setId(Integer id) {
        this.id_matiere = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        hash += (id_matiere != null ? id_matiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.id_matiere == null && other.id_matiere != null) || (this.id_matiere != null && !this.id_matiere.equals(other.id_matiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Matiere[ id=" + id_matiere + " ]";
    }
    
}
