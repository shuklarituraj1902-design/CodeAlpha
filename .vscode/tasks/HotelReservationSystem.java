import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rooms = 5;
        int choice, roomNo;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Available Rooms: " + rooms);
                    break;

                case 2:
                    if (rooms > 0) {
                        System.out.print("Enter Room Number to Book: ");
                        roomNo = sc.nextInt();
                        rooms--;
                        System.out.println("Room " + roomNo + " Booked Successfully!");
                    } else {
                        System.out.println("No Rooms Available!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    roomNo = sc.nextInt();
                    rooms++;
                    System.out.println("Room " + roomNo + " Booking Cancelled!");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 4);
    }
}