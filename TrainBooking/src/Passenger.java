import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Passenger {
    private static int Id;
    private final int PNR;
    private final String Source;
    private final String Destination;
    private int NoOfPassengers;
    private ArrayList<Integer> SeatNumbers=null;

    public Passenger(String source, String destination, int noOfPassengers) {
        this.PNR = generatePNR();
        Source = source;
        Destination = destination;
        NoOfPassengers = noOfPassengers;
    }

    private int generatePNR() {
        return ++Id;
    }

    public int getPNR() {
        return PNR;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public int getNoOfPassengers() {
        return NoOfPassengers;
    }

    public ArrayList<Integer> getSeatNumbers() {
        return SeatNumbers;
    }

    public void setSeatNumbers(ArrayList<Integer> seatNumbers) {
        SeatNumbers = seatNumbers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        NoOfPassengers = noOfPassengers;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PNR=" + PNR +
                ", Source='" + Source + '\'' +
                ", Destination='" + Destination + '\'' +
                ", NoOfPassengers=" + NoOfPassengers +
                ", SeatNumbers=" + SeatNumbers +
                '}';
    }

}
