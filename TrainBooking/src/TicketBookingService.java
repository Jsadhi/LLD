import java.util.ArrayList;
import java.util.List;

public class TicketBookingService {
    private final Train train;
    TicketBookingService(List<String> stations) {
        train= Train.getInstance(stations);
    }
    public void book(String source, String destination,int NoOfSeats) {
        if(train.IsValid(source, destination, NoOfSeats)) {
            ArrayList<Integer> AvailableSeats=new ArrayList<>();
            if(train.isSeatAvailable(source,destination,NoOfSeats,AvailableSeats))
            {
                train.FillSeats(AvailableSeats,source,destination);
                Passenger obj=new Passenger(source,destination,NoOfSeats);
                obj.setSeatNumbers(AvailableSeats);
                train.addPassenger(obj);
                System.out.println("Ticket Booked!");
                System.out.println(obj.toString());
            }
            else if(train.isWaitingListAvailable(source,destination,NoOfSeats))
            {
                train.setWaitingSize(train.getWaitingSize()-NoOfSeats);
                train.getWaitingList().add(new Passenger(source,destination,NoOfSeats));
                System.out.println(train.getWaitingList().peek());
            }
            else {
                System.out.println("Seats is not available");
            }
        }
        else {
            System.out.println("Invalid source or destination or Seat Count.");
        }
    }
    public void Print(){
        train.print();
    }

    public void Cancel(int PNR, int count) {
        if(!train.getPassengers().containsKey(PNR)||count==0||train.getPassengers().get(PNR).getNoOfPassengers()<count){
            System.out.println("Invalid details");
            return;
        }
        Passenger obj=train.getPassengers().get(PNR);
        obj.setNoOfPassengers(obj.getNoOfPassengers()-count);
        System.out.print("Cancelled Seats:");
        int from=train.getStationIndex().get(obj.getSource());
        int to=train.getStationIndex().get(obj.getDestination());
        for(int i = 0; i<count&& !obj.getSeatNumbers().isEmpty(); i++) {
            int seat=obj.getSeatNumbers().removeFirst();
            for(int j=from;j<to;j++) {
                train.getSeats()[seat-1][j]=false;
            }
            System.out.print(seat+" ");
        }
        if(obj.getNoOfPassengers()==0)
        {
            train.getPassengers().remove(PNR);
            System.out.println("Tickets cancelled!");
        }
        else {
            System.out.println("Partial cancelled");
        }
        for(int i=0;i<train.getWaitingList().size();i++)
        {

            Passenger OldObj=train.getWaitingList().poll();
            ArrayList<Integer> AvailableSeats=new ArrayList<>();
            assert OldObj != null;
            if(train.isSeatAvailable(OldObj.getSource(),OldObj.getDestination(),OldObj.getNoOfPassengers(),AvailableSeats))
            {
                train.FillSeats(AvailableSeats,OldObj.getSource(),OldObj.getDestination());
                OldObj.setSeatNumbers(AvailableSeats);
                train.setWaitingSize(train.getWaitingSize()+OldObj.getNoOfPassengers());
                train.addPassenger(OldObj);
                System.out.println("Ticket confirmed from waiting list");
                System.out.println(OldObj.toString());
            }
            else
                train.getWaitingList().add(OldObj);
        }

    }
}
