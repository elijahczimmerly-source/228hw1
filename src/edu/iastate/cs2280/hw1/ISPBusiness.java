package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int r = 0; r < tOld.getLength(); r++) {
			for (int c = 0; c < tOld.getWidth(); c++) {
				tNew.grid[r][c] = tOld.grid[r][c].next(tNew);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		for (TownCell[] row : town.grid) {
			for(TownCell townCell : row) {
				if(townCell.who() == State.CASUAL) {
					profit++;
				}
			}
		}
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		Scanner scnr = new Scanner(System.in);
		int userNum = 0;
		while(!(userNum == 1 || userNum == 2)){
			System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
			try {
				userNum = Integer.parseInt(scnr.nextLine());
			}
			catch (NumberFormatException e) {
				
			}
			if (!(userNum == 1 || userNum == 2)) {
				System.out.println("Invalid input, please enter 1 or 2");
			}
		}
		
		Town town = null;
		
		if (userNum == 1) {
			boolean valid = false;
			while(!valid){
				System.out.println("Please enter file path:");	
				String filePath = scnr.nextLine();
				try {
					town = new Town(filePath);
					valid = true;
				}
				catch (FileNotFoundException e) {
					System.out.println("File not found. Try again.");
				}
			}
		}
		else {
			boolean valid = false;
			int length=0, width=0, seed=0;
			while(!valid){
				System.out.println("Provide rows, cols and seed integer separated by spaces: ");
				String[] userNumArray = scnr.nextLine().split(" ");
				if (userNumArray.length != 3) {
					System.out.println("Please enter exactly 3 integers");
					continue;
				}
				try {
					length = Integer.parseInt(userNumArray[0]);
					width = Integer.parseInt(userNumArray[1]);
					seed = Integer.parseInt(userNumArray[2]);
					valid = true;
				}
				catch (NumberFormatException e) {
					System.out.println("Please enter valid integers");
				}
			}
			town = new Town(length, width);
			town.randomInit(seed);
		}
		scnr.close();
		double tProfit = 0;
		for(int i = 0; i < 12; i++) {
			tProfit += getProfit(town);
			town = updatePlain(town);
		}
		double pProfit = town.getLength() * town.getWidth() * 12;
		double profitUtilization = 100.0 * tProfit / pProfit;
		System.out.printf("%.2f", profitUtilization);
		System.out.println("%");
		
	}
}
