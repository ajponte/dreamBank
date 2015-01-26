package predictStock;

import java.util.ArrayList;
import java.util.Arrays;
/** Main entry point.  Given a user's 
 *  list of personal and financial 
 *  information, finds a stock for them.
 *  
 *  @author Alan Ponte
 */
public class Main {
	/** ARGS[0] will be a list of data points
	 *  corresponding to the user's information.
	 *  The list should be in order, and should
	 *  be of the form 
	 *   (<Email>, <Risk Assessment>, <Income to Spend on Stock>,
	 *    <Preferred Time Duration of Stock>, 
	 *    <Risk of Total Portfolio>).
	 */
	public static void main(String[] args) {
		ArrayList<String> vals;
		String[] cmdVals = null;
		try {
			cmdVals = args[0].split(",");
		} catch (ArrayIndexOutOfBoundsException e) {
			printHelp();
			System.exit(0);
		}
		vals = (ArrayList) Arrays.asList(cmdVals);
		StockGetter getter = new StockGetter(vals);
		String stock = getter.getStock();
		
	}
	
	/** Prints a help message to the user. */
	private static void printHelp() {
		System.out.println("Usage: " + 
				"java predictStock.Main <DATA>");
		System.out.println("Where DATA is a comma seperated list containing " +
				"the following information:");
		System.out.println("<Email>, <Risk Assessment>, <Income to Spend on Stock>" +  
				"<Preferred Time Duration of Stock>,<Risk of Total Portfolio>");
	}

}
