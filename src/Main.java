import version5.BasePlusCommissionEmployee;
import version5.CommissionEmployee;
import version5.Employee;
import version5.EmployeeRoster;
import version5.HourlyEmployee;
import version5.MyDate;
import version5.Name;
import version5.PieceWorkerEmployee;

public class Main {
    private static final int TARGET_MONTH = 9;

    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();

        Employee hourlyEmployee = new HourlyEmployee(
                101, new Name("Alice", "M.", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0F, 200.0);
        Employee pieceWorkerEmployee = new PieceWorkerEmployee(
                201, new Name("Bob", "C. Jr.", "Jones"),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        Employee commissionEmployee = new CommissionEmployee(
                301, new Name("Maria", "L.", "Reyes"),
                new MyDate(12, 9, 1995), new MyDate(1, 1, 2020), 100000.0);
        Employee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                401, new Name("Kevin", "S.", "Tan"),
                new MyDate(20, 3, 1990), new MyDate(1, 1, 2019), 80000.0, 24000.0);

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        enroll(roster, hourlyEmployee, "Hourly");
        enroll(roster, pieceWorkerEmployee, "Piece Worker");
        enroll(roster, commissionEmployee, "Commission");
        enroll(roster, basePlusCommissionEmployee, "Base Plus Commission");
        System.out.println("Total Roster Size: " + roster.size() + " employees");

        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayAllEmployees(TARGET_MONTH);
        System.out.printf("Total Payroll: \u20B1%,.2f%n", roster.totalPayroll(TARGET_MONTH));

        System.out.println("\n======================================================================");
        System.out.println("COLLECTION COUNTS");
        System.out.println("======================================================================");
        System.out.println("Hourly employees: " + roster.countHE());
        System.out.println("Piece workers: " + roster.countPWE());
        System.out.println("Commission employees: " + roster.countCE());
        System.out.println("Base-plus-commission employees: " + roster.countBPCE());

        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.println("Removing Employee ID 201... "
                + (roster.removeById(201) ? "Successfully removed." : "Employee not found."));
        System.out.println("Updated Roster Size: " + roster.size());
        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();
    }

    private static void enroll(EmployeeRoster roster, Employee employee, String employeeType) {
        if (roster.add(employee)) {
            System.out.printf("Enrolled: %-24s (%s)%n", employee.getEmpName(), employeeType);
        }
    }
}
