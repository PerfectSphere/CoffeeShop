//Hunter Mckeever
//2/12/2020
//Final

import java.util.Scanner;

class Drink{
	//Declarations
	private String size;
	private String flavor;
	private boolean whipCream;
	private double cost;
	
	Drink(String s, String f, boolean w, double c) { // Constructor
		size = s;
		flavor = f;
		whipCream = w;
		cost = c;
	}
	
	void showDrink() { // So we can display the order at the end of the program
		if(whipCream == true){
			System.out.println("$" + cost + ": " + size + " " + flavor + " with whipcream.");
		} else {
			System.out.println("$" + cost + ": " + size + " " + flavor + " with no whipcream.");
		}
	}
	
	double cost() { // For when we are adding up the total
		return cost;
	}
}

class CoffeeShop {
	public static void main(String args[]){
		// Declarations
		Scanner sc = new Scanner(System.in);
		int type, counterForDrinks, drinkType, sizeChoice, whipCreamChoice;
		boolean result, whipCream;
		String drink, drinkSize;
		Drink drinks[] = new Drink[3];
		double total = 0, totalWithTax, tax;
		
		// Welcome user to the store and ask whether he wants to buy a drink or leave.
		System.out.println("Hello, welcome to the Riverside Coffee Shop! What can I get started for you today?\n"); 
		System.out.println("\t1. Purchase Drink\n\t2. Exit store\n");
		System.out.print("Please choose between 1 and 2: ");
		type = Integer.parseInt(sc.nextLine()); //Read user input
		
		switch(type){ // If choice 1, run the drink purchase section of the code
			case 1:
			System.out.println("How many drinks will you be buying today?: "); // We're asking because we can't initialize an array of a size we don't know yet.
			counterForDrinks = Integer.parseInt(sc.nextLine());
			drinks = new Drink[counterForDrinks]; 
			for(int i = 0; i < counterForDrinks; i++) { // Go through the ordering process X many times
				double cost = 0;
				
				//Choose a drink
				System.out.println("\nPlease select a drink from our menu: ");
				System.out.println("\t1. $3.00 Coffee Frappucino\n\t2. $3.00 Coffee Macchiato\n\t3. $2.50 Iced Coffee\n\t4. $3.25 Coffee Frappucino with added caramel\n\t5. $3.25 Coffee Macchiato with added caramel.\n\t6. $2.50 Regular Hot Coffee\n");
				System.out.print("Please choose a drink: ");
				drinkType = Integer.parseInt(sc.nextLine());
				switch(drinkType){
					case 1:
					drink = "Coffee Frappucino";
					cost += 3.00;
					break;
					case 2:
					drink = "Coffee Macchiato";
					cost += 3.00;
					break;
					case 3:
					drink = "Iced Coffee";
					cost += 2.50;
					break;
					case 4:
					drink = "Coffee Frappucino with added caramel";
					cost += 3.25;
					break;
					case 5:
					drink = "Coffee Macchiato with added caramel";
					cost += 3.25;
					break;
					case 6:
					drink = "Regular Hot Coffee";
					cost += 2.50;
					break;
					default: //By default give them a regular hot coffee
					drink = "Regular Hot Coffee";
					cost += 2.50;
					break;
				}
				
				//Choose a size for the drink
				System.out.println("\nPlease select a size for this drink: ");
				System.out.println("\t1. $0.00 Small\n\t2. $0.50 Medium\n\t3. $1.00 Large\n");
				System.out.print("Please choose a size: ");
				sizeChoice = Integer.parseInt(sc.nextLine());
				switch(sizeChoice){
					case 2:
					cost += 0.50;
					drinkSize = "Medium";
					break;
					case 3:
					cost += 1.00;
					drinkSize = "Large";
					break;
					default: //By default give them a small
					drinkSize = "Small";
					break;
				}
				
				//Choose whether or not you want whipcream
				System.out.println("\nWould you like to add whipcream to that for an additional $0.10? ");
				System.out.println("\t1. Yes\n\t2. No\n");
				System.out.print("Please choose between 1 and 2: ");
				whipCreamChoice = Integer.parseInt(sc.nextLine());
				switch(whipCreamChoice){
					case 1: 
					whipCream = true;
					cost += 0.10;
					break;
					case 2:
					whipCream = false;
					default: //By default give them no whipcream
					whipCream = false;
					break;
				}
				
				drinks[i] = new Drink(drinkSize, drink, whipCream, cost); // Add the drink information to the object in the array
			}
			break;
			case 2: // Exit program if user leaves store
			System.exit(0);
			break; 
			default: // Exit if they put anything else, assume they wanted to leave.
			System.exit(0);
			break;
		}
		
		System.out.println("\nThis is your order for today: \n"); // Display all items ordered today and add up the cost
		for(int i = 0; i < drinks.length; i++){
			drinks[i].showDrink();
			total += drinks[i].cost();
		}
	
		tax = total * 0.05;
		totalWithTax = total + tax;  //Add 5% tax
		
		System.out.println("\nThe items add up to: $" + total);
		System.out.println("Your total plus tax comes to: $" + totalWithTax);
		System.out.println("\nThanks for your purchase today, your order will be done right away!");
	}
}