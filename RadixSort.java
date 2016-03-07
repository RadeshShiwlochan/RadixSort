import java.io.File;
import java.io.PrintWriter;


public class RadixSort {
	  
	public HashTable Current_Hash_Table;
	public HashTable Previous_Hash_Table;
	public boolean currentTable;
	public int currentDigit;
	public int totalDigit;

	RadixSort(int max) {
		Current_Hash_Table = new HashTable();
		Previous_Hash_Table = new HashTable();
		currentTable = true;
		currentDigit = 1; 
		totalDigit = max; 
	}


	void hashFunction(String number) {
		int index, numberToString ;
		index = 0;
		numberToString = 0;
		numberToString = Integer.parseInt(number);

		if(currentDigit == 1) 
			index = numberToString % 10;

		else if (currentDigit == 2) {
			numberToString = numberToString/10;
			index = numberToString % 10;
		}
		else {
			numberToString = numberToString/100;
			index = numberToString % 1000;
		}

		addToQueue(number,index);
	
	}

	void addToQueue(String number, int index) {
		Node tailor = new Node(number);
		if(currentTable)
			Current_Hash_Table.hash_Table[index].addTail(tailor);
		else {
			Previous_Hash_Table.hash_Table[index].addTail(tailor);
		}

	}

	void PrintRadixSortTable(PrintWriter printWrit) {
		if(currentTable) {
			printWrit.print("\n----------------" + "Table 1" + "----------------\n");
			for(int i = 0; i < 10; i++) {
				printWrit.print("index " + i + "     ");
				Current_Hash_Table.hash_Table[i].printQueue(printWrit);
				printWrit.print("\n");
			}
			currentTable  = false;    
		}
		else if(!currentTable) {
			printWrit.print("\n----------------" + "Table 2" + "----------------\n"); 
			for(int i = 0; i < 10; i++) {
				printWrit.print("index " + i + "     ");
				Previous_Hash_Table.hash_Table[i].printQueue(printWrit);
				printWrit.print("\n");
			}
			currentTable  = true;
 
		}
	}

	void ReadIntoTable(Stack stack, int counter, PrintWriter printWrit) {

		stack.printStack(printWrit);
		String newDigit = "";
		while(counter > 0) {
			String digit = stack.pop(); 
			int number   = Integer.parseInt(digit);

			if(number < 10){
				newDigit = "00" + digit;
				hashFunction(newDigit);

			}	  
			else if(number > 10 && number < 100) {
				newDigit = "0" + digit;
				hashFunction(newDigit); 

			}
			else 
				hashFunction(digit);

			counter--;
		} 
		currentDigit++; 

	    PrintRadixSortTable(printWrit);
		ExecuteRadixSort(printWrit);
	}


	void moveToNextTable(PrintWriter printWrit) {
		if(!currentTable) { 
			for(int i = 0; i < 10; i++) {
				while(!Current_Hash_Table.hash_Table[i].isEmpty()) {
					String data = Current_Hash_Table.hash_Table[i].deleteHead();
					hashFunction(data);
				}   			
			}
			PrintRadixSortTable(printWrit);
		
		} else { 
			for(int i = 0; i < 10; i++) {
				while(!Previous_Hash_Table.hash_Table[i].isEmpty()) {
					String data = Previous_Hash_Table.hash_Table[i].deleteHead();
					hashFunction(data);
				}   			
			}
			PrintRadixSortTable(printWrit);
		}
	}

	void ExecuteRadixSort (PrintWriter printWrit) {
		while(currentDigit <= totalDigit ) {
			moveToNextTable(printWrit);
			currentDigit++;
		}
	}

	

}
