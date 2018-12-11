/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abbasturki.elias
 */
@Entity
@Table(name = "compte")
@XmlRootElement
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compte")
    private Integer id_compte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pwd")
    private String pwd;
    @JsonIgnore
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Users id_user;

    public Compte() {
    }

    public Compte(Integer id) {
        this.id_compte = id;
    }

    public Compte(Integer id, String login, String pwd) {
        this.id_compte = id;
        this.login = login;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id_compte;
    }

    public void setId(Integer id) {
        this.id_compte = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Users getUsers() {
        return id_user;
    }

    public void setUsers(Users users) {
        this.id_user = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_compte != null ? id_compte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id_compte == null && other.id_compte != null) || (this.id_compte != null && !this.id_compte.equals(other.id_compte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.school.model.Compte[ id=" + id_compte + " ]";
    }

}
