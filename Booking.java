import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private Date checkIn;
    private Date checkOut;
    private int roomNumber;
    private int userId;

    public Booking(int userId,int roomNumber,Date checkIn,Date checkOut){
        this.userId=userId;
        this.roomNumber=roomNumber;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public boolean overlaps(Date in, Date out) {
        return !(checkOut.before(in) || checkIn.after(out));
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Booking { User ID: " + userId +
                ", Room Number: " + roomNumber +
                ", Check-in: " + sdf.format(checkIn) +
                ", Check-out: " + sdf.format(checkOut) + " }";
    }

}
