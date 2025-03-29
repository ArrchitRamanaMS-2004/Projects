import java.util.*;

public class Main {
    //function for booking ticket
    public static void bookTicket(Passenger p) {
        TicketBooker booker = new TicketBooker();
        //if no WL is available , means all tickets are filled... so no tickets available
        if (TicketBooker.availableWaitingList == 0) {
            System.out.println("No Tickets Available");
            return;
        }
        //check if preferred berth is available
        if ( ( p.berthPreference.equals("L") && TicketBooker.availableLowerBerths > 0) ||
             ( p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths > 0) ||
             ( p.berthPreference.equals("U") && TicketBooker.availableUpperBerths > 0) )
        {
            System.out.println("Preferred Berth Available");
            if (p.berthPreference.equals("L"))
            {
                System.out.println("Lower Berth Given");
                //call booking function in the TicketBooker classs
                booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");
                //remove the booked position from available positions and
                //also decrease available seats of that particular type
                TicketBooker.lowerBerthPositions.remove(0);
                TicketBooker.availableLowerBerths--; 
            }
            else if (p.berthPreference.equals("M"))
            {
                System.out.println("Middle Berth Given");
                //call booking function in the TicketBooker class
                booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");
                //remove the booked positions from availble positions 
                //and also decrease available seats of that particular type
                TicketBooker.middleBerthPositions.remove(0);
                TicketBooker.availableMiddleBerths--;
            }
            else if (p.berthPreference.equals("U")) 
            {
                System.out.println("Upper Berth Given");
                //call booking function in the TicketBooker class 
                booker.bookTicket(p,(TicketBooker.upperBerthPositions.get(0)), "U");
                TicketBooker.upperBerthPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            }
        }
        //what if the preferred seat is not available
        else if (TicketBooker.availableLowerBerths > 0)
        {
            System.out.println("lower Berth given");
            //call booking function in the TicketBooker class
            booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");
            //remove the booked position from available positions
            //and also decrease the seats of that particular berth type
            TicketBooker.lowerBerthPositions.remove(0);
            TicketBooker.availableLowerBerths--;
        }
        else if (TicketBooker.availableMiddleBerths > 0)
        {
            System.out.println("middle Berth given");
            //call booking function in the TicketBooker class
            booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");
            //remove the booked position from available positions
            //and also decrease the seats of that particular berth type
            TicketBooker.middleBerthPositions.remove(0);
            TicketBooker.availableMiddleBerths--;
        }
        else if (TicketBooker.availableUpperBerths > 0)
        {
            System.out.println("upper Berth given");
            //call booking function in the TicketBooker class
            booker.bookTicket(p,(TicketBooker.upperBerthPositions.get(0)),"U");
            //remove the booked position from available positions
            //and also decrease the seats of that particular berth type
            TicketBooker.upperBerthPositions.remove(0);
            TicketBooker.availableUpperBerths--;
        }
        //if no berth available go to RAC
        else if (TicketBooker.availableRacTickets > 0)
        {
            System.out.println("RAC available");
            booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC");
        }
        //if no RAC available go to WL
        else if (TicketBooker.availableWaitingList > 0) 
        {
            System.out.println("Added to waiting list");
            booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
        }
    }

    //cancel ticket function
    public static void cancelTicket(int id) {
        TicketBooker booker = new TicketBooker();
        //check if passenger id is valid 
        if (!booker.passengers.containsKey(id)) {
            System.out.println("passenger detail unknown");
        }
        else {
            booker.cancelTicket(id);
        }
    }

    public static void main ( String [] args) {
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        //loop to get choices from user until he stops
        while (loop){
            System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3.Available Tickets \n 4.Booked Tickets \n 5.Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                {
                    //get details from passenger to book tickets
                    System.out.println("Enter Passenger name , age , berth preference ( L,M,U )");
                    String name = s.next();
                    int age = s.nextInt();
                    //get berth preference (L,U,M)
                    String berthPreference = s.next();
                    //create a passenger object 
                    Passenger p = new Passenger(name , age , berthPreference);
                    //booking
                    bookTicket(p);
                }
                break;
                //cancle ticket
                case 2:
                {
                    //get passenger id to cancel 
                    System.out.println("Enter passenger id to cancel : ");
                    int id = s.nextInt();
                    cancelTicket(id);
                }
                break;
                //available ticket print
                case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                //occupied tickets print
                case 4: 
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printPassengers();
                }
                break;
                //exit
                case 5: 
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
    }    
}
