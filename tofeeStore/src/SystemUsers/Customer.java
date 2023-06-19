package SystemUsers;

import OrderDetails.Cart;
import OrderDetails.Order;

import java.util.Vector;

/**
 * Customer class is a subclass of GeneralUser class.
 * It contains the details of the customer.
 * It contains the cart of the customer.
 * It contains the orders of the customer.
 */
public class Customer extends GeneralUser {
    public Cart cart;
    Vector<Order> orders;

    public int noOfOrders;
    /**
     * Constructor for Customer class.
     * It initializes the cart and orders of the customer.
     */
    public Customer() {
        super();
        noOfOrders = 0;
        cart = new Cart();
        orders = new Vector<Order>();
    }
    /**
     * method to view the profile of the customer.
     * It displays the details of the customer.
     * It displays the cart of the customer.
     * It displays the orders of the customer.
     */
    public void viewProfile() {
        System.out.println("Name: " + this.getUsername());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone Number: " + this.getPhoneNum());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Number of Orders: " + noOfOrders);
        System.out.println("Cart: ");
        cart.displayCart();
        System.out.println("Orders: ");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order " + i + ": ");
            orders.elementAt(i).displayOrderDetails();
        }
    }
    /**
     * method to add an order to the orders of the customer.
     * @param order
     */
    public void createOrder(Order order) {
        orders.add(order);
    }
    /**
     * method to cancel an order of the customer.
     * @param id
     */
    public void cancelOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (i == id) {
                orders.removeElement(orders.elementAt(i));
            }
        }
    }

}
