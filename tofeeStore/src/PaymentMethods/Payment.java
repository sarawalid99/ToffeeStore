package PaymentMethods;

import OrderDetails.Order;

/**
 * Abstract class for payment methods to be implemented by concrete payment methods
 */
public abstract class Payment {
    protected Order order;

    /**
     * method to pay for an order
     * @param order to be paid for
     */
    public void pay(Order order) {

    }


}
