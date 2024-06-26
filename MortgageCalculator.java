import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

  private static final int MONTHS_IN_A_YEAR = 12;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Taking input for the principal amount
    System.out.println("Enter the principal amount of the loan: ");
    double principalAmount = scanner.nextDouble();

    // Taking input for the annual interest rate
    System.out.println("Enter the annual interest rate:");
    float yearlyInterestRate = scanner.nextFloat();
    yearlyInterestRate = yearlyInterestRate / 100;

    // Taking input for the time period of loan in years
    System.out.println("Enter the term of the loan in years:");
    int termInYear = scanner.nextInt();

    // Calculating the monthly interest rate from the given yearly
    float monthlyInterestRate = yearlyInterestRate / MONTHS_IN_A_YEAR;

    // Calculating the numbers of months for which the payment will be divided
    int numberOfPayments = termInYear * MONTHS_IN_A_YEAR;

    double monthlyPayment = principalAmount * (
      (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) / ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
    );

    // Using the number format class to format the amount that user has to pay
    System.out.println("Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));

    // Calculating and printing the total amount that the user has to pay
    double totalAmount = monthlyPayment * numberOfPayments;
    System.out.println("The total payback amount is: " + NumberFormat.getCurrencyInstance().format(totalAmount));

    scanner.close();
  }
}
