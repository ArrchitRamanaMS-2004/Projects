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
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,18
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...,10

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
    public static void cancelTicket(int passengerId) {
        //remove the passenger from the map
        Passenger p = passengers.get(passengerId);
        passengers.remove(Integer.valueOf(passengerId));
        //remove the booked ticket from the list 
        bookedTicketList.remove(passengerId);

        //take the booked position which is now free
        int positionBooked  = p.number;

        System.out.println("-------------------------------------canceled succesfully");

        //add the free position to the corresponding type of list either (L,M,U)
        if (p.alloted.equals("L")){
            availableLowerBerths++;
            lowerBerthPositions.add(positionBooked);
        }
        else if (p.alloted.equals("M")){
            availableMiddleBerths++;
            middleBerthPositions.add(positionBooked);
        }
        else if (p.alloted.equals("U")){
            availableUpperBerths++;
            upperBerthPositions.add(positionBooked);
        }

        // check if any RAC is there
        if ( racList.size() > 0 ) {
            //take passenger from RAC 
            Passenger passengerFromRAC = passengers.get(racList.poll());
            int positionRAC = passengerFromRAC.number;           
            racPositions.add(positionRAC);
            racList.remove(passengerFromRAC.passengerId);
            availableRacTickets++;

            //check if any WL is  there
            if ( waitingList.size() > 0 ) 
            {
                //take the passenger from the WL and add them to RAC and increase the free space in waiting list
                Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitingList.number;
                waitingListPositions.add(positionWL);
                waitingList.remove(passengerFromWaitingList.number);

                passengerFromWaitingList.number = racPositions.get(0);
                passengerFromWaitingList.alloted = "RAC";
                racPositions.remove(0);
                racList.add(passengerFromWaitingList.passengerId);

                //increase available waiting list and decresase available rac by 1
                availableRacTickets--;
                availableWaitingList++;
            }
            //now we have a passenger from RAC to whom we can book a ticket,
            //so book the cancelled ticket to the RAC passenger 
            Main.bookTicket(passengerFromRAC);
        }
    }

    //print all available seats
    public void printAvailable() {
        System.out.println("Available Lower Berths : " + availableLowerBerths);
        System.out.println("Available Middle Berths : " + availableMiddleBerths);
        System.out.println("Available Upper Berths : " + availableUpperBerths);
        System.out.println("Available RACs Berths : " + availableRacTickets);
        System.out.println("Available Waiting List Berths : " + availableWaitingList);
        System.out.println("------------------------------------------");
    }

    //print all occupied passengers from all types including WL
    public void printPassengers() 
    {
        if (passengers.size() == 0)  {
            System.out.println("No details of Passenger");
        }
        for ( Passenger p : passengers.values()) {
            System.out.println("PASSENGER ID : " + p.passengerId);
            System.out.println("Name : " + p.name);
            System.out.println("Age : " + p.age);
            System.out.println("Status : " + p.number + p.alloted);
            System.out.println("-----------------------------------------");
        }
    }
}