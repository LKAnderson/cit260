
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Produce a payroll report.
 */
public class W4dot2 {

    // Tax constants
    private final static double FEDERAL_TAX_RATE = 0.20;
    private final static double STATE_TAX_RATE = 0.09;

    public static void main(String[] argv) {

        try (Scanner scanner = new Scanner(System.in)) {

            DecimalFormat format = new DecimalFormat("$#,##0.00");

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

            // do the calculations
            double grossPay = hoursWorked * payRate;
            double federalWitholding = grossPay * FEDERAL_TAX_RATE;
            double stateWitholding = grossPay * STATE_TAX_RATE;
            double totalDeductions = federalWitholding + stateWitholding;
            double netPay = grossPay - totalDeductions;

            // Now print the report
            System.out.format("Employee Name:        %12s%n", employeeName);
            System.out.format("Hours worked:         %12.2f%n", hoursWorked);
            System.out.format("Pay Rate:             %12s/hr%n", format.format(payRate));
            System.out.format("Gross Pay:            %12s%n", format.format(grossPay));
            System.out.format("  Federal Witholding: %12s%n", format.format(federalWitholding));
            System.out.format("  State Witholding:   %12s%n", format.format(stateWitholding));
            System.out.format("  Total Deduction:    %12s%n", format.format(totalDeductions));
            System.out.format("Net Pay:              %12s%n", format.format(netPay));
        }
    }
}
