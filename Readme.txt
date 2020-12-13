TheaterSystem will allow an user to enter a supported zip code,
select a theater from a list of theaters in the entered zip code,
see movies playing at the selected theater,
select a movie and see its show times, and
buy tickets to the selected movie.  TheaterSystem uses a
database named MovieDB, which is found in SQL.sql to fetch a
zip code's theaters, a theater's movies, and a movie's show times. 

List of Files
Web Files

TheaterLookup.xhtml - TheaterLookup asks the user to input a five digit
zip code and supports the zip codes 75035, 75028, 75255, 75043, and 75080.
If the entered zip code is not five digits or is  a unsupported zip code,
an error message is displayed. Once the user enters the zipcode, they
are taken to TheaterList.xhtml

TheaterList.xhtml - TheaterList.xhtml will display a list of theaters for
the user's enter zip code, and next to each theater displayed is a link
to TheaterMovies.xhtml, which will display the theater's movies. TheaterList
also contains a link back to TheaterLookup.xhtml.

TheaterMovies.xhtml - TheaterMovies shows a list of titles for the user's
selected theater. Each movie title is a link that will take the user to
MovieInformation.xhtml, which will display the movie's details.
TheaterMovies.xhtml also contains a link back to TheaterList.xhtml.

MovieInformation.xhtml will display the user's selected movie's title,
release year, description, and run time in minutes.
MovieInformation.xhtml contains two links. One will go back to
TheaterMovies.xhtml, and the other will go to MovieShowTimes.xhtml.

MovieShowTimes.xhtml - MovieShowTimes.xhtml will show the movie's show times,
and clicking on a show time will add the movie to the cart and display
ItemAdded.xhtml. MovieShowTimes.xhtml also has a link that will allow
the user to go back to MovieInformation.xhtml.

NumberOfTickets.xhtml - NumberOfTickets will allow the user to select their
desired number of tickets. From NumberOfTickets.xhtml, the user can either
go back MovieShowTimes.xhtml or to ItemsAdded.xhtml.

ItemAdded.xhtml - ItemAdded.xhtml will notify the user that their movie
has been added to their cart, and allows user to either go back to
MovieShowTimes.xhtml or to checkout.xhtml.

Checkout.xhtml - checkout.xhtml will display the items in the user cart and the
cart's total. Additionally, checkout.xhtml will ask the user to enter a 16 digit
credit card. If the entered credit card number is not 16 digits, an error message
is displayed.  Upon submission, the user is taken to Conformation.xhtml.

Conformation.xhtml - Conformation.xhtml thanks the user for their order
and provides a link back to TheaterLookup.xhtml.

Template.xhtml - Template.xhtml will changes the jsf page's background color as well
as provides a space for the page's header.

CDI Bean Files 
CartBean.java - Along with TheaterCartEJB, CartBean.java manages the user's
cart and handles all cart-related actions.

TheaterSystemBean.java - TheaterSystemBean.java controls the navigation between
pages and calls upon TheaterSystemEJB to access MovieDB.
 

EBJ Files
Item.java - Item.java is used to create item objects, which will hold
a movie's title and show time and will be used to create an array list 
of Items, which will function as the user's cart.

TheaterCartEJB.java - TheaterCartEJB.java provides methods to manage
the user's cart, such as addItem, calculateTotal, and clearCart.

TheaterSystemEJB.java - TheaterSystemEJB.java provides methods to
access MovieDB via named queries. 

Entity Files
Theater.java - Theater.java is an Theater entity and contains
a theater's id, address, phone number, and name. Theater.java
will provide named queries for TheaterSystemEJB that will return
either a single or a list of theater objects, which are used
by TheaterSystemBean.

Movies.java - Movies.java is an Movies entity and contains
a movie's id, title, description, runtime, and release year.
Movies. java will provide named queries for
TheaterSystemEJB that will return either a single or a list of
Movies objects, which are used by TheaterSystemBean

Times.java - Times.java is an Times entity and contains
a time's id and time will provide named queries for
TheaterSystemEJB that will return either a single or a list of
Times objects, which are used by TheaterSystemBean.

All movie posters used in the project are property of their respective studios.