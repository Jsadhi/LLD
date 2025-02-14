import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> stations= Arrays.asList("A","B","C","D","E");
        TicketBookingService BookingService = new TicketBookingService(stations);
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("1. Book Tickets");
            System.out.println("2. cancel Tickets");
            System.out.println("3. printChart");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                {
                    System.out.println("Enter starting point: ");
                    String Source = scanner.next();
                    System.out.println("Enter Ending point");
                    String Destination = scanner.next();
                    System.out.println("Enter number of tickets: ");
                    int numberOfTickets = scanner.nextInt();
                    BookingService.book(Source, Destination, numberOfTickets);
                    break;
                }
                case 2: {
                    System.out.println("Enter PNR: ");
                    int PNR = scanner.nextInt();
                    System.out.println("Enter number of tickets: ");
                    int count = scanner.nextInt();
                    BookingService.Cancel(PNR, count);
                    break;
                }
                case 3: {
                    System.out.println("chart: ");
                    BookingService.Print();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
