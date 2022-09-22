
import java.util.Scanner;
import java.util.InputMismatchException;
//Singly Linear LinkedList (SLLL) implementation 

class Node {
	Bike data;
	Node next;

	public Node(Bike data) {
		super();
		this.data = data;
		this.next = null;
	}
}

class Node2 {
	Customer custObj;
	Node2 next;

	public Node2(Customer custObj) {
		super();
		this.custObj = custObj;
		this.next = null;
	}
}

class Bike {
	int id;
	String name;
	int stock;
	double cash;

	public Bike(int id, String name, int stock,double price) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.cash = price;
	}
}

class LinkedList {
	Node head;
	LinkedList2 ls = new LinkedList2();
	// static Node2 head2;

//========================== INSERTION ============================================

	public void addStock(int bikeId, int newStock) {

		Node temp = head;
		Boolean isAvailable = false;
		while (temp != null) {
			System.out.println(" Inside loop First " + bikeId);
			if (temp.data.id == bikeId) {
				int oldStock = temp.data.stock;
				System.out.println(" Inside loop  " + oldStock);
				temp.data.stock = oldStock + newStock;
				isAvailable = true;
			}
			temp = temp.next;
		}
		if (!isAvailable) {
			System.out.println(" Wrong Id  ");
		}
		
	}

	public void decreaseOnebike(String bikename) {
		Node temp = head;
		Boolean isAvailable = false;

		while (temp != null) {

			if (temp.data.name.trim().toLowerCase().equals(bikename)) {
				int oldStock = temp.data.stock;
				
				temp.data.stock = oldStock - 1;
				isAvailable = true;
			}
			temp = temp.next;
		}
		if (!isAvailable) {
			System.out.println(" Bike is not Available  ");
		}
	}

	public void insertAtLast(Bike data) {
		// 1. create a newnode
		Node newnode = new Node(data);

		// 2. if list is empty -- attach newly created node to the head
		if (head == null) {
			head = newnode;
		} else {
			// start traversal from the first node
			Node temp = head;
			// traverse the list till last node
			while (temp.next != null) {
				temp = temp.next;

			}
			// attach newly created node to the last node
			// i.e. store an addr of newly created node into the next part of last node
			temp.next = newnode;

		}

	}

	public void show() {
		if (head == null)
			System.out.println("Linked List is Empty ");

		else {
			Node n = head;
			System.out.println("Linked List : ");
			System.out.println("------------------------------------------");
			while (n != null) {
				System.out.println(
						"Id : " + n.data.id + "   Bike Name :" + n.data.name + "  Stock Available " + n.data.stock);
				n = n.next;
			}
			System.out.println("\n------------------------------------------");
		}
	}
}

class LinkedList2 {
	
	boolean flagabc =false;
	int id;
	String name;
	String bName;
	static Node2 head2;
	int cash;
	Scanner sc = new Scanner(System.in);

	public void addCustomer(int id, String name, String bName) {
		Customer custObj = new Customer(id, name, bName);
		LinkedList list = new LinkedList();
		Node2 newNode = new Node2(custObj);

		if (head2 == null) {
			head2 = newNode;
			//list.decreaseOnebike(bName);
		} else {
			// start traversal from the first node
			Node2 flag = head2;
			// traverse the list till last node
			while (flag.next != null) {
				flag = flag.next;

			}

			flag.next = newNode;

			//list.decreaseOnebike(bName);

		}
	}

	public void addPayment(int id, double cash) {
		LinkedList list = new LinkedList();
		String bikeName = null;
		double bikePrice =0;
		Node flag = list.head;
		
		Node2 temp = head2;
		while (temp != null) {
			if (temp.custObj.id == id) {
				bikeName = temp.custObj.bName;
				while(flag != null) {
					
					if(flag.data.name.trim().equals(bikeName)) {
						bikePrice = flag.data.cash;
					}
					flag = flag.next;
				}
				if(bikePrice == cash) {
					temp.custObj.payment = cash;
					flag.data.stock--;
					System.out.println("Payment Successful !");
				}else {
					System.out.println("Pay FullAmount !");
				}
				

			}
			
			temp = temp.next;
		}
	}


	public void showCust() {
		if (head2 == null)
			System.out.println("Linked List is Empty ");

		else {
			Node2 n = head2;
			System.out.println("Linked List : ");
			System.out.println("------------------------------------------");
			while (n != null) {
				System.out.println("Id : " + n.custObj.id + "   Customer Name :" + n.custObj.name + "  Bike Name "
						+ n.custObj.bName);
				n = n.next;
			}
			System.out.println("\n------------------------------------------");
		}
	}

