import java.util.*;
import java.text.*;

public class TaxRate {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in); // Creating a scanner to read in data
      NumberFormat nf = NumberFormat.getCurrencyInstance(); // Creating a NumberFormat object to help with formatting numbers later
      
      // Prompt the user to entre number of brackets, the maximum value for each bracket, and the tax rate for each bracket. We used two arrays to store the data in order of its bracket number.
      System.out.print("Welcome to the ultimate average tax rate calculator!\nPlease enter the number of income brackets: ");
      int numBrackets = console.nextInt(); 
      int[] maxValue = new int[numBrackets];
      double[] rate = new double[numBrackets];
      for (int i = 0; i < numBrackets - 1; i++) {
         System.out.print("Please enter the maximum value of bracket " + (i + 1) + ": ");
         maxValue[i] = console.nextInt();
         System.out.print("Please enter the tax rate of bracket " + (i + 1) + ": ");
         rate[i] = console.nextDouble();
      }
      
      // This is for the final bracket. Since the max possible number is 1 billion, we went with Integer.MAX_VALUE to be safe.
      maxValue[numBrackets - 1] = Integer.MAX_VALUE;
      System.out.print("Please enter the tax rate of bracket " + (numBrackets) + ": ");
      rate[numBrackets - 1] = console.nextDouble();
      
      //Finally, get the total income amount
      System.out.print("Please enter the total income to be taxed: ");
      int income = console.nextInt();
      
      // We need the original amount of income later so we can see if it is above the max value for each bracket
      int originalIncome = income;
      // This is the total tax amount that we tally up later
      int taxSum = 0;
      // This is the max value for the previous bracket which we use while and after iterating through the loop
      int prev = 0;
      // This is the index of the bracket in which the remainder of the income lies
      int last = 0;
      
      
      /* We loop through each bracket, first checking if the original income amount is greater than the max value of the bracket it is in
      * Next, we subtract the allocation amount from the income variable that changes
      * After this, we add the tax amount to the total by multiplying the taxable amount by the rate
      * Then, we print the allocation amount and tax amount with appropriate formatting using the NumberFormat object
      * Finally,we set the previous value to be the current before we iterate again
      * In the case that the original income is less than the max value for a bracket, we can set the last index with allocation to the current index and exit the loop
      */
      for (int i = 0; i < numBrackets; i++) {
         if (originalIncome > maxValue[i]) {
            income -= (maxValue[i] - prev);
            taxSum += (maxValue[i] - prev) * rate[i] / 100;
            System.out.println("Allocation of income for bracket " + (i + 1) + ": " + nf.format(maxValue[i] - prev));
            System.out.println("Tax amount for bracket " + (i + 1) + ": " + nf.format((maxValue[i] - prev) * rate[i] / 100));
            prev = maxValue[i];
         }
         else {
            last = i;
            break;
         }
      }
      
      // Here, we use the left over income to calculate the total tax amount and display the output
      taxSum += income * rate[last] / 100;
      System.out.println("Allocation of income for bracket " + (last + 1) + ": " + nf.format(income));
      System.out.println("Tax amount for bracket " + (last + 1) + ": " + nf.format(income * rate[last] / 100));
      
      System.out.println("Total tax amount: " + nf.format(taxSum));
      double averageRate = (100.0 * taxSum / originalIncome);
      System.out.print("Average tax rate: ");
      System.out.printf(" %.1f", averageRate);
      System.out.println("%");
      // Woohoo!
   }
}