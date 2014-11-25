/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "WERKNEMERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Werknemers.findAll", query = "SELECT w FROM Werknemers w"),
    @NamedQuery(name = "Werknemers.findByWnId", query = "SELECT w FROM Werknemers w WHERE w.wnId = :wnId"),
    @NamedQuery(name = "Werknemers.findByWnLname", query = "SELECT w FROM Werknemers w WHERE w.wnLname = :wnLname"),
    @NamedQuery(name = "Werknemers.findByWnFname", query = "SELECT w FROM Werknemers w WHERE w.wnFname = :wnFname"),
    @NamedQuery(name = "Werknemers.findByWnFunction", query = "SELECT w FROM Werknemers w WHERE w.wnFunction = :wnFunction")})
public class Werknemers implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WN_ID")
    private BigDecimal wnId;
    @Size(max = 20)
    @Column(name = "WN_LNAME")
    private String wnLname;
    @Size(max = 20)
    @Column(name = "WN_FNAME")
    private String wnFname;
    @Size(max = 10)
    @Column(name = "WN_FUNCTION")
    private String wnFunction;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "werknemers")
    private Boekhouders boekhouders;
    @OneToMany(mappedBy = "krMgmt")
    private Collection<Kredieten> kredietenCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "werknemers")
    private Logins logins;
    @OneToMany(mappedBy = "okOwner")
    private Collection<Onkosten> onkostenCollection;
    @OneToMany(mappedBy = "wnBoss")
    private Collection<Werknemers> werknemersCollection;
    @JoinColumn(name = "WN_BOSS", referencedColumnName = "WN_ID")
    @ManyToOne
    private Werknemers wnBoss;

    public Werknemers() {
    }

    public Werknemers(BigDecimal wnId) {
        this.wnId = wnId;
    }

    public BigDecimal getWnId() {
        return wnId;
    }

    public void setWnId(BigDecimal wnId) {
        this.wnId = wnId;
    }

    public String getWnLname() {
        return wnLname;
    }

    public void setWnLname(String wnLname) {
        this.wnLname = wnLname;
    }

    public String getWnFname() {
        return wnFname;
    }

    public void setWnFname(String wnFname) {
        this.wnFname = wnFname;
    }

    public String getWnFunction() {
        return wnFunction;
    }

    public void setWnFunction(String wnFunction) {
        this.wnFunction = wnFunction;
    }

    public Boekhouders getBoekhouders() {
        return boekhouders;
    }

    public void setBoekhouders(Boekhouders boekhouders) {
        this.boekhouders = boekhouders;
    }

    @XmlTransient
    public Collection<Kredieten> getKredietenCollection() {
        return kredietenCollection;
    }

    public void setKredietenCollection(Collection<Kredieten> kredietenCollection) {
        this.kredietenCollection = kredietenCollection;
    }

    public Logins getLogins() {
        return logins;
    }

    public void setLogins(Logins logins) {
        this.logins = logins;
    }

    @XmlTransient
    public Collection<Onkosten> getOnkostenCollection() {
        return onkostenCollection;
    }

    public void setOnkostenCollection(Collection<Onkosten> onkostenCollection) {
        this.onkostenCollection = onkostenCollection;
    }

    @XmlTransient
    public Collection<Werknemers> getWerknemersCollection() {
        return werknemersCollection;
    }

    public void setWerknemersCollection(Collection<Werknemers> werknemersCollection) {
        this.werknemersCollection = werknemersCollection;
    }

    public Werknemers getWnBoss() {
        return wnBoss;
    }

    public void setWnBoss(Werknemers wnBoss) {
        this.wnBoss = wnBoss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wnId != null ? wnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Werknemers)) {
            return false;
        }
        Werknemers other = (Werknemers) object;
        if ((this.wnId == null && other.wnId != null) || (this.wnId != null && !this.wnId.equals(other.wnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Werknemers[ wnId=" + wnId + " ]";
    }
    
}
