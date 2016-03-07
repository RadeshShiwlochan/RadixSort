import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	public static void main(String [] args) throws IOException {
	   
		if (args.length < 2) {
			System.out.println("Error");
			System.exit(1);
		}

		Scanner input = new Scanner(new File(args[0]));
		PrintWriter printWrit = new PrintWriter(new File(args[1]));

		int max = 0;
		int counter = 0;
		
		Stack stack = new Stack();
		while(input.hasNext()) {
			String line = input.next();
			int number = Integer.parseInt(line);
			if(number > max)
				max = number;
			stack.push(line);
			counter++;
		}

			
		RadixSort table = new RadixSort(String.valueOf(max).length()); //*****
		table.ReadIntoTable(stack, counter, printWrit);
		input.close();
		printWrit.close();
		
		
	}

}
