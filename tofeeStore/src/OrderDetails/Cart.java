package OrderDetails;

import java.util.HashMap;
import java.util.Map;

import ItemDetails.Item;

/**
 * Cart class is used to store the items that the user wants to buy.
 * It has a HashMap that stores the items and their quantity.
 * It has a kiloCapacity and piecesCapacity that are used to check if the cart is full.
 * It has methods to add, remove, increase or decrease the quantity of an item.
 * It has a method to calculate the total price of the items in the cart.
 * It has a method to display the items in the cart.
 */
public class Cart {

    private Map<Item, Integer> cartItem;
    private double kiloCapacity;
    private int piecesCapacity;
    /**
     * Constructor for Cart class.
     * It initializes the HashMap and the capacities.
     */
    public Cart() {
        this.cartItem = new HashMap<>();
        this.kiloCapacity = 0;
        this.piecesCapacity = 0;
    }

    /**
     * Getter for kiloCapacity.
     * @return kiloCapacity
     */
    public double getKiloCapacity() {
        return kiloCapacity;
    }
    /**
     * Getter for piecesCapacity.
     * @return piecesCapacity
     */
    public int getPiecesCapacity() {
        return piecesCapacity;
    }
    /**
     * Getter for cartItem.
     * @return cartItem
     */
    public Map<Item, Integer> getMap() {
        return cartItem;
    }

    /**
     * Method to add an item to the cart.
     * @param item to be added
     * @param quantity of the item to be added
     * If the cart is full, it prints a message.
     */
    public void addItem(Item item, int quantity) {
        if (piecesCapacity == 50) {
            System.out.println("Cart is full, can't add more items");
            return;
        }
        if (cartItem.containsKey(item)) {
            int currentQuantity = cartItem.get(item);
            if ((currentQuantity + quantity) <= item.getAvailability()) {
                cartItem.put(item, currentQuantity + quantity);
            } else {
                System.out.println("Not enough quantity");
            }
        } else {
            if (quantity <= item.getAvailability()) {
                cartItem.put(item, quantity);
            } else {
                System.out.println("Not enough quantity");
            }
        }
        piecesCapacity++;
    }
    /**
     * Method to remove an item from the cart.
     * @param item to be removed
     */
    public void removeItem(Item item) {
        cartItem.remove(item);
        piecesCapacity--;
    }
    /**
     * Method to check if the cart is empty.
     * @return true if the cart is empty, false otherwise
     */
    public boolean isEmpty() {
        return cartItem.isEmpty();
    }
    /**
     * Method to decrease the quantity of an item.
     * @param itemName of the item to be decreased
     * @param quantity of the item to be decreased
     * If the quantity of the item is 0, it removes the item from the cart.
     */
    public void decreaseQuantity(String itemName, int quantity) {
        for (Item item : cartItem.keySet()) {
            if (item.getName().equals(itemName)) {
                int currentQuantity = cartItem.get(item);
                if ((currentQuantity - quantity) > 0) {
                    cartItem.put(item, currentQuantity - quantity);
                } else {
                    cartItem.remove(item);
                }
                break;
            }
        }
    }
    /**
     * Method to increase the quantity of an item.
     * @param itemName of the item to be increased
     * @param quantity of the item to be increased
     */
    public void increaseQuantity(String itemName, int quantity) {
        for (Item item : cartItem.keySet()) {
            if (item.getName().equals(itemName)) {
                int currentQuantity = cartItem.get(item);
                cartItem.put(item, currentQuantity + quantity);
                break;
            }
        }
    }
    /**
     * Method to calculate the total price of the items in the cart.
     * @return totalPrice
     */
    public double calcTotalPrice() {
        double totalPrice = 0;
        for (Item item : cartItem.keySet()) {
            int quantity = cartItem.get(item);
            totalPrice += item.getPrice() * quantity;
        }
        return totalPrice;
    }
    /**
     * Method to display the items in the cart.
     * If the cart is empty, it prints a message.
     * If the cart is not empty, it prints the items and their quantity and price.
     */
    public void displayCart() {
        if (cartItem.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart items:");
            for (Item item : cartItem.keySet()) {
                int quantity = cartItem.get(item);
                System.out.println("- " + quantity + " x " + item.getName() + " (" + item.getPrice() + " each)");
            }
        }
    }

}

