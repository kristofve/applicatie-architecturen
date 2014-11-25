/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author student
 */
@Entity
@Table(name = "KREDIETEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kredieten.findAll", query = "SELECT k FROM Kredieten k"),
    @NamedQuery(name = "Kredieten.findByKrId", query = "SELECT k FROM Kredieten k WHERE k.krId = :krId"),
    @NamedQuery(name = "Kredieten.findByKrSaldo", query = "SELECT k FROM Kredieten k WHERE k.krSaldo = :krSaldo"),
    @NamedQuery(name = "Kredieten.findByKrWarrant", query = "SELECT k FROM Kredieten k WHERE k.krWarrant = :krWarrant")})
public class Kredieten implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KR_ID")
    private BigDecimal krId;
    @Column(name = "KR_SALDO")
    private BigInteger krSaldo;
    @Size(max = 1)
    @Column(name = "KR_WARRANT")
    private String krWarrant;
    @JoinColumn(name = "KR_MGMT", referencedColumnName = "WN_ID")
    @ManyToOne
    private Werknemers krMgmt;
    @OneToMany(mappedBy = "okCredit")
    private Collection<Onkosten> onkostenCollection;

    public Kredieten() {
    }

    public Kredieten(BigDecimal krId) {
        this.krId = krId;
    }

    public BigDecimal getKrId() {
        return krId;
    }

    public void setKrId(BigDecimal krId) {
        this.krId = krId;
    }

    public BigInteger getKrSaldo() {
        return krSaldo;
    }

    public void setKrSaldo(BigInteger krSaldo) {
        this.krSaldo = krSaldo;
    }

    public String getKrWarrant() {
        return krWarrant;
    }

    public void setKrWarrant(String krWarrant) {
        this.krWarrant = krWarrant;
    }

    public Werknemers getKrMgmt() {
        return krMgmt;
    }

    public void setKrMgmt(Werknemers krMgmt) {
        this.krMgmt = krMgmt;
    }

    @XmlTransient
    public Collection<Onkosten> getOnkostenCollection() {
        return onkostenCollection;
    }

    public void setOnkostenCollection(Collection<Onkosten> onkostenCollection) {
        this.onkostenCollection = onkostenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (krId != null ? krId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kredieten)) {
            return false;
        }
        Kredieten other = (Kredieten) object;
        if ((this.krId == null && other.krId != null) || (this.krId != null && !this.krId.equals(other.krId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Kredieten[ krId=" + krId + " ]";
    }
    
}
