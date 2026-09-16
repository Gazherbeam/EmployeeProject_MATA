package version3;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0);
    }

    public CommissionEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), 0.0);
    }

    public CommissionEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0);
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), totalSale);
    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        this(empID, empName, new MyDate(), new MyDate(), totalSale);
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate,
                              double totalSale) {
        super(empID, empName, birthDate, hireDate);
        this.setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return this.totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = Math.max(0.0, totalSale);
    }

    public double getCommissionRate() {
        if (this.totalSale < 50000.0) {
            return 0.05;
        }
        if (this.totalSale < 100000.0) {
            return 0.10;
        }
        if (this.totalSale < 500000.0) {
            return 0.15;
        }
        return 0.20;
    }

    @Override
    public double computeSalary() {
        return this.totalSale * this.getCommissionRate();
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        CommissionEmployee employee = (CommissionEmployee) object;
        return Double.compare(this.totalSale, employee.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [%s]", this.employeeDetails());
    }
}