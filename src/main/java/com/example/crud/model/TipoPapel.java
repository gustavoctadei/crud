/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.crud.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "tipo_papel", catalog = "crud", schema = "dados")
@NamedQueries({
    @NamedQuery(name = "TipoPapel.findAll", query = "SELECT t FROM TipoPapel t"),
    @NamedQuery(name = "TipoPapel.findById", query = "SELECT t FROM TipoPapel t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPapel.findByDescricao", query = "SELECT t FROM TipoPapel t WHERE t.descricao = :descricao")})
public class TipoPapel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPapel")
    private Collection<UsuarioPapel> usuarioPapelCollection;

    public TipoPapel() {
    }

    public TipoPapel(Integer id) {
        this.id = id;
    }

    public TipoPapel(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<UsuarioPapel> getUsuarioPapelCollection() {
        return usuarioPapelCollection;
    }

    public void setUsuarioPapelCollection(Collection<UsuarioPapel> usuarioPapelCollection) {
        this.usuarioPapelCollection = usuarioPapelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPapel)) {
            return false;
        }
        TipoPapel other = (TipoPapel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.crud.model.TipoPapel[ id=" + id + " ]";
    }
    
}
