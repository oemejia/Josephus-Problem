/**
 *  @author Omar Mejia
 * CS 4365
 * Instructor: Dr. Martine Ceberio
 * Summer 2016
 * 
 */

import java.util.*;

public class Josephus {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tableSize;
		int kill;

		//I used two do-while loops to add redundancy for the input values
		do {
			System.out.print("\nEnter amount of people to sit on table: ");
			while (!input.hasNextInt()) {
				System.out.println("Only enter numbers! Try again.");
				input.next(); 
			}
			tableSize = input.nextInt();
		} while (tableSize < 0);

		
		do {
			System.out.print("\nEnter every k-th person to kill: ");
			while (!input.hasNextInt()) {
				System.out.println("Only enter numbers! Try again.");
				input.next();
			}
			kill = input.nextInt();
		} while (kill < 0);

		System.out.print("\nEnter the starting sitting position: ");
		int begin = input.nextInt();
		table(tableSize, begin, kill);
	}

	public static void table(int tableSize, int begin, int counts){

		ArrayList<Integer> table = new ArrayList<Integer>();
		for(int i = 0; i < tableSize; i++)
			table.add(i+1);

		System.out.print("People at table: ");	
		for(int i = 0; i < table.size(); i++)
			System.out.print(table.get(i) + " ");
		System.out.println();

		int walker = (begin-2) % tableSize;
		int counter = 1;

		//kill/remove people from array until only one person is standing
		int walker2 = tableSize;
		while(walker2 > 1){
			walker = (walker + counts) % tableSize--;
			int killed = walker--;
			//I use the suffix method to help with keeping track of the killing order when printing
			System.out.println(counter + suffix(counter) + " person killed: " + table.get(killed));
			counter++;
			table.remove(killed);
			walker2--;
		}
		for(int k = 0; k < table.size(); k++)
			System.out.println("Last person standing is " + table.get(k));

	}


	private static String suffix(int number) {
		if (number >= 11 && number <= 13) 
			return "th";
		if (number % 10 == 1)
			return "st";
		if(number % 10 == 2)
			return "nd";
		if(number % 10 == 3)
			return "rd";
		else
			return "th";
	}
}
