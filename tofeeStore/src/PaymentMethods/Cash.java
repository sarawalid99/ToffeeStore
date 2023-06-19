package PaymentMethods;

import OrderDetails.Order;

/**
 * Cash class is a subclass of Payment class
 * that implements the pay method to calculate the total price of the order
 * and print it to the user
 */
public class Cash extends Payment{

    /**
     * pay method is used to calculate the total price of the order and print it to the user
     * @param order is an object of Order class
     */
    public void pay(Order order){
        int shippingPrice = 20;
        double priceOfOrder = order.getTotalPrice();
        double total = shippingPrice + priceOfOrder;
        System.out.println("Total price = " + total + " LE");
    }

}
