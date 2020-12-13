/*TheaterSystemBean is a cdi bean that is used to navigate between different
jsf pages and validate the user's input. */
package cdi;

import ejb.TheaterSystemEJB;
import entity.Movies;
import entity.Theater;
import entity.Times;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Keith
 */
@Named(value = "theaterBean")
@RequestScoped
public class TheaterSystemBean implements Serializable {

   
    @EJB
    /*theteaterSystemEJB is used to call TheaterSystem to query the MovieDB database */
    private TheaterSystemEJB theaterSystemEJB;
    
    /*zipcode will hold the user-entered zip code, which wiil be used to get
    the list of theaters in the zip code and navigate between different JSF pages.*/
    private String zipcode = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("zipcode");
    
    /*stringtheterid will hold the theaterid of the selected theater
    to perform queries that require a theaterid and navigate between different
    JSF pages.*/
    private String stringtheaterid = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("theaterid");
    
    /*stringmocieid will hold the movieid of the selected theater
    to perform queries that require a theaterid and navigate between different
    JSF pages.*/
    private String stringmovieid = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("movieid");
    
    /*cardNumber will hold the user's entered credit card number.*/
    private String cardNumber;
    
    /*theater will hold a theater entity*/
    private Theater theater;
  
    
    /*movie will hold a movie entity*/
    private Movies movie;
    
    
    
    public TheaterSystemBean() {
    }
    
    /*getter and setters*/
    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
    
       public String getStringtheaterid() {
        return stringtheaterid;
    }

    public void setStringtheaterid(String stringtheaterid) {
        this.stringtheaterid = stringtheaterid;
    }

    public String getStringmovieid() {
        return stringmovieid;
    }

    public void setStringmovieid(String stringmovieid) {
        this.stringmovieid = stringmovieid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
    /*getTheaterList does not accept anything and returns
    a list of Theaters from MovieDB by using theaterSystemEJB's
    getTheatersByZip method.*/
    public List<Theater> getTheaterList() {
        return theaterSystemEJB.getTheatersByZip(zipcode);
    }
    
    /*getMovieTimes does not accept anything and returns
    a list of Times from MovieDB by using theaterSystemEJB's
    getTimesByMovieId method.*/
    public List<Times> getMovieTimesList() {
        int id = Integer.parseInt(stringmovieid);
        return theaterSystemEJB.getTimesByMovieId(id);
    }
    
    /*getMovieList does not accept anything and returns
    a list of Movies from MovieDB by using theaterSystemEJB's
    getMoviesByTheater method.*/
    public List<Movies> getMovieList () {
        int id = Integer.parseInt(stringtheaterid);
        return theaterSystemEJB.getMoviesByTheater(id);
    }
    
    /*toTheaterMovies does not accept anything and returns
    a string.
    toTheaterMovies queries the database for a theater
    by using theaterSystemEJB's getTheaterById method
    and assigns the fetched theater to the theater
    variable and then returns TheaterMovies.xhtml
    to navigate to the TheaterMovies JSF page.*/
    public String toTheaterMovies() {
        int id = Integer.parseInt(stringtheaterid);
        theater = theaterSystemEJB.getTheaterById(id);
        return "TheaterMovies.xhtml";
    }
	
    /* toTheaterList does not accept anything and returns
    a string.
    toTheaterList navigates to the TheaterList JSF page by
    returning TheaterList.xhtml.
    */
     public String toTheaterList() {
       return "TheaterList.xhtml";
    }
    
    /* toMovieInfomation does not accept anything and returns
    a string. toMovieInfomation will set call the TheaterSystemEJB's
    methods to fetch a new movie and theater object from the ids passed
    by the JSF parameters.toMovieInfomation navigates to the MovieInformation
    JSF page by returning MovieInformation.xhtml.
    */
    public String toMovieInfomation() {
        int mid = Integer.parseInt(stringmovieid);
        int tid = Integer.parseInt(stringtheaterid);
        theater = theaterSystemEJB.getTheaterById(tid);
        movie = theaterSystemEJB.getMovieById(mid);
        return "MovieInformation.xhtml";
    }
    
    /* toMovieTimes does not accept anything and returns
    a string. toMovieTimes will set call the TheaterSystemEJB's
    methods to fetch a new movie and theater object from the ids passed
    by the JSF parameters.toMovieTimes navigates to the MovieShowTimes
    JSF page by returning MovieShowTimes.xhtml. */
    public String toMovieTimes() {
        int mid = Integer.parseInt(stringmovieid);
        int tid = Integer.parseInt(stringtheaterid);
        movie = theaterSystemEJB.getMovieById(mid);
        theater = theaterSystemEJB.getTheaterById(tid);
        return "MovieShowTimes.xhtml";
          
    }
    
    /* toCheckout does not accept anything and returns
    a string. toCheckout will set call the TheaterSystemEJB's
    method to fetch a theater object from the id passed
    by the JSF parameters.toCheckout navigates to the Checkout
    JSF page by returning Checkout.xhtml. */
    public String toCheckout() {
        int mid = Integer.parseInt(stringmovieid);
        int tid = Integer.parseInt(stringtheaterid);
        theater = theaterSystemEJB.getTheaterById(tid);
        return "Checkout.xhtml";
    }
    
    
	
    /* validatezipcode will check to see if the user's entered zip code
    is a string of five digits. If it is not, and error message reguarding
    its length is returned. If it is five digits, validatezipcode will check
    to see if it matches 75028, 75035, 75225, 75043, or 75080. If it does
    match any of those zip codes, an error message stating that the user
    needs to enter a zip code of 75028, 75035, 75043, 75080, or 75255.
    */
    public void validatezipcode(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String zipString = (String) value;
        if (zipString.length() != 5) {
            FacesMessage message = new FacesMessage("Invalid zip code length."
                    + " Please enter a 5 digit zip code.");
            throw new ValidatorException(message);
        }
        else {
            boolean found = false;
            if (zipString.equals("75028")) {
                found = true;
            }
            else if (zipString.equals("75043")) {
                found = true;
            }
            else if (zipString.equals("75080")) {
                found = true;
            }
            else if (zipString.equals("75035")) {
                found = true;
            }
            else if (zipString.equals("75225")) {
                found = true;
            }
            if (found == false) {
                   FacesMessage message = new FacesMessage("Invalid zip code."
                    + "Please enter 75035, 75028, 75080, 75043, or 75225.");
            throw new ValidatorException(message);
            }     
        }
    }
	
    /*validateCard checks if the user's entered credit card is 16 digits.
    If it does is not, an error message is returned.*/
    public void validateCard(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String cardString = (String) value;
        if (cardString.length() !=  16) {
            FacesMessage message = new FacesMessage("Invalid credit card length."
                    + " Please enter a 16 digit credit card number.");
            throw new ValidatorException(message);
        }
    }
}
