package OrderDetails;

/**
 * Address class is used to store the address of the customer
 * It has the following attributes:
 * 1. Government
 * 2. District
 * 3. Building Info
 * 4. Land Marker
 * It has the following methods:
 * 1. Constructor
 * 2. Getters and Setters
 * 3. Display Address
 */
public class Address {

    String government;
    String district;
    String buildingInfo;
    String landMarker;
    /**
     * Default Constructor for Address Class
     */
    public Address() {
    }
    /**
     * Parameterized Constructor for Address Class
     * @param government
     * @param district
     * @param buildingInfo
     * @param landMarker
     */
    public Address(String government, String district, String buildingInfo, String landMarker) {
        this.government = government;
        this.district = district;
        this.buildingInfo = buildingInfo;
        this.landMarker = landMarker;
    }
    /**
     * get Government Method for Address Class
     * It returns the government of the customer
     * @return government
     */
    public String getGovernment() {
        return government;
    }
    /**
     * set Government Method for Address Class
     * It sets the government of the customer
     * @param government
     */
    public void setGovernment(String government) {
        this.government = government;
    }
    /**
     * get District Method for Address Class
     * It returns the district of the customer
     * @return district
     */
    public String getDistrict() {
        return district;
    }
    /**
     * set District Method for Address Class
     * It sets the district of the customer
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }
    /**
     * set Land Marker Method for Address Class
     * It sets the land marker of the customer
     * @param landMarker
     */
    public void setLandMarker(String landMarker) {
        this.landMarker = landMarker;
    }
    /**
     * get Land Marker Method for Address Class
     * It returns the land marker of the customer
     * @return landMarker
     */
    public String getLandMarker() {
        return landMarker;
    }
    /**
     * get Building Info Method for Address Class
     * It returns the building info of the customer
     * @return buildingInfo
     */
    public String getBuildingInfo() {
        return buildingInfo;
    }
    /**
     * set Building Info Method for Address Class
     * It sets the building info of the customer
     * @param buildingInfo
     */
    public void setBuildingInfo(String buildingInfo) {
        this.buildingInfo = buildingInfo;
    }
    /**
     * Display Address Method for Address Class
     * It displays the address of the customer
     */
    public void displayAddress() {
        System.out.println("Government: " + government);
        System.out.println("District: " + district);
        System.out.println("Building Info: " + buildingInfo);
        System.out.println("Land Marker: " + landMarker);
    }

}

