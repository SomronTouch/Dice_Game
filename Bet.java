
//CLASS INITIALIZE VARIABLES AND METHODS
import javax.swing.JOptionPane;

public class Bet {

	// determining appropriate field values
	int money;
	int bet;
	int dice1;
	int dice2;
	int dice3;
	// checks to see if the bet input is valid, if it not, then invalidInput = true
	// if invalidInput = true, then it skips the rest of the loop, asking for a
	// valid input again
	boolean invalidInput = false;

	// Constructor
	public Bet() {
		super();
		// This is the initial starting money that the player holds at the start of the
		// game. This value should not be changed.
		this.money = 100;
		this.bet = 0;
	}

	// ---------------Getters-------------------//
	public double getMoney() {
		return money;
	}

	public double getBet() {
		return bet;
	}

	public int getDice1() {
		return dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public int getDice3() {
		return dice3;
	}

	public boolean getInvalidInput() {
		return invalidInput;
	}

	// ---------------Methods--------------------//

	// The function placeBet allows the user to input a bet within the
	// restrictions. When a bet is placed outside of the range, the program
	// will ask for another input until a valid input is given.
	public void placeBet(int bet) {
		if (bet > this.money) {
			JOptionPane.showMessageDialog(null,
					"Invalid amount. Insufficent funds\n" + "Current Balance = " + this.money);
			invalidInput = true;
		} else if (bet < 0) {
			JOptionPane.showMessageDialog(null, "Invalid amount\n" + "Current Balance = " + this.money);
			invalidInput = true;
		} else if (bet == 0) {
			JOptionPane.showMessageDialog(null, "You have left the table with " + this.money + " dollars");
		} else {
			this.bet = bet;
			this.money = this.money - this.bet;
			JOptionPane.showMessageDialog(null,
					"You placed a bet of " + bet + "\n" + "Your Current Balance = " + this.money);
			invalidInput = false;
		}
	}

	// This function generates a random number for each dice, simulating a dice
	// roll.
	// It also determines the conditional rewards the player receives depending on
	// the roll results
	public void diceRoll() {
		// Randomizes the roll of each dice
		this.dice1 = (int) (Math.random() * 6 + 1);
		this.dice2 = (int) (Math.random() * 6 + 1);
		this.dice3 = (int) (Math.random() * 6 + 1);

		// If the dice roll satisfies more than 1 condition
		// Prioritize the higher reward
		boolean singleReward = false;

		int sum = this.dice1 + this.dice2 + this.dice3;
		// Outputs the number each dice rolls individually
		JOptionPane.showMessageDialog(null, "Die 1 rolled " + this.dice1 + "\n" + "Die 2 rolled " + this.dice2 + "\n"
				+ "Die 3 rolled " + this.dice3 + "\n");

		// Conditions for diceRoll
		//
		// Triple Earning ------------------------------------------------------------
		if (this.dice1 == this.dice2 && this.dice2 == this.dice3) {
			this.money += this.bet * 3;
			singleReward = true;
			JOptionPane.showMessageDialog(null,
					"You earned triple your bet.\n" + "Your total earning this round was " + this.bet * 3);
			// Double Earning------------------------------------------------------------
		} else if (this.dice1 == this.dice2 || this.dice1 == this.dice3 || this.dice2 == this.dice3) {
			this.money += this.bet * 2;
			singleReward = true;
			JOptionPane.showMessageDialog(null,
					"You earned double your bet.\n" + "Your total earning this round was " + this.bet * 2);
			// Return back amount of the bet-------------------------------------------
		} else if (sum > 10 && singleReward == false) {
			this.money += this.bet;
			singleReward = true;
			JOptionPane.showMessageDialog(null, "The sum of all 3 dice is " + (this.dice1 + this.dice2 + this.dice3));
			JOptionPane.showMessageDialog(null,
					"You earned back your bet. \n" + "Your total earning this round was " + this.bet);
			// Lose the amount that was bet--------------------------------------------
		} else {
			JOptionPane.showMessageDialog(null, "Too bad you lost this round.");
		}
	}

	// The infamous COINAGE cheat ;)
	// Age of Empire reference.
	public void youCheater() {
		JOptionPane.showMessageDialog(null, "Cheat activated");
		this.money += 100;
	}

	public int betRoulette() {
		this.bet = (int) (Math.random() * this.money + 1);
		// Epic Story of a man who places his faith in RNG
		JOptionPane.showMessageDialog(null,
				"The player tilts their hat over their eyes, open palm pressed against their heart\n"
						+ "Dealer: 'Are you sure this is what you want?'\n"
						+ "The player nods...grabbing a handful of coins from their pouch\n"
						+ "The player slams the coins onto the table, rattling the whole bar \n"
						+ "Whats the count dealer?\n" + "Dealer: " + (int) this.bet + " coins");
		this.money -= (int) this.bet;
		return (int) this.bet;
	}

}
