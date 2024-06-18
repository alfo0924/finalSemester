public class Restaurant {
    private String id;
    private String name;
    private String description;
    private String address;
    private String zipCode;
    private String region;
    private String town;
    private String tel;
    private double pointX;
    private double pointY;
    private int rstClass;

    // Constructor to initialize all member variables
    public Restaurant(String id, String name, String description, String address, String zipCode,
                      String region, String town, String tel, double pointX, double pointY, int rstClass) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.zipCode = zipCode;
        this.region = region;
        this.town = town;
        this.tel = tel;
        this.pointX = pointX;
        this.pointY = pointY;
        this.rstClass = rstClass;
    }

    // Getter methods for all member variables
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getRegion() {
        return region;
    }

    public String getTown() {
        return town;
    }

    public String getTel() {
        return tel;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public int getRstClass() {
        return rstClass;
    }
}
