/* Item.java will create Item objects that contain
a movie's title and time. Item objects will be added to an arrayList
by TheaterCartEJB and will serve as items in a user's cart. */
package ejb;

/**
 *
 * @author Keith
 */
public class Item {
    /*movieName will hold the movie's name*/
    private String movieName;
    /*movieTimes will hold the movie's show time.*/
    private String movieTime;
    
    /*getter and setters*/
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
    
    /*constructors*/
    public Item(){
    }
    
    public Item(String movieName, String movieTime) {
        this.movieName = movieName;
        this.movieTime = movieTime;
    }
    
    
    
}
