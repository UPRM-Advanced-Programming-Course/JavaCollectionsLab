import java.util.LinkedList;
import java.util.Queue;

public class JavaRestaurant {

	/**
	 * Exercise 1
	 * In this exercise you want to simulate a restaurant waiting line.
	 * Time is denoted by a variable "t" that starts at 0
	 * Follow the instructions in the comments to complete this exercise
	 * @param incomingCustomers
	 * @return - returns the total amount of money that the customers 
	 * paid for the service. 
	 */
	public static int FastFood(Queue<Customer> incomingCustomers) {
		int t = 0; //time
		int TotalMoney = 0; //money earned
		Customer CustomerAtCashRegister = null; //where the customer will be attended
		Queue<Customer> WaitingLine = new LinkedList<>(); //waiting Line

		//Looks for first customer
		while (t != incomingCustomers.peek().getTimeEntered()) {
			t++;
		}

		//Assign first customer to cash register
		CustomerAtCashRegister = (incomingCustomers.poll());

		//If initial list, the waiting line and the cash register aren't empty.
		while (!incomingCustomers.isEmpty() || !WaitingLine.isEmpty() || CustomerAtCashRegister!= null) {
			
			/** If cash register is available and someone is waiting in line, 
			 * then move the next customer from waiting line to cash register.
			 * 
			 * Looks if some incoming customer can enter the restaurant.
			 * If that is the case, move that customer to the waiting line.
			 *	
			 * Takes 1 unit of time from customer in cash register for their respective order.
			 *
			 * If the cash register is done, accumulate the money from the order
			 * and free the cash register.
			 */
			
			// YOUR CODE

			t++;
		}
		return TotalMoney;
	}

	/**
	 * Exercise 2
	 * In this exercise you want to simulate a restaurant waiting line.
	 * Time is denoted by a variable "t" that starts at 0
	 * Follow the instructions in the comments to complete this exercise
	 * The customer's patience runs out in the waiting line as time passes by.
	 * @param incomingCustomers
	 * @return - returns the total amount of money that the customers 
	 * paid for the service. 
	 */
	
	public static int FastFoodWithPatience(Queue<Customer> incomingCustomers) {
		int t = 0; //time
		int TotalMoney = 0; //money earned
		Customer CustomerAtCashRegister = null; //where the customer will be attended
		Queue<Customer> WaitingLine = new LinkedList<>(); //waiting Line

		//Looks for first customer
		while (t != incomingCustomers.peek().getTimeEntered()) {
			t++;
		}

		//Assign first customer to cash register
		CustomerAtCashRegister = (incomingCustomers.poll());

		//If initial list, the waiting line and the cash register aren't empty.
		while (!incomingCustomers.isEmpty() || !WaitingLine.isEmpty() || CustomerAtCashRegister!= null) {
			
			/** If cash register is available and someone is waiting in line, 
			 * then move the next customer from waiting line to cash register.
			 * 
			 * Looks if some incoming customer can enter the restaurant.
			 * If that is the case, move that customer to the waiting line.
			 *	
			 * Takes 1 unit of time from customer in cash register for their respective order.
			 *	
			 * The customer's patience decreases in the waiting line.	
			 *
			 * If the cash register is done, accumulate the money from the order
			 * and free the cash register.
			 */
			
			// YOUR CODE

			t++;
		}
		return TotalMoney;

	}

	/**
	 * Exercise 2
	 * Implement a method to reduce 1 unit of time to every
	 * customer in the waiting line to his/hers patience.
	 * If patience is equals to zero, the customer will get out of the line and leave.
	 * @param waitingLine
	 * @return the waitingLine with the patience depleted and those with equal to 0 removed.
	 */
	private static Queue<Customer> pacienceReducer(Queue<Customer> waitingLine) {
		// YOUR CODE
		// RESTRICTION: DO NOT CREATE ANY NEW DATA STRUCTURES.
	
		return waitingLine;
	}

	/**
	 * Exercise 3
	 * A lot of people have entered the restaurant and you don't 
	 * know the order they have enter. Sort the WaitingLine Queue to attend
	 * the customers patience that take less time.
	 * Hint: Use the Comparator and Collections.sort();
	 * @param incomingCustomers
	 * @return the total money earned.
	 */
	public static int CustomerManagement(Queue<Customer> incomingCustomers) {
		int TotalMoney = 0; //money earned

		return TotalMoney;

	}

	public static class Customer implements Comparable<Customer> {
		public int timeEntered;
		public int bill;
		public int timeToCompleted;
		public int patience;
		public String Name;

		public Customer(String Name,int timeEntered, int bill, int timeToCompleted, int patience) {
			this.timeEntered = timeEntered;
			this.bill = bill;
			this.timeToCompleted = timeToCompleted;
			this.patience = patience;
			this.Name = Name;
		}

		public Customer(CustomerBuilder builder) {
			this(builder.Name,
					builder.timeEntered, 
					builder.bill, 
					builder.timeToCompleted, 
					builder.patience);
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public int getTimeEntered() {
			return timeEntered;
		}

		public void setTimeEntered(int timeEntered) {
			this.timeEntered = timeEntered;
		}

		public int getBill() {
			return bill;
		}

		public void setBill(int bill) {
			this.bill = bill;
		}

		public int getTimeToCompleted() {
			return timeToCompleted;
		}

		public void setTimeToCompleted(int timeToCompleted) {
			this.timeToCompleted = timeToCompleted;
		}

		public int getPatience() {
			return patience;
		}

		public void setPatience(int pacience) {
			patience = pacience;
		}

		public String toString() {
			return "("+Name + ", Patience: " + patience + " \nOrders Time: " + timeToCompleted+")";
		}

		/**
		 * Exercise 3
		 * Implement the comparable so that we can sort the entering customers by Patience
		 */
		public int compareTo(Customer o) {
			return 0; //Dummy return
		}	
	}
	public static class CustomerBuilder{
		private int timeEntered = 0;
		private int bill = 0;
		private int timeToCompleted = 0;
		private int patience = 0;
		private String Name = "";

		public CustomerBuilder timeEntered(int val) {
			timeEntered = val;
			return this;
		}

		public CustomerBuilder bill(int val) {
			bill = val;
			return this;
		}

		public CustomerBuilder timeToCompleted(int val) {
			timeToCompleted = val;
			return this;
		}

		public CustomerBuilder patience(int val) {
			patience = val;
			return this;
		}

		public CustomerBuilder Name(String val) {
			Name = val;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}
}