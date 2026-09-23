package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private final List<Employee> employees;

    public EmployeeRoster() {
        this.employees = new ArrayList<>();
    }

    public boolean add(Employee employee) {
        if (employee == null) {
            return false;
        }
        return this.employees.add(employee);
    }

    public boolean removeById(int employeeId) {
        for (Employee employee : this.employees) {
            if (employee.getEmpID() == employeeId) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    public int size() {
        return this.employees.size();
    }

    public boolean isEmpty() {
        return this.employees.isEmpty();
    }

    public Employee get(int index) {
        return this.employees.get(index);
    }

    public int countHE() {
        return this.countType(HourlyEmployee.class);
    }

    public int countPWE() {
        return this.countType(PieceWorkerEmployee.class);
    }

    public int countCE() {
        return this.countType(CommissionEmployee.class);
    }

    public int countBPCE() {
        return this.countType(BasePlusCommissionEmployee.class);
    }

    private int countType(Class<? extends Employee> employeeType) {
        int count = 0;
        for (Employee employee : this.employees) {
            if (employee.getClass() == employeeType) {
                count++;
            }
        }
        return count;
    }

    public double totalPayroll(int currentMonth) {
        double total = 0.0;
        for (Employee employee : this.employees) {
            total += employee.computeSalary(currentMonth);
        }
        return total;
    }

    public void displayAllEmployees(int currentMonth) {
        for (Employee employee : this.employees) {
            double salary = employee.computeSalary(currentMonth);
            System.out.printf("ID: %d | Name: %-24s | Payout: \u20B1%,.2f%n",
                    employee.getEmpID(), employee.getEmpName(), salary);
        }
    }

    public void displayAllEmployees() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }
}
