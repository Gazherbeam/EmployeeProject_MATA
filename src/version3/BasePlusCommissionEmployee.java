package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), totalSale, baseSalary);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        this(empID, empName, new MyDate(), new MyDate(), totalSale, baseSalary);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, hireDate, totalSale);
        this.setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = Math.max(0.0, baseSalary);
    }

    @Override
    public double computeSalary() {
        return this.baseSalary + super.computeSalary();
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) object;
        return Double.compare(this.baseSalary, employee.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [%s]", this.employeeDetails());
    }
}