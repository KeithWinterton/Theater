/* Times.java will hold a time's id and a MovieTime along with their getters and setters.
Moreover, Times.java has serial named queries to fetch theater
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIMES")
@NamedQueries({
    @NamedQuery(name = "Times.findAll", query = "SELECT t FROM Times t"),
    @NamedQuery(name = "Times.findByTimeid", query = "SELECT t FROM Times t WHERE t.timeid = :timeid"),
    @NamedQuery(name = "Times.findByMovietime", query = "SELECT t FROM Times t WHERE t.movietime = :movietime"),
    @NamedQuery(name = "Times.findByMovieid", query = "SELECT t FROM Times t inner join t.moviesCollection m WHERE m.movieid  = :movieid")})
public class Times implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIMEID")
    /*timeid will hold a time's id*/
    private Integer timeid;
    
    @Size(max = 7)
    /*movie time will hold the time of a movie*/
    @Column(name = "MOVIETIME")
    private String movietime;
    
    @ManyToMany(mappedBy = "timesCollection")
    /*movieCollection will realate times to movies*/
    private Collection<Movies> moviesCollection;

    public Times() {
    }
    
    /*getter and setters*/
    public Times(Integer timeid) {
        this.timeid = timeid;
    }

    public Integer getTimeid() {
        return timeid;
    }

    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }

    public String getMovietime() {
        return movietime;
    }

    public void setMovietime(String movietime) {
        this.movietime = movietime;
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
        hash += (timeid != null ? timeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Times)) {
            return false;
        }
        Times other = (Times) object;
        if ((this.timeid == null && other.timeid != null) || (this.timeid != null && !this.timeid.equals(other.timeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Times[ timeid=" + timeid + " ]";
    }
    
}