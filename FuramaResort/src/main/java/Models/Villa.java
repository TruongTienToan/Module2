package Models;

public class Villa extends Facility{
    private String roomStandard;
    private long poolArea;
    private int numberFloors;


    public Villa(String roomStandard, long poolArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String idService, String serviceName, double useArea, double price, int peopleMax, String rentalType, String roomStandard, long poolArea, int numberFloors) {
        super(idService, serviceName, useArea, price, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String codeService, String nameService, double usableArea, double rentalCosts, int maximumPeople, String rentalType, int roomStandard, double poolArea, int numberOfFloor) {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public long getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(long poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + roomStandard +
                ", " + poolArea +
                ", " + numberFloors;
    }
}
