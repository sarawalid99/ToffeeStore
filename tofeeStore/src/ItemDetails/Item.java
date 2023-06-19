package ItemDetails;

/**
 * This class is used to store the details of an item.
 * It contains the name, description, price, category, discount, status and availability of an item.
 * It contains the getters and setters for the above mentioned attributes.
 * It contains a constructor to initialize the attributes.
 */
public class Item {
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private int discount;
    private String status;
    private int availability;

    /**
     * This is a default constructor.
     * It initializes the attributes to default values.
     */
    public Item() {
        this.name = "";
        this.description = "";
        this.price = 0.0;
        this.categoryName = "";
        this.discount = 0;
        this.status = "";
        this.availability = 0;
    }
    /**
     * This is a parameterized constructor.
     * It initializes the attributes to the values passed as parameters.
     * @param name Name of the item.
     * @param description Description of the item.
     * @param price Price of the item.
     * @param category Category of the item.
     * @param discount Discount on the item.
     * @param status Status of the item.
     * @param availability Availability of the item.
     */
    public Item(String name, String description, double price, String category, int discount, String status, int availability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryName = category;
        this.discount = discount;
        this.status = status;
        this.availability = availability;
    }
    /**
     * This method is used to get the name of the item.
     * @return Name of the item.
     */
    public String getName() {
        return this.name;
    }
    /**
     * This method is used to get the description of the item.
     * @return Description of the item.
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * This method is used to get the price of the item.
     * @return Price of the item.
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * This method is used to get the category of the item.
     * @return Category of the item.
     */
    public String getCategory() {
        return this.categoryName;
    }
    /**
     * This method is used to get the discount on the item.
     * @return Discount on the item.
     */
    public int getDiscount() {
        return this.discount;
    }
    /**
     * This method is used to get the status of the item.
     * @return Status of the item.
     */
    public String getStatus() {
        return this.status;
    }
    /**
     * This method is used to get the availability of the item.
     * @return Availability of the item.
     */
    public int getAvailability() {
        return this.availability;
    }
    /**
     * This method is used to set the name of the item.
     * @param name Name of the item.
     */
    public void setName(String name) {
        this.name = name;
        return;
    }
    /**
     * This method is used to set the description of the item.
     * @param description Description of the item.
     */
    public void setDescription(String description) {
        this.description = description;
        return;
    }
    /**
     * This method is used to set the price of the item.
     * @param price Price of the item.
     */
    public void setPrice(double price) {
        this.price = price;
        return;
    }
    /**
     * This method is used to set the category of the item.
     * @param category Category of the item.
     */
    public void setCategory(String category) {
        this.categoryName = category;
        return;
    }
    /**
     * This method is used to set the discount on the item.
     * @param discount Discount on the item.
     */
    public void setDiscount(int discount) {
        this.discount = discount;
        return;
    }
    /**
     * This method is used to set the status of the item.
     * @param status Status of the item.
     */
    public void setStatus(String status) {
        this.status = status;
        return;
    }
    /**
     * This method is used to set the availability of the item.
     * @param availability Availability of the item.
     */
    public void setAvailability(int availability) {
        this.availability = availability;
        return;
    }
}
