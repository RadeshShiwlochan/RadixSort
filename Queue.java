import java.io.File;
import java.io.PrintWriter;


public class Queue {

	public Node head;
	public Node tail;
	
	Queue() { 
		head = new Node("-9999"); 
		tail = head;
	}

	void addTail(Node addToEnd) {
		tail.next = addToEnd;
		tail = addToEnd;
	}

	String deleteHead() {

		if(head.next == null) {
			System.out.println( "ERROR, no Data in the Queue to delete" );
			System.exit(1);
		}

		String temp = head.next.data;
		if (head.next == tail) {
			tail = head;
			head.next = null;
			return temp;
		}

		head.next = head.next.next;
		return temp;
	}

	boolean isEmpty() {
		return head.next == null;
	}

	void printQueue(PrintWriter printWrit) {
		Node temp = head.next;
		printWrit.print(head.data);
		while(temp!= null) {
			printWrit.print(" --> " + temp.data);
			temp = temp.next;
		}
	}
	
}
