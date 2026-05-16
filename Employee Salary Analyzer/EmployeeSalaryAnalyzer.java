import java.util.Scanner;

public class EmployeeSalaryAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of employees must be greater than 0.");
            sc.close();
            return;
        }

        String[] employeeNames = new String[n];
        double[] salaries = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1));

            System.out.print("Enter employee name: ");
            employeeNames[i] = sc.nextLine();

            System.out.print("Enter salary: ");
            salaries[i] = sc.nextDouble();
            sc.nextLine();
        }

        double totalSalary = 0;
        double highestSalary = salaries[0];
        double lowestSalary = salaries[0];

        int highestSalaryIndex = 0;
        int lowestSalaryIndex = 0;

        for (int i = 0; i < n; i++) {

            totalSalary = totalSalary + salaries[i];

            if (salaries[i] > highestSalary) {
                highestSalary = salaries[i];
                highestSalaryIndex = i;
            }

            if (salaries[i] < lowestSalary) {
                lowestSalary = salaries[i];
                lowestSalaryIndex = i;
            }
        }

        double averageSalary = totalSalary / n;

        int aboveAverageCount = 0;
        int belowAverageCount = 0;

        for (int i = 0; i < n; i++) {
            if (salaries[i] > averageSalary) {
                aboveAverageCount++;
            } else if (salaries[i] < averageSalary) {
                belowAverageCount++;
            }
        }

        System.out.println("\n----- Employee Salary Report -----");

        System.out.println("\nEmployee Details:");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + employeeNames[i] + " - Salary: " + salaries[i]);
        }

        System.out.println("\nTotal Salary: " + totalSalary);
        System.out.println("Average Salary: " + averageSalary);

        System.out.println("Highest Salary: " + highestSalary);
        System.out.println("Employee With Highest Salary: " + employeeNames[highestSalaryIndex]);

        System.out.println("Lowest Salary: " + lowestSalary);
        System.out.println("Employee With Lowest Salary: " + employeeNames[lowestSalaryIndex]);

        System.out.println("Employees Above Average Salary: " + aboveAverageCount);
        System.out.println("Employees Below Average Salary: " + belowAverageCount);

        sc.close();
    }
}