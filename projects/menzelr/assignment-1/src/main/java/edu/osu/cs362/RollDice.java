import java.util.*;

class Dice{
		private int die1;

		public Dice(){
			//constructor
			roll();
		}
		//without args assumes d6
		public void roll(){
			//BUG: need to add + 1 to random number to get number between 1 and 6. 
			//this will produce result between 0 and 5
			die1 = (int)(Math.random() * 6);
		}
		//method to simulate die roll having specified side count
		public void roll(int sides){
			die1 = (int)(Math.random() * sides) + 1;
		}
		public int getDie1(){
			return die1;
		}
		//simple list sum method
		public int getTotal(List<Integer> list){
			int total = 0;
			//BUG: <= list.size() should crash program -> array out of bounds
			//should be < list.size()
			for (int i = 0; i <= list.size(); i++) {
				total += list.get(i);
			}
			return total;
		}
		//detects prescence of critcal hits or misses
		public int crit(List<Integer> list, int sides){
			if(list.contains(sides)) {
				return 1;
			} else if(list.contains(1)) {
				return -1;
			}
			return 0;
		}
} //end class Dice

public class RollDice {
		
		public static void main(String[] args) {
			
				int dieType = 0; 												//number of side for dice <- args[0]
				int dieCount = 0;												//number of dice to roll <- args[1]
				int rollCount;													//number of completed rolls
					
				List<Integer> diceList = new ArrayList<Integer>();//list to hold rolled values 
				int sideArr[] = {4,6,8,10,12,20}; 			//array containing valid values for args[0] aka die type
					
				Dice dice = new Dice();									//create instance of Dice object
					
				if (args.length == 0) {
					dice.roll();
					System.out.println(dice.getDie1());
				}
				//BUG: using == 1 will crash program (index out of bounds) 
				//should be == 2
				else if (args.length == 1){
								 
					
					//attempt to parse args[0] as an int
					try {
						dieType = Integer.parseInt(args[0]);
					} catch(NumberFormatException e) {
						System.err.println("\n" + (char)27 + "[31m!!ERROR!!" + (char)27 + "[0m Argument " + args[0] + " must be an integer.\n");
						System.exit(2);
					}
					//verify that dieType is valid
					//binarySearch returns >= only if target is found in array
					//BUG: >= 0 will cause unusual behavior
					//should be < 0
					if (Arrays.binarySearch(sideArr, dieType) >= 0) {
						System.err.println("\n" + (char)27 + "[31m!!ERROR!!" + (char)27 + "[0m Specified die type " + dieType + " is not valid. Accepted values are 4, 6, 8, 10, 12, or 20\n");
						System.exit(3);
					}
					//attempt to parse args[1] as an int
					try {
						dieCount = Integer.parseInt(args[1]);
					} catch(NumberFormatException e) {
						System.err.println("\n" + (char)27 + "[31m!!ERROR!!" + (char)27 + "[0m Argument " + args[1] + " must be an integer.\n");
						System.exit(4);
					}
					//roll
					for (rollCount = 0; rollCount < dieCount; rollCount++) {
						dice.roll(dieType);
						diceList.add(dice.getDie1());
					}
					for (int i = 0; i < dieCount; i++) {
						System.out.println("Die " + i + " = " + diceList.get(i));
					}
					System.out.println("Total = " + dice.getTotal(diceList));					
					if(dice.crit(diceList, dieType) == 1) {
						System.out.println("Critical Hit!");
					} else if (dice.crit(diceList, dieType) == -1) {
						System.out.println("Critical Miss!");
					}

				} else {
					System.err.println("\n" + (char)27 + "[31m!!ERROR!!" + (char)27 + "[0m Incorrect Number of Arguments in Program Call!");
					System.err.println("Invoke as follows: java RollDice <dice type> <dice count> OR java RollDice\n");
					System.exit(1);
				}
		}
} //end class RollDice
