import OrderDetails.Order;
import OrderDetails.Address;
import PaymentMethods.Cash;
import RegistrationSystems.Login;
import RegistrationSystems.Registration;
import SystemUsers.Customer;
import SystemUsers.GeneralUser;
import ItemDetails.Catalog;
import ItemDetails.Item;


import java.util.Objects;
import java.util.Scanner;

/**
 * This class is the main class of the project
 * It contains the main method
 * It is responsible for displaying the menu and handling the user's input
 */
public class Toffee {

    //    Admin[] admins;
    private Customer[] customers;
    private Catalog catalog;

    /**
     * This is the constructor of the class
     * It initializes the catalog and the customers array
     */
    public Toffee() {
        this.catalog = new Catalog();
        this.customers = new Customer[10];
    }

    /**
     * This method displays the catalog of items and the categories
     */
    public void displayCatalog() {
        this.catalog.setNumberOfCategories(5);
        this.catalog.setCategories(this.catalog.categories);
        System.out.println("Here are the categories of items we have : ");
        this.catalog.getCategoriesNames();
        System.out.println();
        System.out.println("Here are the items we have: ");
        for (int i = 0; i < this.catalog.getNumberOfCategories(); i++) {
            System.out.println(this.catalog.categories[i].getName() + " - Category {");
            this.catalog.categories[i].setItems();
            this.catalog.categories[i].getItems(this.catalog.categories[i].getName());
            System.out.println("}");
        }
    }

    /**
     * This method searches for an item in the catalog
     * @param itemName of the item to be added to the cart
     * @return the item to be added to the cart
     */
    public Item searchItem(String itemName) {
        for (int i = 0; i < this.catalog.getNumberOfCategories(); i++) {
            for (int j = 0; j < this.catalog.categories[i].getNumberOfItems(); j++) {
                if (Objects.equals(this.catalog.categories[i].items[j].getName(), itemName)) {
                    return this.catalog.categories[i].items[j];
                }
            }
        }
        return null;
    }

    /**
     * This method displays the menu and handles the user's input
     * @throws Exception if the user enters an invalid input
     */
    public void displayMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to Toffee store");
            System.out.println("Choose an operation to perform");
            System.out.print("1-Register\n 2-Login\n 3-Display Catalouge\n 4-Exit\n");
            choice = scanner.nextInt();
            if (choice == 1) {
                GeneralUser user = new GeneralUser();
                Registration register = new Registration(user);
                register.SignUp();
                System.out.println("Login please");
                choice = 2;

            } else if (choice == 2) {
                Customer user = new Customer();
                Login login = new Login(user);
                while (!login.login()) {
                    login.login();
                }
                displayCatalog();
                System.out.println("Enter number of items you want to add to cart");
                int numberOfItems;
                numberOfItems = scanner.nextInt();
                while (numberOfItems > 0) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Choose item to add to cart");
                    String item;
                    item = scan.nextLine();

                    System.out.println("Choose quantity");
                    int quantity;
                    quantity = scan.nextInt();
                    user.cart.addItem(searchItem(item), quantity);
                    numberOfItems--;
                }
                System.out.println("Your cart contains: ");
                user.cart.displayCart();
                System.out.println("Do you want to checkout? (y/n)");
                String checkout;
                checkout = scanner.next();
                if (Objects.equals(checkout, "y")) {
                    Scanner scanAdd = new Scanner(System.in);
                    double total = user.cart.calcTotalPrice();

                    System.out.println("Enter address to ship to");
                    System.out.print("Enter your government: ");
                    String government = scanAdd.nextLine();

                    System.out.print("Enter your district: ");
                    String district = scanAdd.nextLine();

                    System.out.print("Enter your building info: ");
                    String buildingInfo = scanAdd.nextLine();

                    System.out.print("Enter your land marker: ");
                    String landMarker = scanAdd.nextLine();
                    Address shipAddress = new Address();
                    shipAddress.setDistrict(district);
                    shipAddress.setGovernment(government);
                    shipAddress.setBuildingInfo(buildingInfo);
                    shipAddress.setLandMarker(landMarker);
                    System.out.print("Enter your loyalty points :");
                    int loyaltyPoints = scanAdd.nextInt();

                    Order order = new Order(total, shipAddress, "Cash", loyaltyPoints, user.cart);
                    order.displayOrderDetails();
                    user.createOrder(order);
                    if (order.confirm()) {
                        System.out.println("Order confirmed");
                        Cash cash = new Cash();
                        cash.pay(order);
                    } else {
                        System.out.println("Order not confirmed");
                    }
                } else {
                    System.out.println("Thank you for shopping with us");
                }
            } else if (choice == 3) {
                displayCatalog();
            } else if (choice == 4) {
                break;
            }

        } while (choice != 4);
    }

}

