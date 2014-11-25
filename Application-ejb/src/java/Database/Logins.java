/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author student
 */
@Entity
@Table(name = "LOGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l"),
    @NamedQuery(name = "Logins.findByWnId", query = "SELECT l FROM Logins l WHERE l.wnId = :wnId"),
    @NamedQuery(name = "Logins.findByLoPassw", query = "SELECT l FROM Logins l WHERE l.loPassw = :loPassw")})
public class Logins implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WN_ID")
    private BigDecimal wnId;
    @Size(max = 20)
    @Column(name = "LO_PASSW")
    private String loPassw;
    @JoinColumn(name = "WN_ID", referencedColumnName = "WN_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Werknemers werknemers;

    public Logins() {
    }

    public Logins(BigDecimal wnId) {
        this.wnId = wnId;
    }

    public BigDecimal getWnId() {
        return wnId;
    }

    public void setWnId(BigDecimal wnId) {
        this.wnId = wnId;
    }

    public String getLoPassw() {
        return loPassw;
    }

    public void setLoPassw(String loPassw) {
        this.loPassw = loPassw;
    }

    public Werknemers getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(Werknemers werknemers) {
        this.werknemers = werknemers;
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
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.wnId == null && other.wnId != null) || (this.wnId != null && !this.wnId.equals(other.wnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Logins[ wnId=" + wnId + " ]";
    }
    
}
