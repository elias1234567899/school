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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insc")
    private Integer id_insc;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "Statut")
    private String statut;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users id_user;
    //@JsonIgnore
    @JoinColumn(name = "id_groupe", referencedColumnName = "id_groupe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe id_groupe;

    public Inscription() {
    }

    public Inscription(Integer id) {
        this.id_insc = id;
    }

    public Inscription(Integer id, Date date, String statut) {
        this.id_insc = id;
        this.date = date;
        this.statut = statut;
    }

    public Integer getId() {
        return id_insc;
    }

    public void setId(Integer id) {
        this.id_insc = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Users getEleve() {
        return id_user;
    }

    public void setEleve(Users eleve) {
        this.id_user = eleve;
    }

    public Groupe getGroup1() {
        return id_groupe;
    }

    public void setGroup1(Groupe group1) {
        this.id_groupe = group1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_insc != null ? id_insc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.id_insc == null && other.id_insc != null) || (this.id_insc != null && !this.id_insc.equals(other.id_insc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Inscription[ id=" + id_insc + " ]";
    }

}
