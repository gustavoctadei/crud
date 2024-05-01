/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.crud.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 *
 * @author gusta
 */
@Entity
@Table(name = "usuario_papel", catalog = "crud", schema = "dados")
@NamedQueries({
    @NamedQuery(name = "UsuarioPapel.findAll", query = "SELECT u FROM UsuarioPapel u"),
    @NamedQuery(name = "UsuarioPapel.findById", query = "SELECT u FROM UsuarioPapel u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioPapel.findByAtivo", query = "SELECT u FROM UsuarioPapel u WHERE u.ativo = :ativo")})
public class UsuarioPapel implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    @JoinColumn(name = "id_tipo_papel", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoPapel idTipoPapel;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private com.example.crud.model.Usuario idUsuario;

    public UsuarioPapel() {
    }

    public UsuarioPapel(Integer id) {
        this.id = id;
    }

    public UsuarioPapel(Integer id, boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoPapel getIdTipoPapel() {
        return idTipoPapel;
    }

    public void setIdTipoPapel(TipoPapel idTipoPapel) {
        this.idTipoPapel = idTipoPapel;
    }

    public com.example.crud.model.Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof UsuarioPapel)) {
            return false;
        }
        UsuarioPapel other = (UsuarioPapel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.crud.model.UsuarioPapel[ id=" + id + " ]";
    }

    @Override
    public String getAuthority() {
        return this.idTipoPapel.getDescricao();
    }
}
