import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String county;
    private String phone;
    private List<String> openHours;
    private String imageUrl;
    private String owner;
    private String classType;
    private double longitude;
    private double latitude;
    private String classDesc;
    private int index;

    public Restaurant(String id, String name, String description, String address, String city, String county,
                      String phone, List<String> openHours, String imageUrl, String owner, String classType,
                      double longitude, double latitude, String classDesc, int index) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.county = county;
        this.phone = phone;
        this.openHours = openHours;
        this.imageUrl = imageUrl;
        this.owner = owner;
        this.classType = classType;
        this.longitude = longitude;
        this.latitude = latitude;
        this.classDesc = classDesc;
        this.index = index;
    }

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

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getOpenHours() {
        return openHours;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getOwner() {
        return owner;
    }

    public String getClassType() {
        return classType;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", phone='" + phone + '\'' +
                ", openHours=" + openHours +
                ", imageUrl='" + imageUrl + '\'' +
                ", owner='" + owner + '\'' +
                ", classType='" + classType + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", classDesc='" + classDesc + '\'' +
                ", index=" + index +
                '}';
    }
}
