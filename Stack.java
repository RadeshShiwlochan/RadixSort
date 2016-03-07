import java.io.File;
import java.io.PrintWriter;


public class Stack {
	public Node top;

	Stack() {
		top = null;
	}

	void push(String value) {
		Node newTop = new Node(value); 
		newTop.next = top;
		top = newTop;
	}

	String pop() {
		if(isEmpty())
			System.exit(1);
		String oldTop = top.data;
		top = top.next;
		return oldTop;
	}

	boolean isEmpty() {
		return top == null; 
	}

	void printStack(PrintWriter printWrit) {
		Node temp = top;
		while(temp != null) {
			printWrit.print(temp.data);
			if(temp.next != null)
				printWrit.print( " -->  ");
			temp = temp.next;
		}
		printWrit.print("\n");   
	}

}
