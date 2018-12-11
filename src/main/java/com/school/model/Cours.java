/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "cours")
@XmlRootElement
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cour")
    private Integer id_cour;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users id_user;
    @JoinColumn(name = "id_groupe", referencedColumnName = "id_groupe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe id_groupe;
    @JoinColumn(name = "id_matiere", referencedColumnName = "id_matiere")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Matiere id_matiere;
    @JsonIgnore
    @JoinColumn(name = "id_seance", referencedColumnName = "id_seance")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Seance id_seance;

    public Cours() {
    }

    public Cours(Integer id) {
        this.id_cour = id;
    }

    public Cours(Integer id, Date date) {
        this.id_cour = id;
        this.date = date;
    }

    public Integer getId() {
        return id_cour;
    }

    public void setId(Integer id) {
        this.id_cour = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getProf() {
        return id_user;
    }

    public void setProf(Users prof) {
        this.id_user = prof;
    }

    public Groupe getGroupe() {
        return id_groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.id_groupe = groupe;
    }

    public Matiere getMatiere() {
        return id_matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.id_matiere = matiere;
    }

    public Seance getSeance() {
        return id_seance;
    }

    public void setSeance(Seance seance) {
        this.id_seance = seance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_cour != null ? id_cour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.id_cour == null && other.id_cour != null) || (this.id_cour != null && !this.id_cour.equals(other.id_cour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Cours[ id=" + id_cour + " ]";
    }

}
