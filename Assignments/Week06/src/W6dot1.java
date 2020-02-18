/**
 * Future Value Calculator.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class W6dot1 {

    /**
     * Calculate the future value of an investment.
     * @param investmentAmount
     * @param monthlyInterestRate
     * @param years
     * @return
     */
    public static double futureInvestmentValue(
                            double investmentAmount,
                            double monthlyInterestRate,
                            int years ) {
        
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years*12);
    }

    public static void main(String[] argv) {

        DecimalFormat formatter = new DecimalFormat("$#,##0.00");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("The amount invested: ");
            double amountInvested = scanner.nextDouble();
            if (amountInvested <= 0) {
                System.err.println("Amount must be greater than zero.");
                System.exit(1);
            }

            System.out.print("Annual interest rate: ");
            double yearlyInterest = scanner.nextDouble();
            if (yearlyInterest < 0 || yearlyInterest >= 100) {
                System.err.println("Invalid interest rate");
                System.exit(1);
            }

            yearlyInterest = yearlyInterest / 100.0;

            String tableHeader   = "Years     Future Value\n";
            String tableTemplate = "%-5d     %s\n";

            System.out.print(tableHeader);

            double futureValue = 0;
            for (int year = 1; year <= 10; year++) {
                futureValue = futureInvestmentValue(amountInvested, yearlyInterest/12, year);
                System.out.printf(tableTemplate, year, formatter.format(futureValue));
            }

        }

    }
    
}