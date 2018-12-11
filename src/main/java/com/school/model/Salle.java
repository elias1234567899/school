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
@Table(name = "salle")
@XmlRootElement
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salle")
    private Integer id_salle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libelle")
    private String libelle;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_salle", fetch = FetchType.LAZY)
    private List<Seance> seanceList;

    public Salle() {
    }

    public Salle(Integer id) {
        this.id_salle = id;
    }

    public Salle(Integer id, String libelle) {
        this.id_salle = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id_salle;
    }

    public void setId(Integer id) {
        this.id_salle = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(List<Seance> seanceList) {
        this.seanceList = seanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_salle != null ? id_salle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.id_salle == null && other.id_salle != null) || (this.id_salle != null && !this.id_salle.equals(other.id_salle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Salle[ id=" + id_salle + " ]";
    }
    
}
