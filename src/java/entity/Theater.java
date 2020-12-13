/* Theater.java will hold a theater's name, theaterid, zipcode, address, and phone number 
along with their getters and setters. Moreover, Theater.java
has serial named queries to fetch theaters from MovieDB. */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Keith
 */
@Entity
@Table(name = "THEATER")
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterid", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterid"),
    @NamedQuery(name = "Theater.findByZipcode", query = "SELECT t FROM Theater t WHERE t.zipcode = :zipcode"),
    @NamedQuery(name = "Theater.findByTheatername", query = "SELECT t FROM Theater t WHERE t.theatername = :theatername"),
    @NamedQuery(name = "Theater.findByAddress", query = "SELECT t FROM Theater t WHERE t.address = :address"),
    @NamedQuery(name = "Theater.findByPhone", query = "SELECT t FROM Theater t WHERE t.phone = :phone")})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    /*theaterid will hold the theater's id*/
    private Integer theaterid;
    
    @Size(max = 5)
    @Column(name = "ZIPCODE")
    /*zipcode will be used to find nearby theaters*/
    private String zipcode;
    
    @Size(max = 50)
    @Column(name = "THEATERNAME")
    /*theatername will hold the thater's name*/
    private String theatername;
    
    @Size(max = 70)
    @Column(name = "ADDRESS")
    /*addresss will hold the theater's address*/
    private String address;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "PHONE")
    /*phone will hold the movie theater's phone number.*/
    private String phone;
    @JoinTable(name = "SHOWS", joinColumns = {
        @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID")}, inverseJoinColumns = {
        @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")})
    @ManyToMany
    /*moviesCollection will relate a theater and to its movies*/
    private Collection<Movies> moviesCollection;

    public Theater() {
    }
    
    /*getter and setters*/
    public Theater(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public Integer getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Movies> getMoviesCollection() {
        return moviesCollection;
    }

    public void setMoviesCollection(Collection<Movies> moviesCollection) {
        this.moviesCollection = moviesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterid=" + theaterid + " ]";
    }
    
}