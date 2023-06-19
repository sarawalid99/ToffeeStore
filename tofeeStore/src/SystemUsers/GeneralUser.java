package SystemUsers;

import OrderDetails.Address;

/**
 * This class is the parent class for all the users in the system
 * It contains the general information for all the users
 * It contains the getters and setters for the general information
 * It contains the constructor for the general information of the user
 */
public class GeneralUser {

    private String username;
    private String password;
    private String email;
    private Address address;
    private String phoneNumber;

    /**
     * method to get the username
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * method to set the username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * method to get the password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * method to set the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * method to get the email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * method to set the email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * method to get the address
     * @return address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * method to set the address
     * @param government
     * @param district
     * @param buildingInfo
     * @param landMarker
     */
    public void setAddress(String government, String district, String buildingInfo, String landMarker) {
        address.setBuildingInfo(buildingInfo);
        address.setDistrict(district);
        address.setGovernment(government);
        address.setLandMarker(landMarker);
        this.address = address;

    }
    /**
     * method to get the phone number
     * @return phoneNumber
     */
    public String getPhoneNum() {
        return phoneNumber;
    }
    /**
     * method to set the phone number
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNumber = phoneNum;
    }

}
