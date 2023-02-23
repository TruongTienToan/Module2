package Models;


import java.time.LocalDate;

public class Booking implements Comparable<Booking>{
    private String bookingId;
    private LocalDate startDay;
    private LocalDate endDay;
    private String customerId;
    private String serviceName;

    public Booking() {

    }

    public Booking(String bookingId, LocalDate startDay, LocalDate endDay, String customerId, String serviceName) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString(){
        return
                bookingId +
                        ", " + startDay +
                        ", " + endDay +
                        ", " + customerId +
                        ", " + serviceName;
    }


    @Override
    public int compareTo(Booking o) {
        if (this.getStartDay().compareTo(o.getStartDay()) == 0) {
            if (this.getEndDay().compareTo(o.getEndDay()) == 0) {
                return this.getBookingId().compareTo(o.getBookingId());
            }
            else {
                return this.getEndDay().compareTo(o.getEndDay());
            }
        }
        return this.getStartDay().compareTo(o.getStartDay());
    }
}