	void cstSection() {
		LinkedList2 l2 = new LinkedList2();
		double cstchoice = 0;
	
		//try {
			do {
				flagabc = false;
				try {
				System.out.println();
				System.out.println("1.View Customer Details");
				System.out.println("2.Add Customer Details");
				System.out.println("3.Add Payment");
				System.out.println("4.Exit");
				System.out.print("Your Choice:");
			
				cstchoice = sc.nextDouble();
					
				//
			//	cstchoice.Chars().allMatch(Character::isLetter);
				//
				if (cstchoice == 1) {
					l2.showCust();
					flagabc = true;
				}
//			  else if(cstchoice==2) {
//				  l2.add(); 
//			  }
				else if (cstchoice == 2) {
					System.out.print("Enter Customer id  : ");
					id = sc.nextInt();
					System.out.print("Enter Customer name  : ");
					name = sc.next();
					System.out.print("Enter Bikename  : ");
					bName = sc.next();

					l2.addCustomer(id, name, bName);
					flagabc = true;
				} else if (cstchoice == 3) {
					System.out.print("Enter Customer id  : ");
					id = sc.nextInt();
					System.out.print("Enter Customer Payment : ");
					name = sc.next();
					l2.addPayment(id, cash);
					flagabc = true;
				} else if (cstchoice == 4) {
					break;
				} else if (cstchoice == 0) {
					System.out.println("Exit Successfull  ...");
					flagabc = true;

				}
					else {
					System.out.println("Wrong Input !!!");
					flagabc = true;
				}
				}catch (Exception e) {
					flagabc = false;
					System.out.println("Exceptionhg Occurred !!!");
			}
				
			} while (flagabc==true);
		//} 
//		catch (Exception e) {
//			System.out.println("Exception Occurred !!!");
//
//	} 
		//finally {
//			System.out.print("Your Choice:");
//			cstchoice = sc.nextDouble();
//			cstSection();
//		}
	}

}

class Customer {
	int id;
	String name;
	String bName;
	double payment;

	public Customer(int id, String name, String bName) {
		this.id = id;
		this.name = name;
		this.bName = bName;
	}

	public void Billing() {

	}

}

public class Show {

	static Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		System.out.println(">>>>>>>>>>>>>> Singly Linear Linked List <<<<<<<<<<<<<<<<<");
		System.out.println(" 1. Insert a node at last position ");
		System.out.println(" 3. Insert a new node  at middle position   ");
		System.out.println(" 4. Add stock for existing bike  ");
		System.out.println(" 5. Insert node after a specific node  ");
		System.out.println(" 6. Delete last node");
		System.out.println(" 11. Delete last node");
		System.out.println(" 7. Delete node at specific index ");
		System.out.println(" 8. Delete the whole list ");
		System.out.println(" 9. show Customer ");
		System.out.println("10. Display ");
		System.out.println(" 0. Exit ");
		System.out.println("----------------------------");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		return choice;

	}
	

//-----------------------------Entry point function----------------------------------------------
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList2 list2 = new LinkedList2();
		int choice = 0;
		int id = 0;
		int stock = 0;
		double price;
		String name = null;
		String bName = null;
		Bike newBike = null;

	do {
		try {

		choice = menu();
		switch (choice) {
		case 1:
			System.out.print("Enter bike id  : ");
			id = sc.nextInt();
			System.out.print("Enter bike name  : ");
			name = sc.next();
			System.out.print("Enter stock  : ");
			stock = sc.nextInt();
			System.out.println("Enter price : ");
			price = sc.nextDouble();
			newBike = new Bike(id, name, stock,price);
			list.insertAtLast(newBike);
			break;

		case 4:

			System.out.print("Enter bike id  : ");
			id = sc.nextInt();
			System.out.print("Enter stock  : ");
			stock = sc.nextInt();
			list.addStock(id, stock);
			break;
		case 5:
			list2.cstSection();
//			System.out.print("Enter Customer id  : ");
//			id = sc.nextInt();
//			System.out.print("Enter Customer name  : ");
//			name = sc.next();
//			System.out.print("Enter Bikename  : ");
//			bName = sc.next();
//			list2.addCustomer(id,name,bName);
			break;

		case 9:
			list2.showCust();
			break;
		case 10:
			list.show();
			break;

		case 0:
			System.out.println("Good Bye !!! ");
			break;

		default:
			System.out.println("Enter correct choice.\nPlease try again ");
			break;
		}
	} catch (InputMismatchException e) {
		choice=10;
		System.out.println("InputMismatchExceptionkjf occu");
	
	}

	} 
	while (choice != 0);

	

	}

}
