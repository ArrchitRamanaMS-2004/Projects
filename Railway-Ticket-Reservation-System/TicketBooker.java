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
    

}