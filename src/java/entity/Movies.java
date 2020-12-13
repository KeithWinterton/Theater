/* Movies.java will hold a movie's title, moveid, dsecription, lengthInMinutes,
and release year along with their getters and setters. Moreover, Movies.java
has several named queries to fetch movies from MovieDB.
 */
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
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMovieid", query = "SELECT m FROM Movies m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Theater.findByTheaterid", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterid"),
    @NamedQuery(name = "Movies.findByDescription", query = "SELECT m FROM Movies m WHERE m.description = :description"),
    @NamedQuery(name = "Movies.findByLengthinminutes", query = "SELECT m FROM Movies m WHERE m.lengthinminutes = :lengthinminutes"),
    @NamedQuery(name = "Movies.findByTheater", query = "Select m From Movies m inner join m.theaterCollection t where t.theaterid = :theaterid")})
public class Movies implements Serializable {

    @Size(max = 100)
    @Column(name = "SMALLPICTURE")
    /*smallpicture will hold the smaller movie poster's file path*/
    private String smallpicture;
    
    @Size(max = 100)
    @Column(name = "BIGPICTURE")
     /*bigpicture will hold the bigger movie poster's file path*/
    private String bigpicture;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
	
    /*movieid will hold the movie's id*/
    private Integer movieid;
    @Size(max = 50)
    
    @Column(name = "TITLE")
    /*title will hold the movie's title*/
    private String title;
    
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    /*description will hold a movie's decription.*/
    private String description;
    @Column(name = "LENGTHINMINUTES")
    
    /*lengthinminutes will hold the movie's run time in minutes.*/
    private Integer lengthinminutes;
    
    @Size(max = 4)
    @Column(name = "RELEASEYEAR")
    /*releaseyear will the year the movie was released.*/
    private String releaseyear;
    
    @JoinTable(name = "SHOWTIMES", joinColumns = {
        @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")}, inverseJoinColumns = {
        @JoinColumn(name = "TIMEID", referencedColumnName = "TIMEID")})
    @ManyToMany
    /*timesCollection will be used to relate times to movies.*/
    private Collection<Times> timesCollection;
    @ManyToMany(mappedBy = "moviesCollection")
    
    /*theaterCollection will be used to relate movies to theaters.*/
    private Collection<Theater> theaterCollection;
    
  
    public Movies() {
    }
    
    /*getter and setters*/
    public Movies(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLengthinminutes() {
        return lengthinminutes;
    }

    public void setLengthinminutes(Integer lengthinminutes) {
        this.lengthinminutes = lengthinminutes;
    }

    public Collection<Times> getTimesCollection() {
        return timesCollection;
    }

    public void setTimesCollection(Collection<Times> timesCollection) {
        this.timesCollection = timesCollection;
    }

    public Collection<Theater> getTheaterCollection() {
        return theaterCollection;
    }

    public void setTheaterCollection(Collection<Theater> theaterCollection) {
        this.theaterCollection = theaterCollection;
    }
    
       public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ movieid=" + movieid + " ]";
    }

    public String getSmallpicture() {
        return smallpicture;
    }

    public void setSmallpicture(String smallpicture) {
        this.smallpicture = smallpicture;
    }

    public String getBigpicture() {
        return bigpicture;
    }

    public void setBigpicture(String bigpicture) {
        this.bigpicture = bigpicture;
    }

    
}
