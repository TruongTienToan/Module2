package Models;

public abstract class Facility {
    private String idService;
    private String serviceName;
    private double useArea;
    private double price;
    private int peopleMax;
    private String rentalType;

    public Facility() {

    }

    public Facility(String idService, String serviceName, double useArea, double price, int peopleMax, String rentalType) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.price = price;
        this.peopleMax = peopleMax;
        this.rentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return idService +
                ", " + serviceName +
                ", " + useArea +
                ", " + price +
                ", " + peopleMax +
                ", " + rentalType;
    }
}
