import java.util.*;

public class Train {
    private static Train train;
    private final boolean[][] Seats;
    private final HashMap<String,Integer> StationIndex;
    private final HashMap<Integer,Passenger> passengers;
    private final Queue<Passenger> waitingList;
    private  int TotalSeats=8;
    private  int WaitingSize=2;
    private Train(List<String> stations) {
        StationIndex=new HashMap<>();
        waitingList=new LinkedList<>();
        Seats=new boolean[TotalSeats][stations.size()];
        passengers=new HashMap<>();
        for(int i=0;i<stations.size();i++){
            StationIndex.put(stations.get(i),i);
        }
    }
    public static Train getInstance(List<String> stations) {
        if (train == null) {
            train = new Train(stations);
        }
        return train;
    }

    public boolean[][] getSeats() {
        return Seats;
    }

    public HashMap<String, Integer> getStationIndex() {
        return StationIndex;
    }

    public Queue<Passenger> getWaitingList() {
        return waitingList;
    }
    public int getWaitingSize() {
        return WaitingSize;
    }
    public void setWaitingSize(int waitingSize) {
        WaitingSize = waitingSize;
    }
    public boolean IsValid(String source, String destination,int NoOfSeats) {
        return StationIndex.containsKey(destination) && StationIndex.containsKey(source) && StationIndex.get(destination) > StationIndex.get(source) && NoOfSeats > 0 && NoOfSeats <= 8;
    }

    public boolean isSeatAvailable(String source, String destination, int noOfSeats, ArrayList<Integer> availableSeats) {
        int startIndex=StationIndex.get(source);
        int endIndex=StationIndex.get(destination);
        for(int i=0;i<Seats.length&&availableSeats.size()<noOfSeats;i++){
            boolean Tag=true;
            for(int j=startIndex;j<endIndex;j++){
                if(Seats[i][j]){
                    Tag=false;
                    break;
                }
            }
            if(Tag){
                availableSeats.add(i+1);
            }
        }
        return availableSeats.size()==noOfSeats;
    }

    public HashMap<Integer, Passenger> getPassengers() {
        return passengers;
    }
    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getPNR(),passenger);
    }

    public void FillSeats(ArrayList<Integer> availableSeats, String source, String destination) {
        int startIndex=StationIndex.get(source);
        int endIndex=StationIndex.get(destination);
        for(int seat:availableSeats){
            for(int i=startIndex;i<endIndex;i++){
                Seats[seat-1][i]=true;
            }
        }
    }

    public void print() {
        int i=1;
        System.out.println("    A  B  C  D  E  ");
        for(boolean[] seats:Seats){
            System.out.print(" "+ i++ +" ");
            for(boolean seat:seats){
                if(seat){
                    System.out.print(" * ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public boolean isWaitingListAvailable(String source, String destination, int noOfSeats) {
        return WaitingSize>=noOfSeats;
    }
}
