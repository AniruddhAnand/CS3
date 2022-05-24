import java.util.*;
import java.text.*;

public class Balance {
   public static void main(String[] args) {
      double money = 0;
      Scanner console = new Scanner(System.in);
      // This is a classic fence-post problem. We start with a fence in this case, and then go post-fence-post-fence, you know the drill.
      // Gather initial amount
      System.out.print("Transaction: ");
      double addition = console.nextDouble();
      NumberFormat nf = NumberFormat.getCurrencyInstance();
      // Continue to add or subtract from the balance until the user enters 0 to exit the loop.
      while (addition != 0) {
         money += addition;
         if (money < 0) {
            String formatted = "$-" + nf.format(money).substring(2);
            System.out.println("ALERT: Your account has a negative balance of " + formatted + "!");
         }
         else if (money < 250) { // We do an if-else here so that it does not print out both messages and so the negative message takes priority.
            System.out.println("WARNING: Your balance of " + nf.format(money) + " is less than $250.");
         }
         System.out.print("Transaction: ");
         addition = console.nextDouble();
      }
      // Finally, we do some formatting stuff based on polarity to display the final balance as required.
      String formatted;
      if (money < 0) {
         formatted = "$-" + nf.format(money).substring(2);
         System.out.println("Your final balance is " + formatted + ".");
      } else {
         System.out.println("Your final balance is " + nf.format(money) + ".");
      }
      // Woohoo!
   }
}