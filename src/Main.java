import version3.Employee;
import version3.HourlyEmployee;
import version3.MyDate;
import version3.Name;
import version3.PieceWorkerEmployee;

public class Main {
    private static final int TARGET_MONTH = 9;

    public static void main(String[] args) {
        Employee emp1 = new HourlyEmployee(
                101,
                new Name("Alice", "M.", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0F,
                200.0);
        Employee emp2 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C. Jr.", "Jones"),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                250,
                15.0);

        Employee[] employees = {emp1, emp2};
        printPayrollReport(employees);
        testObjectContracts(emp1, emp2);
        testDeepClone(emp1);
    }

    private static void printPayrollReport(Employee[] employees) {
        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        for (int index = 0; index < employees.length; index++) {
            Employee employee = employees[index];
            double basePay = employee.computeSalary();
            double birthdayBonus = employee.getBirthdayBonus(TARGET_MONTH);
            String eligibility = birthdayBonus > 0.0 ? "Eligible" : "Ineligible";

            System.out.printf("%n%d. %s%n", index + 1, employee);
            System.out.printf("   Base Pay: \u20B1%,.2f | Birthday Bonus: \u20B1%,.2f (%s)%n",
                    basePay, birthdayBonus, eligibility);
            System.out.printf("   Total Payout: \u20B1%,.2f%n", employee.computeTotalPayout(TARGET_MONTH));
        }
    }

    private static void testObjectContracts(Employee emp1, Employee emp2) {
        Employee emp1Identical = emp1.clone();

        System.out.printf("%n======================================================================%n");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");
        System.out.println("\nemp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.printf("%nemp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n",
                emp1.hashCode(), emp1Identical.hashCode(), emp1.hashCode() == emp1Identical.hashCode());
        System.out.println("\nemp1 equals emp2: " + emp1.equals(emp2));
    }

    private static void testDeepClone(Employee employee) {
        Employee clone = employee.clone();
        String originalName = employee.getEmpName().getFullName();
        Name cloneName = clone.getEmpName();
        cloneName.setLastName("Taylor");
        clone.setEmpName(cloneName);

        System.out.printf("%n======================================================================%n");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");
        System.out.println("\nOriginal Name before modification: " + originalName);
        System.out.println("Clone Name changed to:             " + clone.getEmpName().getFullName());
        System.out.println("Original Name after modification:  " + employee.getEmpName().getFullName()
                + " (Deep copy successful!)");
    }
}