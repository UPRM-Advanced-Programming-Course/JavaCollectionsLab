import java.util.Comparator;
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
	public static int fastFood(Queue<Customer> incomingCustomers) {
		int t = 0; //time
		int totalMoney = 0; //money earned
		Customer customerAtCashRegister = null; //where the customer will be attended
		Queue<Customer> waitingLine = new LinkedList<>(); //waiting Line

		//Looks for first customer
		while (t != incomingCustomers.peek().getTimeEntered()) {
			t++;
		}

		//Assign first customer to cash register
		customerAtCashRegister = (incomingCustomers.poll());

		//If initial list, the waiting line and the cash register aren't empty.
		while (!incomingCustomers.isEmpty() || !waitingLine.isEmpty() || customerAtCashRegister!= null) {
			
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
		return totalMoney;
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
	
	public static int fastFoodWithPatience(Queue<Customer> incomingCustomers) {
		int t = 0; //time
		int totalMoney = 0; //money earned
		Customer customerAtCashRegister = null; //where the customer will be attended
		Queue<Customer> waitingLine = new LinkedList<>(); //waiting Line

		//Looks for first customer
		while (t != incomingCustomers.peek().getTimeEntered()) {
			t++;
		}

		//Assign first customer to cash register
		customerAtCashRegister = (incomingCustomers.poll());

		//If initial list, the waiting line and the cash register aren't empty.
		while (!incomingCustomers.isEmpty() || !waitingLine.isEmpty() || customerAtCashRegister!= null) {
			
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
		return totalMoney;
	}

	/**
	 * Exercise 2
	 * Implement a method to reduce 1 unit of time to every
	 * customer in the waiting line to his/hers patience.
	 * If patience is equals to zero, the customer will get out of the line and leave.
	 * @param waitingLine
	 * @return the waitingLine with the patience depleted and those with equal to 0 removed.
	 */
	private static Queue<Customer> patienceReducer(Queue<Customer> waitingLine) {
		// YOUR CODE
		// RESTRICTION: DO NOT CREATE A NEW DATA STRUCTURE

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
	public static int customerManagement(Queue<Customer> incomingCustomers) {
		int totalMoney = 0; //money earned
		
		return incomingCustomers.size();

	}
	
	public static class CustomerComparator implements Comparator<Customer> {

		/**
		 * Exercise 3
		 * Implement the comparable so that we can sort the 
		 * entering customers by Patience.
		 */
		@Override
		public int compare(Customer arg0, Customer arg1) {
			return 0;
		}
		
	}
	
	/**
	 * Recursive Selection Sort for an array
	 * @param shelve - Array to be sorted
	 */
	public static Queue<Customer> selectionSort(Queue<Customer> line, Comparator<Customer> comp) {
		Customer[] lineArr = new Customer[line.size()];
		int idx = 0;
		for(Customer cu: line) {
			lineArr[idx] = cu;
			idx++;
		}
		selHelper(lineArr, 0, comp);
		Queue<Customer> newLine = new LinkedList<>();
		for(idx = 0; idx < lineArr.length; idx++) {
			newLine.add(lineArr[idx]);
		}
		return newLine;
		
	}
	
	private	static void	selHelper(Customer[] lineArr, int tailIndex, Comparator<Customer> comp) {
		if(tailIndex >= lineArr.length) { return; }
		int	minIndex = tailIndex;
		for(int	i = tailIndex; i < lineArr.length; i++) {
			if(comp.compare(lineArr[minIndex], lineArr[i]) > 0) {
				minIndex = i;
			}	
		}
		Customer temp = lineArr[minIndex];
		lineArr[minIndex] = lineArr[tailIndex];
		lineArr[tailIndex] = temp;
		selHelper(lineArr, tailIndex+1, comp);
	}

	public static class Customer {
		public int timeEntered;
		public int bill;
		public int timeToComplete;
		public int patience;
		public String Name;

		public Customer(String Name,int timeEntered, int bill, int timeToComplete, int patience) {
			this.timeEntered = timeEntered;
			this.bill = bill;
			this.timeToComplete = timeToComplete;
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

		public int getTimeToComplete() {
			return timeToComplete;
		}

		public void setTimeToCompleted(int timeToComplete) {
			this.timeToComplete = timeToComplete;
		}

		public int getPatience() {
			return patience;
		}

		public void setPatience(int pacience) {
			patience = pacience;
		}

		public String toString() {
			return "("+Name + ", Patience: " + patience + " \nOrders Time: " + timeToComplete+")";
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
