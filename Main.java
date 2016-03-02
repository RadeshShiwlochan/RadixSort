import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		/**
		 * @param maxNumber for storing largest number
		 * @param numberReadIn the data retrieved from input file
		 * @param inFile object for storing input file
		 * @param outFile object for outputting to output file
		 */
		int maxNumber = 0;
		int numberReadIn;
		File inFile = new File(args[0]);;
		File outFile = new File(args[1]);;
        /**
         * @param input- Scanner object for input file
         * read in data and find the largest number in data set
         * close the file
         * allocate the hashTable
         * call the hashForBucketSort
         * Print the HashTable by outputting to output file
         */
		try {
			Scanner input = new Scanner(inFile);
			//open the file, read entire data to find the largest number
			while(input.hasNext()) {
				numberReadIn = input.nextInt();
				if(maxNumber < numberReadIn)
					maxNumber = numberReadIn;
			}
			input.close();
		} catch (FileNotFoundException error) {
			System.out.println(error);
		}
			BucketSort HashTable = new BucketSort(maxNumber + 1, inFile, outFile);
			HashTable.hashForBucketSort();
			HashTable.PrintTable();
		
	}

}
