import java.util.*;

public class UnknownAirline implements Comparable <UnknownAirline>{
	
	private String name; 
	private int status; 
	private int waitTime; 
	
	//Constructor 
	public UnknownAirline(String name, int status, int waitTime) { 
		this.name = name; 
		this.status = status; 
		this.waitTime = waitTime; 
	}
	

	@Override
	public int compareTo(UnknownAirline air) {
		if (status < air.status) { 
			return -1; 
		}
		else if (status > air.status ) { 
			return 1; 
		}
		if(waitTime < air.waitTime) { 
			return -1; 
		}
		if (waitTime > air.waitTime ) { 
			return 1; 
		}
		
		return 0; 
	}
	//method for printing out an element in the priority queue to a string
	@Override
	public String toString() { 
		String result = "Name: " + name + "  |  " + "Status: " + status + "  |  " +"Wait Time: " + waitTime + "\n"; 
		return result; 
	}
	
	static void StatusMenu()
	   {
	       //Prompt the user to choose from the menu
		   System.out.println();   
		   System.out.println(" Menu");
	       System.out.println("1. Super");
	       System.out.println("2. Platinum");
	       System.out.println("3. Gold");
	       System.out.println("4. Silver");
	       System.out.println("5. Cancel Reservation");
	       System.out.println("6. Print List of Passengers Waiting For Upgrade");
	       System.out.println();
	   }
	
public static void main(String[] args) {
		
		PriorityQueue <UnknownAirline> seat = new PriorityQueue<>(); 
		
		System.out.println("Enter number of seats available for upgrade: "); 
		
		Scanner scan1 = new Scanner(System.in); 
		final int MAX_SEATS = scan1.nextInt(); 
		
			int i = 0;
			while ( i < MAX_SEATS) { 
			System.out.println("Enter your name (or type cancel to cancel reservation): ");
			
			Scanner scan = new Scanner(System.in);  // input name
			String name = scan.next(); 
			if(name.equals("cancel")) {
				System.out.println("Reservation Cancelled\n");	
				continue; 
			}
			
			StatusMenu(); 
			
			System.out.println("Choose your status or cancel reservation (Enter 1 - 6): ");
			
			Scanner scan2 = new Scanner(System.in); // input priority
			int priority = scan2.nextInt();
			
			if(priority == 5) { 
				System.out.println("Reservation Cancelled\n");	
				continue; 
			}
			
			//Printing the list of upgrades that at current loop iteration
			if(priority == 6) { 
				System.out.println(seat.toString());
				System.out.println();
				
				StatusMenu(); 
				System.out.println("Choose your status or cancel reservation (Enter 1 - 6): ");
				
				Scanner scan6 = new Scanner(System.in); // input priority
				int priority2 = scan6.nextInt();	
				priority = priority2; 
				
				if(priority == 5) { 
					System.out.println("Reservation Cancelled\n");	
					continue; 	
			}
		}
			
			if (priority < 1 || priority > 6) { 
				System.out.println("Please choose status 1-6!\n"); //priority cannot be less outside of this range
				continue; 
			}
			System.out.println("Enter your time you are willing to wait (or type 0 to cancel reservation): "); //prompting user for wait time
			Scanner scan3 = new Scanner(System.in); 
			int waitTime = scan3.nextInt(); //take in wait time 
			if (waitTime == 0){ 
				System.out.println("Reservation Cancelled\n");	
				continue;
			}
			System.out.println("Please confirm/cancel your seat(Type confirm or cancel): ");
			Scanner scan4 = new Scanner(System.in); //if input is cancel loop continues to next iteration
			String confirmation = scan4.next();  
			
			if (confirmation.equals("cancel")) { 
				System.out.println("Reservation Cancelled\n");     // If user reservation is canceled, no element is added to the queue
				continue;  // continue to next loop iteration
			}
			if (confirmation.equals("confirm")){ 
				System.out.println("Reservation Confirmed\n");     // If user puts confirm, reservation is confirmed and seat is added to the queue
			
			if (!(confirmation.equals("confirm") || (!(confirmation.equals("cancel"))))) { 
					System.out.println("Error! Please type cancel or confirm to confirm or cancel your reservation!!!\n");     
					continue; 
				}
			
			seat.add(new UnknownAirline (name, priority, waitTime));
			i++;
			}
			
		}
			
		Iterator <UnknownAirline> it = seat.iterator(); 
		while(it.hasNext()) { 
			System.out.println(seat.poll().toString());
		}
			 
		}
}
