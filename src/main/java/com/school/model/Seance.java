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
@Table(name = "seance")
@XmlRootElement
public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seance")
    private Integer id_seance;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "jour")
    private String jour;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "h_debut")
    private String hDebut;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "h_fin")
    private String hFin;
    @JsonIgnore
    @JoinColumn(name = "id_salle", referencedColumnName = "id_salle")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Salle id_salle;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_seance", fetch = FetchType.LAZY)
    private List<Cours> coursList;

    public Seance() {
    }

    public Seance(Integer id) {
        this.id_seance = id;
    }

    public Seance(Integer id, String jour, String hDebut, String hFin) {
        this.id_seance = id;
        this.jour = jour;
        this.hDebut = hDebut;
        this.hFin = hFin;
    }

    public Integer getId() {
        return id_seance;
    }

    public void setId(Integer id) {
        this.id_seance = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHDebut() {
        return hDebut;
    }

    public void setHDebut(String hDebut) {
        this.hDebut = hDebut;
    }

    public String getHFin() {
        return hFin;
    }

    public void setHFin(String hFin) {
        this.hFin = hFin;
    }

    public Salle getSalle() {
        return id_salle;
    }

    public void setSalle(Salle salle) {
        this.id_salle = salle;
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
        hash += (id_seance != null ? id_seance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seance)) {
            return false;
        }
        Seance other = (Seance) object;
        if ((this.id_seance == null && other.id_seance != null) || (this.id_seance != null && !this.id_seance.equals(other.id_seance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Seance[ id=" + id_seance + " ]";
    }

}
