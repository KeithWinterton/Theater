/*TheaterCartEJB.java will manage an arrayList, which will serve as a cart for
the user TheaterCartEJB contains methods to add an item to the cart, calculate
the total based upon the number of items, and clear the cart. 
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author Keith
 */
@Stateful
public class TheaterCartEJB {
    
    /*cart is an arraylist that will hold a list of user movies.*/
    private ArrayList<Item> cart = new ArrayList<>();
   
    /*getter and setters*/
    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
    
    /*addItemToCart accepts two strings as parameters and returns X.
    addUtemToCart will create a new item with the parameters passed in
    and add that item to the cart.*/
     public ArrayList<Item> addItemToCart(String name, String time) {
        Item item = new Item(name, time);
        cart.add(item);
        return cart;
    }
     
    /* calculateTotal does not accept anything and returns a string.
    calculateTotal will calculate the cost of the tickets by 
    multiplying the number of items in the cart by 10. This total
    is then formatted and returned as a string. */
    public String calculateTotal() {
        int total = cart.size() * 10;
        return "The final price is $" + total + ".00.";
    }
    
    /*clearCart neither accept anything nor returns anything. ClearCart
    will clear the cart.*/
    public void clearCart() {
        cart.clear();
    }   
}


