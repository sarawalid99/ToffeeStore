package ItemDetails;

/**
 * Catalog class is used to store the categories of the items.
 * It has a list of categories and the number of categories.
 * It has a method to get the category by name.
 * It has a method to get the names of the categories.
 * It has a method to set the categories.
 * It has a method to set the number of categories.
 */
public class Catalog {

    public Category[] categories = null;
    private int numberOfCategories;

    /**
     * Constructor of the Catalog class.
     * It initializes the number of categories to 0 and the list of categories to a new array of 10 categories.
     */
    public Catalog() {
        this.numberOfCategories = 5;
        this.categories = new Category[numberOfCategories];
    }

    /**
     * method to set the number of categories.
     * @param numberOfCategories to be set.
     */
    public void setNumberOfCategories(int numberOfCategories) {
        this.numberOfCategories = numberOfCategories;
    }
    /**
     * method to get the number of categories.
     * @return int
     * It returns the number of categories.
     */
    public int getNumberOfCategories() {
        return this.numberOfCategories;
    }
    /**
     * method to set the categories.
     * @param categories to be set.
     * It sets the categories to the list of categories.
     */
    public void setCategories(Category[] categories) {
        categories[0] = new Category("Chocolate");
        categories[1] = new Category("Gum");
        categories[2] = new Category("Lollipop");
        categories[3] = new Category("Toffee");
        categories[4] = new Category("Marshmallow");
    }
    /**
     * method to get the names of the categories.
     * It prints the names of the categories.
     */
    public void getCategoriesNames() {
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.print("{ " + this.categories[i].getName() + " }  ");
        }
    }
    /**
     * method to get the category by name.
     * @param name of the category to be returned.
     * @return Category
     * It returns the category with the given name.
     */
    public Category getCategory(String name) {
        for (int i = 0; i < this.numberOfCategories; i++) {
            if (this.categories[i].getName().equals(name)) {
                return this.categories[i];
            }
        }
        return null;
    }

}
