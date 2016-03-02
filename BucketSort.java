import java.util.Scanner;
import java.io.*;

public class BucketSort {
	private int [] hashTable;
	private static int size;
	private Scanner inputFile;
	private PrintWriter outputFile;
    /**
     * 
     * @param is the field for size of the hashTable
     * @param fileIn name of the input file
     * @param fileOut name of the field to output to file
     * @throws FileNotFoundException throws exception if error in reading and outputting
     * file.
     */
	//constructor for setting the parameters
	public BucketSort(int size, File fileIn, File fileOut) {
		try {
		this.size = size;
		hashTable = new int[size];
		inputFile = new Scanner(fileIn);
		outputFile = new PrintWriter(fileOut);
		} catch(FileNotFoundException error) {
			System.out.println(error);
		}
	}

	public static int findMax(int value) {
		int max = 0;
		if(max < value)
			max = value; 	 
		return max;
	}
    /**
     * while file is not empty, read in data from the file
     * set hashIndex to the inputFile data that is read in
     * hash hashIndex by moding by the size of hashTable
     * increment the number at the hashTable, at that index.
     * repeated similar numbers are increment in the index
     * at the value of the hashTable
     * repeat until file is empty  
     * close the file
     */
	public void hashForBucketSort() {
		while(inputFile.hasNext()) {
			int hashIndex = inputFile.nextInt();
			hashTable[hashIndex % size]++;
		}
		inputFile.close();
	}
    
	/**
	 * function to print to the output file
	 * use a for loop to go through the data in the hashtable
	 * use a nested while loop to test if the frequency is greater than
	 * 0, if true print the index and the frequency, decrement the frequency
	 * as it is printed
	 * repeat until finish going through hashTable 
	 */
	public void PrintTable() {
		for(int i = 0 ; i < size;i++) {
			while(hashTable[i] > 0)  {		 
				outputFile.print(i + "   " + hashTable[i] + "\n");
				System.out.println(i + "   " + hashTable[i] + "  ");
				hashTable[i]--;
			}
		}
		outputFile.flush();
		outputFile.close();
	} 


}
