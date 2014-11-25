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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "RECHTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rechten.findAll", query = "SELECT r FROM Rechten r"),
    @NamedQuery(name = "Rechten.findByRId", query = "SELECT r FROM Rechten r WHERE r.rId = :rId"),
    @NamedQuery(name = "Rechten.findByRFunction", query = "SELECT r FROM Rechten r WHERE r.rFunction = :rFunction")})
public class Rechten implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "R_ID")
    private BigDecimal rId;
    @Size(max = 10)
    @Column(name = "R_FUNCTION")
    private String rFunction;

    public Rechten() {
    }

    public Rechten(BigDecimal rId) {
        this.rId = rId;
    }

    public BigDecimal getRId() {
        return rId;
    }

    public void setRId(BigDecimal rId) {
        this.rId = rId;
    }

    public String getRFunction() {
        return rFunction;
    }

    public void setRFunction(String rFunction) {
        this.rFunction = rFunction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rechten)) {
            return false;
        }
        Rechten other = (Rechten) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Rechten[ rId=" + rId + " ]";
    }
    
}
