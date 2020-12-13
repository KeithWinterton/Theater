/* TheaterSystemEJB.java will provide the TheaterSysemBean with various methods
to access the MovieDB database. 
*/
package ejb;

import entity.Movies;
import entity.Theater;
import entity.Times;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Keith
 */
@Stateless
public class TheaterSystemEJB {
	
    /*em will be used to query the database.*/
    @PersistenceContext(unitName = "TheaterSystemPU")
    private EntityManager em;
    
    /*getTheaterById accepts an integer as a parameter and returns a Theater object.
    getTheaterById will call Theater's findByTheaterid named query. */
    public Theater getTheaterById(int id) {
        return em.createNamedQuery("Theater.findByTheaterid", Theater.class)
                .setParameter("theaterid", id).getSingleResult();
    }
    
    /*getTheatersByZip accepts a string as a parameter and returns a list Theater objects.
    getTheatersByZip will call Theater's findByZipcode named query. */
    public List<Theater> getTheatersByZip(String zipcode) {
        return em.createNamedQuery("Theater.findByZipcode", Theater.class)
                .setParameter("zipcode", zipcode).getResultList();
    }
    
    /*getMoviesByTheater accepts an integer as a parameter and returns a list Movies objects.
    getMoviesByTheater will call Movie's findByTheater named query. */
    public List<Movies> getMoviesByTheater(int id) {
        return em.createNamedQuery("Movies.findByTheater", Movies.class)
                .setParameter("theaterid", id).getResultList();
    }
    
    /*getMoviesId accepts an integer as a parameter and returns a Movies object.
    getMoviesByTheater will call Movie's findByMovieid named query. */
    public Movies getMovieById(int id) {
        return em.createNamedQuery("Movies.findByMovieid", Movies.class)
                .setParameter("movieid", id).getSingleResult();
    }
    /*getTimesByMovieId accepts an integer as a parameter and returns a list Times object.
    getTimesByMovieId will call Time's findByMovieid named query. */
    public List<Times> getTimesByMovieId(int id) {
        return em.createNamedQuery("Times.findByMovieid", Times.class)
                .setParameter("movieid", id).getResultList();
    }
}
