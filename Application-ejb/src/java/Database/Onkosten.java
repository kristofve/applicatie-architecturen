/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author student
 */
@Entity
@Table(name = "ONKOSTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onkosten.findAll", query = "SELECT o FROM Onkosten o"),
    @NamedQuery(name = "Onkosten.findByOkId", query = "SELECT o FROM Onkosten o WHERE o.okId = :okId"),
    @NamedQuery(name = "Onkosten.findByOkDate", query = "SELECT o FROM Onkosten o WHERE o.okDate = :okDate"),
    @NamedQuery(name = "Onkosten.findByOkAmt", query = "SELECT o FROM Onkosten o WHERE o.okAmt = :okAmt"),
    @NamedQuery(name = "Onkosten.findByOkStatus", query = "SELECT o FROM Onkosten o WHERE o.okStatus = :okStatus")})
public class Onkosten implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OK_ID")
    private BigDecimal okId;
    @Lob
    @Column(name = "OK_DESCR")
    private String okDescr;
    @Column(name = "OK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date okDate;
    @Column(name = "OK_AMT")
    private BigInteger okAmt;
    @Size(max = 20)
    @Column(name = "OK_STATUS")
    private String okStatus;
    @JoinColumn(name = "OK_OWNER", referencedColumnName = "WN_ID")
    @ManyToOne
    private Werknemers okOwner;
    @JoinColumn(name = "OK_CREDIT", referencedColumnName = "KR_ID")
    @ManyToOne
    private Kredieten okCredit;

    public Onkosten() {
    }

    public Onkosten(BigDecimal okId) {
        this.okId = okId;
    }

    public BigDecimal getOkId() {
        return okId;
    }

    public void setOkId(BigDecimal okId) {
        this.okId = okId;
    }

    public String getOkDescr() {
        return okDescr;
    }

    public void setOkDescr(String okDescr) {
        this.okDescr = okDescr;
    }

    public Date getOkDate() {
        return okDate;
    }

    public void setOkDate(Date okDate) {
        this.okDate = okDate;
    }

    public BigInteger getOkAmt() {
        return okAmt;
    }

    public void setOkAmt(BigInteger okAmt) {
        this.okAmt = okAmt;
    }

    public String getOkStatus() {
        return okStatus;
    }

    public void setOkStatus(String okStatus) {
        this.okStatus = okStatus;
    }

    public Werknemers getOkOwner() {
        return okOwner;
    }

    public void setOkOwner(Werknemers okOwner) {
        this.okOwner = okOwner;
    }

    public Kredieten getOkCredit() {
        return okCredit;
    }

    public void setOkCredit(Kredieten okCredit) {
        this.okCredit = okCredit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (okId != null ? okId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onkosten)) {
            return false;
        }
        Onkosten other = (Onkosten) object;
        if ((this.okId == null && other.okId != null) || (this.okId != null && !this.okId.equals(other.okId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Onkosten[ okId=" + okId + " ]";
    }
    
}
