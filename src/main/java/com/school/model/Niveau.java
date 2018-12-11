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
@Table(name = "niveau")
@XmlRootElement
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_niveau")
    private Integer id_niveau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frais")
    private double frais;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_niveau", fetch = FetchType.LAZY)
    private List<Groupe> groupeList;

    public Niveau() {
    }

    public Niveau(Integer id) {
        this.id_niveau = id;
    }

    public Niveau(Integer id, String libelle, double frais) {
        this.id_niveau = id;
        this.libelle = libelle;
        this.frais = frais;
    }

    public Integer getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(Integer id) {
        this.id_niveau = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    @XmlTransient
    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_niveau != null ? id_niveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.id_niveau == null && other.id_niveau != null) || (this.id_niveau != null && !this.id_niveau.equals(other.id_niveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Niveau[ id=" + id_niveau + " ]";
    }
    
}
