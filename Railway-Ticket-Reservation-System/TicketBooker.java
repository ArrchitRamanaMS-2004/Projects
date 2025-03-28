import java.util.*;

public class TicketBooker {

    //63 berths(upper ,lower , middle)  + ( 18 RAC passengers) 
    //10 waiting list tickets ->21 L, 21 M, 21U , 18RAC, 10WL
    static int availableLowerBerths = 1;//normally 21
    static int availableMiddleBerths = 1;//normally 21
    static int availableUpperBerths = 1;//normally 21
    static int availableRacTickets = 1;//normally 21
    static int availableWaitingList = 1;//normally 21

    static Queue <Integer> waitingList = new LinkedList<>();//queue of WL passenger
    static Queue <Integer> racList = new LinkedList<>();//queue of RAC passenger
    static List<Integer> bookedTicketList = new ArrayList<>();//list of bookedticket passengers

    static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,21
    static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,21
    static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,21
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,21
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,21

    static Map<Integer, Passenger> passengers = new HashMap<>();//map of passeger's ids to passeger

    //book ticket
    public void bookTicket ( Passenger p, int berthInfo , String allotedBerth)
    {
        //assign the seat number and type of berth (L,U,M)
        p.number = berthInfo;
        p.alloted = allotedBerth;
        //add passenger to the map
        passengers.put (p.passengerId,p);
        //add passenger id to the list of booked tickets
        bookedTicketList.add(p.passengerId);
        System.out.println("-------------------------Booked Successfully");
    }

    //adding to RAC
    public void addToRAC(Passenger p , int racInfo, String allotedRAC)
    {
        //assign seat number and type(RAC)
        p.number = racInfo;
        p.alloted = allotedRAC;
        //add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of RAC tickets
        racList.add(p.passengerId);
        //decrease available RAC tickets by 1
        availableRacTickets--;
        //remove the position that was alloted to the passenger
        racPositions.remove(0);

        System.out.println("-------------------------------added to RAC Successfully");
    }

    //adding to WL 
    public void addToWaitingList(Passenger p , int waitingListInfo , String allotedWL)
    {
        //assign seat number and type(WL)
        p.number = waitingListInfo;
        p.alloted = allotedWL;
        //add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of WL tickets
        waitingList.add(p.passengerId);
        //decrease available WL tickets by 1
        availableWaitingList--;
        //remove the position that was alloted to the passenger
        waitingListPositions.remove(0);

        System.out.println("------------------------ added to Waiting List Successfully");
    }

    //cancel ticket
    
}