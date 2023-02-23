package Models;

public class Room extends Facility {
    private String freeService;

    public Room() {

    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String idService, String serviceName, double useArea, double price, int peopleMax, String rentalType, String freeService) {
        super(idService, serviceName, useArea, price, peopleMax, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + freeService;
    }
}
