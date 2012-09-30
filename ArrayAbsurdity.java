package arrayAbsurdityChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ArrayAbsurdity {

	/**
	 * Reads the file given and prints the elements in it in a spiral order
	 * 
	 * @param path - The path of the input file
	 */
	private void printDuplicateResult(String path){
		

		try {

			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while( ( line = br.readLine() ) != null){

				try{
					int duplicateNum = searchDuplicate(line);
					
					//Print result
					System.out.println( "" + Integer.toString(duplicateNum) );
				}
				catch(NumberFormatException e){
					System.out.println("The row representing the table is not well formed. " +
											"Doesn't Work " +
											e.getMessage() );
				}
				catch(Exception f){
					System.out.println("Input was not well formed: " + f.toString() );
				}
				
				
			}
			fr.close();
			
		}catch(IOException g){
			System.out.println("Cannot read input file" + g.toString() );
		}
		catch (Exception h) {
			System.out.println("Input was not well formed: " + h.toString() );
		}
		
		
	}
	
	/**
	 * Takes the line, searches through looking for duplicates. 
	 * Upon finding it, returns.
	 * Time complexity:		c*O(n)
	 * Space complexity: 	c*O(n)
	 * 
	 * @param line - Line of the input file representing the numbers
	 * @return - Integer representation of the duplication
	 */
	private int searchDuplicate(String line){
		
		// Splits the input string for the number declaring the dimension and
		// for the comma separated list of numbers -> Time: O(n) , Space: O(n)
		String[] parts 			= line.split(";");
		
		int dimension 			= Integer.valueOf(parts[0]);
		
		// Turns the comma separated list of numbers 
		// to String Array -> Time: O(n) , Space: O(n)
		String[] numbers 		= parts[1].split(",");
		
		// Creates another String Array were the numbers can be inserted
		// at the index same as their value.
		// This helps searching in the list in O(1) time. -> Time O(n), Space: O(n)
		String[] indexedNumbers	= new String[dimension-1];
		Arrays.fill(indexedNumbers, "N");
		
		// Filling up the index-consistent array vith the numbers. In the meantime
		// Checks for duplication, if found, returns -> Time: O(n) Space: null
		for( String number : numbers ){
			
			if( ! indexedNumbers[Integer.valueOf(number)].equals("N") )
				return Integer.valueOf(number) ;
			else
				indexedNumbers[Integer.valueOf(number)] = number ;
			
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayAbsurdity arrayAbs = new ArrayAbsurdity();
		
		try{	
			arrayAbs.printDuplicateResult(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException ae){
			System.out.print( "\nNo argument given. Please give path of input file as arhument. " + ae.getMessage() );
		}
		
		
	}

}
