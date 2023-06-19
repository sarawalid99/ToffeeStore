package ItemDetails;

import java.util.Objects;

/**
 * Category class is used to create a category object which contains the name of
 * the category, the items in the category and the number of items in the
 * category.
 *
 * @version 1.0
 * @since 2018-11-16
 */
public class Category {

    private String name;
    public Item[] items;
    private int numberOfItems;

    /**
     * Constructor for the Category class.
     */
    public Category() {
        this.name = "";
        this.items = new Item[10];
        this.numberOfItems = 0;
    }
    /**
     * Constructor for the Category class.
     * @param name The name of the category.
     */
    public Category(String name) {
        this.name = name;
        this.items = new Item[10];
        this.numberOfItems = 10;
    }

    /**
     * This method is used to get the name of the category.
     * @return String This returns the name of the category.
     */
    public String getName() {
        return this.name;
    }
    /**
     * This method is used to get the items in the category.
     * @return Item[] This returns the items in the category.
     */
    public int getNumberOfItems() {
        return this.numberOfItems;
    }
    /**
     * This method is used to set the name of the category.
     * @param name The name of the category.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method is used to set the items in the category.
     */
    public void setItems() {
        items[0] = new Item("Dark Chocolate", "Dark chocolate is a solid chocolate confectionery containing cocoa, sugar and milk.", 3.50, "Chocolate", 0, "Available", 100);
        items[1] = new Item("White Chocolate", "White chocolate is a solid chocolate confectionery containing cocoa, sugar and milk.", 1.50, "Chocolate", 0, "Available", 100);
        items[2] = new Item("Toffee pudding", "Toffee pudding is a solid chocolate confectionery containing cocoa, sugar and milk.", 4, "Toffee", 0, "Available", 100);
        items[3] = new Item("Toffee Apple", "Toffee apple is a solid chocolate confectionery containing cocoa, sugar and milk.", 3, "Toffee", 0, "Available", 100);
        items[4] = new Item("Strawberry Gum", "Strawberry gum is a solid chocolate confectionery containing cocoa, sugar and milk.", 0.50, "Gum", 0, "Available", 100);
        items[5] = new Item("Mint Gum", "Mint gum is a solid chocolate confectionery containing cocoa, sugar and milk.", 0.50, "Gum", 0, "Available", 100);
        items[6] = new Item("Strawberry Lollipop", "Strawberry lollipop is a solid chocolate confectionery containing cocoa, sugar and milk.", 2.50, "Lollipop", 0, "Available", 100);
        items[7] = new Item("Raspberry Lollipop", "Strawberry lollipop is a solid chocolate confectionery containing cocoa, sugar and milk.", 1.75, "Lollipop", 0, "Available", 100);
        items[8] = new Item("vanilla marshmallow", "Vanilla marshmallow is a solid chocolate confectionery containing cocoa, sugar and milk.", 8.50, "Marshmallow", 0, "Available", 100);
        items[9] = new Item("Strawberry marshmallow", "Strawberry marshmallow is a solid Strawberry confectionery containing cocoa, sugar and milk.", 5.50, "Marshmallow", 0, "Available", 100);
    }
    /**
     * This method is used to get the items in the category.
     * @param category The category of the items.
     */
    public void getItems(String category) {
        for (int i = 0; i < this.numberOfItems; i++) {
            if (Objects.equals(this.items[i].getCategory(), category)) {
                System.out.println(this.items[i].getName());
            }
        }
    }

}
