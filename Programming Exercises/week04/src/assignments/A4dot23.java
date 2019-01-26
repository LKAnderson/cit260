package assignments;

import java.util.Scanner;
import java.text.DecimalFormat;

public class A4dot23 {

    public static void main(String[] argv) {

        try (Scanner scanner = new Scanner(System.in)) {

            DecimalFormat format = new DecimalFormat("$0.00");

            // Prompt for inputs
            System.out.print("Enter employee's name: ");
            String employeeName = scanner.nextLine().trim();
            if (employeeName.length() == 0) {
                System.err.println("Invalid name");
                return;
            }

            System.out.print("Enter number of hours worked in a week: ");
            double hoursWorked = scanner.nextDouble();
            if (hoursWorked < 0) {
                System.err.println("Invalid input");;
                return;
            }

            System.out.print("Enter the hourly payrate: ");
            double payRate = scanner.nextDouble();
            if (payRate <= 0) {
                System.err.println("Invalid input");
                return;
            }

            System.out.print("Enter federal tax withholding rate: ");
            double federalTaxRate = scanner.nextDouble();
            if (federalTaxRate < 0 || federalTaxRate > 100) {
                System.err.println("Invalid input");
                return;
            }
            

            System.out.print("Enter state tax withholding rate: ");
            double stateTaxRate = scanner.nextDouble();
            if (stateTaxRate < 0 || stateTaxRate > 100) {
                System.err.println("Invalid input");
                return;
            }
            
            // tax rates are assumed to be percentages, but if the user
            // enters a number greater than 1.0, turn it into a percentage.
            if (federalTaxRate > 1.0) {
                federalTaxRate /= 100.0;
            }
            
            if (stateTaxRate > 1.0) {
                stateTaxRate /= 100.0;
            }

            // do the calculations
            double grossPay = hoursWorked * payRate;
            double federalWitholding = grossPay * federalTaxRate / 100.0;
            double stateWitholding = grossPay * stateTaxRate / 100.0;
            double totalDeductions = federalWitholding + stateWitholding;
            double netPay = grossPay - totalDeductions;

            // Now print the report
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Hours worked:  " + hoursWorked);
            System.out.println("Pay Rate:      " + payRate);
            System.out.println("Gross Pay:     " + format.format(grossPay));
            System.out.println("Deductions:");
            System.out.format ("  Federal Witholding (%f%%): %s\n", 
                federalTaxRate, format.format(federalWitholding));
            System.out.format ("  State Witholding (%f%%): %s\n",
                stateTaxRate, format.format(stateWitholding));
            System.out.println("  Total Deduction: " + format.format(totalDeductions));
            System.out.println("Net Pay: " + format.format(netPay));

        }
    }

}
