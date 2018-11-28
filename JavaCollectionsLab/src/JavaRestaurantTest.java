import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class JavaRestaurantTest {

	private Queue<JavaRestaurant.Customer> line1;
	private Queue<JavaRestaurant.Customer> line2;
	private Queue<JavaRestaurant.Customer> line3;

	@Before
	public void setup() {
		JavaRestaurant.CustomerBuilder builder = new JavaRestaurant.CustomerBuilder();
		line1 = new LinkedList<JavaRestaurant.Customer>();
		line2 = new LinkedList<JavaRestaurant.Customer>();
		line3 = new LinkedList<JavaRestaurant.Customer>();

		line1.add(builder.bill(2)
				.timeEntered(0)
				.timeToCompleted(4)
				.patience(4)
				.Name("Alfredo")
				.build());
		line1.add(builder.bill(5)
				.timeEntered(1)
				.timeToCompleted(7)
				.patience(10)
				.Name("Alberto")
				.build());
		line1.add(builder.bill(1)
				.timeEntered(2)
				.timeToCompleted(1)
				.patience(12)
				.Name("Enrique")
				.build());
		line1.add(builder.bill(4)
				.timeEntered(3)
				.timeToCompleted(3)
				.patience(11)
				.Name("Josian")
				.build());
		line1.add(builder.bill(4)
				.timeEntered(4)
				.timeToCompleted(5)
				.patience(7)
				.Name("Carlos")
				.build());
		line1.add(builder.bill(5)
				.timeEntered(5)
				.timeToCompleted(5)
				.patience(5)
				.Name("Elvin")
				.build());
		line1.add(builder.bill(6)
				.timeEntered(6)
				.timeToCompleted(9)
				.patience(10)
				.Name("Harry")
				.build());
		line1.add(builder.bill(7)
				.timeEntered(7)
				.timeToCompleted(5)
				.patience(17)
				.Name("Bienve")
				.build());

		line2.add(builder.bill(6)
				.timeEntered(6)
				.timeToCompleted(9)
				.patience(10)
				.Name("Harry")
				.build());

		line3.add(builder.bill(7)
				.timeEntered(0)
				.timeToCompleted(5)
				.patience(7)
				.Name("Bienve")
				.build());
		line3.add(builder.bill(7)
				.timeEntered(1)
				.timeToCompleted(5)
				.patience(6)
				.Name("Bienve")
				.build());
	}

	@Test(timeout = 1000)
	public void testFastFood() {
		assertEquals(34, JavaRestaurant.fastFood(line1));
		assertEquals(6, JavaRestaurant.fastFood(line2));
		assertEquals(14, JavaRestaurant.fastFood(line3));
	}
	@Test(timeout = 1000)
	public void testFastFoodIsEmpty() {
		JavaRestaurant.fastFood(line1);
		assertTrue(line1.isEmpty());
		JavaRestaurant.fastFood(line2);
		assertTrue(line2.isEmpty());
		JavaRestaurant.fastFood(line3);
		assertTrue(line3.isEmpty());
	}

	@Test(timeout = 1000)
	public void testFastFoodWithPatience() {
		assertEquals(18, JavaRestaurant.fastFoodWithPatience(line1));
		assertEquals(6, JavaRestaurant.fastFoodWithPatience(line2));
		assertEquals(14, JavaRestaurant.fastFoodWithPatience(line3));
	}
	@Test(timeout = 1000)
	public void testFastFoodWithPatienceIsEmpty() {
		JavaRestaurant.fastFoodWithPatience(line1);
		assertTrue(line1.isEmpty());
		JavaRestaurant.fastFoodWithPatience(line2);
		assertTrue(line2.isEmpty());
		JavaRestaurant.fastFoodWithPatience(line3);
		assertTrue(line3.isEmpty());
	}

	@Test//(timeout = 1000)
	public void testCustomerManagement() {
		assertEquals(19, JavaRestaurant.customerManagement(line1));
		assertEquals(6, JavaRestaurant.customerManagement(line2));
		assertEquals(14, JavaRestaurant.customerManagement(line3));
	}
	@Test(timeout = 1000)
	public void testCustomerManagementIsEmpty() {
		JavaRestaurant.customerManagement(line1);
		assertTrue(line1.isEmpty());
		JavaRestaurant.customerManagement(line2);
		assertTrue(line2.isEmpty());
		JavaRestaurant.customerManagement(line3);
		assertTrue(line3.isEmpty());
	}
}