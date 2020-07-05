/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author LADDY DAYANNA LOZANO
 */
@Entity
@Table(name = "coupon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c"),
    @NamedQuery(name = "Coupon.findByIdCoupon", query = "SELECT c FROM Coupon c WHERE c.idCoupon = :idCoupon"),
    @NamedQuery(name = "Coupon.findByName", query = "SELECT c FROM Coupon c WHERE c.name = :name"),
    @NamedQuery(name = "Coupon.findByDescription", query = "SELECT c FROM Coupon c WHERE c.description = :description"),
    @NamedQuery(name = "Coupon.findByValidSince", query = "SELECT c FROM Coupon c WHERE c.validSince = :validSince"),
    @NamedQuery(name = "Coupon.findByValidUntil", query = "SELECT c FROM Coupon c WHERE c.validUntil = :validUntil")})
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_coupon")
    private Integer idCoupon;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "valid_since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validSince;
    @Column(name = "valid_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validUntil;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product id;

    public Coupon() {
    }

    public Coupon(Integer idCoupon) {
        this.idCoupon = idCoupon;
    }

    public Integer getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(Integer idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValidSince() {
        return validSince;
    }

    public void setValidSince(Date validSince) {
        this.validSince = validSince;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Product getId() {
        return id;
    }

    public void setId(Product id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoupon != null ? idCoupon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coupon)) {
            return false;
        }
        Coupon other = (Coupon) object;
        if ((this.idCoupon == null && other.idCoupon != null) || (this.idCoupon != null && !this.idCoupon.equals(other.idCoupon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Coupon[ idCoupon=" + idCoupon + " ]";
    }
    
}
