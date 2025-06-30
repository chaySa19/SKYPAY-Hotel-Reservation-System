import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Service {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Users> users= new ArrayList<>();
    ArrayList<Booking> bookings= new ArrayList<>();

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight){
        Room newRoom= new Room(roomNumber,roomType,roomPricePerNight);
        if(rooms.contains(newRoom)){
            System.out.println("Room already exists.");
        }else{
            rooms.add(newRoom);
            System.out.println("Room added.");

        }

    };
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut){


        if(checkOut.before(checkIn)){
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }

        Room room = rooms.get(roomNumber-1);
        int price = room.getRoomPricePerNight();
        int balance = users.get(userId-1).getBalance();
        long period = TimeUnit.DAYS.convert(checkOut.getTime() - checkIn.getTime(), TimeUnit.MILLISECONDS);

        for (Booking booking:bookings) {
            if(booking.getRoomNumber() == roomNumber && booking.overlaps(checkIn,checkOut)){
                System.out.println("The room is not free.");
                break;
            }
        }

        if(room.getRoomPricePerNight()*period>balance){
            System.out.println("Insufficient balance.");
        }else{
            bookings.add(new Booking(userId,roomNumber,checkIn,checkOut));
            System.out.println("Booking successful.");

        }

    };
    void printAll(){

        System.out.println("----ROOMS-----");
        for (Room room:rooms
             ) {
            System.out.println(room.toString());
        }
        System.out.println("----BOOKINGS-----");
        bookings.sort(Comparator.comparing(Booking::getCheckIn).thenComparing(Booking::getCheckOut));
        for (Booking booking:bookings
        ) {
            System.out.println(booking.toString());
        }

    };
    void setUser(int userId, int balance){
        Users newUser = new Users(userId,balance);
        if(users.contains(newUser)){
            System.out.println("User already exists");
        }
        users.add(new Users(userId,balance));
        System.out.println("User added.");

    };
    void printAllUsers(){
        System.out.println("----Users-----");
        for (Users user:users
        ) {
            System.out.println(user.toString());
        }
    };
}
