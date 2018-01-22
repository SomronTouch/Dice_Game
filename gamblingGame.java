
//MAIN CLASS
import javax.swing.JOptionPane;

public class gamblingGame {

	public static void main(String[] args) {
		Bet bet = new Bet();

		// Game Start - Starts off with Game Instructions
		JOptionPane.showMessageDialog(null,
				"The rules are simple, you are against the dealer. You start with a balance of 100 dollars.\n "
						+ "Every turn the dealer will ask you to bet some money. After you decide the amount you want \n"
						+ "to bet you will roll three dices. Depending on the outcome, you will either win or lose money.\n"
						+ "Keep going until you win 1000 dollars...if you're feeling lucky that is. ");
		JOptionPane.showMessageDialog(null, "Here is a list of possible outcomes");
		JOptionPane.showMessageDialog(null, "If all dices share the same value = Gain triple the amount of your bet\n"
				+ "If any two dice share the same vallue = Gain double the amount of your bet\n"
				+ "If the sum of all three dices is greater than the value of 10 = Gain the amount of your bet\n"
				+ "If none of the above = Lose the amount that you bet");
		while (bet.getMoney() > 0) {
			String input = JOptionPane.showInputDialog("Current Balance = " + bet.getMoney() + "\n" + "Place your bet");
			// activating cheat
			if (input.equals("~")) {
				bet.youCheater();
				// Activates RNG mode
			} else if (input.equals("?")) {
				bet.betRoulette();
				bet.diceRoll();
			} else {
				// Checks to see if player activates cheat before converting the value into a
				// double
				int betting = Integer.parseInt(input);
				// checks to see if the value that was bet is within the range of 0 and current
				// bet.getMoney
				// if bet is equal to 0, then the player leaves with the remaining balance
				// if the player inputs a value outside of the restrictions, the loop skips to
				// the beginning.
				bet.placeBet(betting);
				if (betting == 0) {
					break;
				} else if (bet.getInvalidInput() == true) {
					continue;

				}
				// Initiates the dice roll + conditional rewards
				bet.diceRoll();
				// Winning the game
				if (bet.getMoney() >= 1000) {
					break;
				}
			}
		}

		// Message after losing the game
		if (bet.getMoney() == 0) {
			JOptionPane.showMessageDialog(null, "Unfortunately you ran out of money");
			JOptionPane.showMessageDialog(null, "Try using the '~' key next time, it might help you out in a pinch :)");
			// Game Ends
		} else if (bet.getMoney() > 1000) {
			JOptionPane.showMessageDialog(null,
					"That is some luck you have there, I have no more money to give.\n" 
				  + "Congratulations, you beat me!");
		}
	}

}
