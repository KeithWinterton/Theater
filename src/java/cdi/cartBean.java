/* cartBean.java will manage the user's cart by calling TheaterCartEJB's
methods. */
package cdi;

import ejb.Item;
import ejb.TheaterCartEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Keith
 */
@Named(value = "cartBean")
@SessionScoped
public class cartBean implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
    @EJB
    /*theaterCartEJB will help manage the user's cart.*/
    private TheaterCartEJB theaterCartEJB;
	
    /*zipcode will be used to pass the zipcode parameter back to TheaterSystemBean. */
    private String zipcode = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("zipcode");
			
    /*stringtheaterid will be used to pass the theaterid parameter back to TheaterSystemBean. */
    private String stringtheaterid = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("theaterid");
	
    /*stringtheaterid will be used to pass the theaterid parameter back to TheaterSystemBean. */
    private String stringmovieid = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("movieid");
    

    /*title will hold the movie's title*/
    private String title = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("title");
    
    /*time will hold the movie's times*/
    private String time = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("time");
   
    /*MovieAddedConfirm will be used to inform the user their item was added
    to the cart.*/
    private String MovieAddedConfirm;
    
    /*total will hold the price of the total price of the movie tickets.*/
    private String total;
    
    /*numberOfTickets will hold ther user's selected number of tickets.*/
    private String numberOfTickets; 
    
    /*getters and setters */
    public cartBean() {
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
    
    public String getMovieAddedConfirm() {
        return MovieAddedConfirm;
    }

    public void setMovieAddedConfirm(String MovieAddedConfirm) {
        this.MovieAddedConfirm = MovieAddedConfirm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal() {
        return total;
    }
    
    public void setTotal(String total) {
        this.total = theaterCartEJB.calculateTotal();
    }

    public String getNumberOftickets() {
        return numberOfTickets;
    }

    public void setNumberOftickets(String numberOftickets) {
        this.numberOfTickets = numberOftickets;
    }
    
    
     public ArrayList<Item> getCartList() {
	return theaterCartEJB.getCart();
    }
    
    
    /*addMovieToCart does not accept any parameters and returns an string.
    addMovieToCart will get the title and time parameters from a JSF page
    and then call theaterCartEJB's addItemToCart method using the title
    and time. Then MovieAddedConfirm is set so that it can inform the
    user their movie was added to the cart on the ItemAdded page.
    ItemAdded is then returned to navigate to ItemsAdded.xhtml.*/
    public String addMovieToCart() {
        int tickets = Integer.parseInt(numberOfTickets);
        for (int i = 0; i < tickets; i++) {
            theaterCartEJB.addItemToCart(title, time);
        }
        MovieAddedConfirm = tickets + " " +  title + " " + time +  " added to cart.";
        return "ItemAdded.xhtml";
    }
    /*ToNumberOfTickets does not accept anyParametters and returns a string.
    ToNumberOfTickets will pass the title as time as parameters and
    navigate the NumberIfTickets.xhtml.*/
    public String toNumberOfTickets() {
        title = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("title");
        time = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("time");
        return "NumberOfTickets.xhtml";
    }
    
      /*showTicketTotal does not accept any parameters and returns a string.
      showTicketTotal will return the cost of the tickets in the user's cart.*/
      public String showTicketTotal() {
          return theaterCartEJB.calculateTotal();
      
      }
      
        /* clearcart does not accept any parameters and returns a string.
        clearcart will clear the user's cart and navigate to TheaterLookup.xhtml*/
      public String clearCart() {
          theaterCartEJB.clearCart();
          return "TheaterLookup.xhtml";
      }
}
