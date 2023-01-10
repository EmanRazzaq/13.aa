package bus;





class synchmethod {
	int total_seats = 20;

//total seats=3
	synchronized  void busTicket(int seats) {
		if (total_seats >= seats) {
			System.out.println(seats + "  Seats booked successfully");
			total_seats = total_seats - seats;
			System.out.println("seats left " + total_seats);

		} else {
			System.out.println("Sorry Seats cannot be booked....!!");
			System.out.println("seats left " + total_seats);

		}
	}
}

class Bus extends Thread {
	static synchmethod b;
	int seats;

	public void run()

	{

		b.busTicket(seats);

	}

	public static void main(String args[]) {
		b = new synchmethod();

		Bus t1 = new Bus();
		t1.seats = 6;
		t1.start();

		Bus t2 = new Bus();
		t2.seats = 7;
		t2.start();

	}
}
