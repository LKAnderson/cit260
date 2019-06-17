package assignments;

import java.util.Scanner;

public class A6dot7 {

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

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("The amount invested: ");
            double amountInvested = scanner.nextDouble();

            System.out.print("Annual interest rate: ");
            double yearlyInterest = scanner.nextDouble();
            if (yearlyInterest < 0) {
                System.err.println("Invalid interest rate");
                System.exit(1);
            }

            yearlyInterest = yearlyInterest / 100.0;

            String tableHeader   = "Years     Future Value\n";
            String tableTemplate = "%-5d     %12.02f\n";

            System.out.print(tableHeader);

            double futureValue = 0;
            for (int year = 1; year <= 30; year++) {
                futureValue = futureInvestmentValue(amountInvested, yearlyInterest/12, year);
                System.out.printf(tableTemplate, year, futureValue);
            }

        }

    }
    
}