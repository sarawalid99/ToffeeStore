package OrderDetails;
import ItemDetails.Item;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Order class is used to store the details of the order placed by the user.
 * It contains the following attributes:
 * totalPrice: total price of the order
 * address: address of the user
 * paymentMethod: payment method used by the user
 * loyaltyPoint: loyalty points earned by the user
 * checkoutDate: date on which the order was placed
 * numOfItems: number of items in the order
 * itemsOrdered: list of items ordered by the user
 */
public class Order {

    private double totalPrice;
    private  Address address;
    private String paymentMethod;
    private int loyaltyPoint;
    private String checkoutDate;
    private int numOfItems;
    private Cart itemsOrdered;

    /**
     * Parameterized constructor to initialize the attributes of the Order class
     */
    public Order(double totalPrice, Address address, String paymentMethod, int loyaltyPoint, Cart itemsOrdered) {
        this.totalPrice = totalPrice;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.loyaltyPoint = loyaltyPoint;
        this.itemsOrdered = itemsOrdered;
    }

    /**
     * method to get checkout date of the order
     * @return checkout date of the order
     */
    public String getCheckoutDate() {
        return checkoutDate;
    }
    /**
     * method to set checkout date of the order
     * @param checkoutDate checkout date of the order
     */
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * method to get items ordered by the user
     * @return items ordered by the user
     */
    public Cart getItemsOrdered() {
        return itemsOrdered;
    }
    /**
     * method to set number of items ordered by the user
     * @param numOfItems items ordered by the user
     */
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    /**
     * method to get number of items ordered by the user
     * @return number of items ordered by the user
     */
    public int getNumOfItems() {
        return numOfItems;
    }
    /**
     * method to set address of the user who placed the order
     * @param address address of the user who placed the order
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * method to get total price of the order
     * @return total price of the order
     */
    public double getTotalPrice() {
        return totalPrice;
    }
    /**
     * method to get payment method used by the user
     * @return payment method used by the user
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }
    /**
     * method to set loyalty points earned by the user
     * @param loyaltyPoint loyalty points earned by the user
     */
    public void setLoyaltyPoint(int loyaltyPoint) {
        this.loyaltyPoint = loyaltyPoint;
    }
    /**
     * method to set total price of the order
     * @param totalPrice total price of the order
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    /**
     * method to set payment method used by the user
     * @param paymentMethod payment method used by the user
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    /**
     * method to set items ordered by the user
     * @param itemsOrdered items ordered by the user
     */
    public void setItemsOrdered(Cart itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }
    /**
     * method to display the details of the order
     * It displays the following details:
     * address of the user
     * payment method used by the user
     * items ordered by the user
     * total cost of the order
     */
    public void displayOrderDetails() {
        System.out.println("Address : ");
        address.displayAddress();
        System.out.println("Payment method : " + getPaymentMethod());
        itemsOrdered.displayCart();
        System.out.println("Total cost = " + itemsOrdered.calcTotalPrice());
    }
    /**
     * method to ask the user to confirm the order
     * @return true if the user confirms the order, false otherwise
     */
    public boolean confirm() {
        System.out.println("Do you want to confirm order?");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.next();
        if (Objects.equals(c, "Yes")) {
            return true;
        } else {
            return false;
        }
    }

}
