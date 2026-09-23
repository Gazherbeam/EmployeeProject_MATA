package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() { this(0, new Name(), new MyDate(), new MyDate(), 0, 0); }
    public BasePlusCommissionEmployee(int id, String name, double sales, double base) {
        this(id, Name.fromString(name), new MyDate(), new MyDate(), sales, base);
    }
    public BasePlusCommissionEmployee(int id, Name name, MyDate birth, MyDate hire, double sales, double base) {
        super(id, name, birth, hire, sales);
        this.setBaseSalary(base);
    }

    public double getBaseSalary() { return this.baseSalary; }
    public void setBaseSalary(double value) { this.baseSalary = Math.max(0, value); }

    @Override
    public double computeSalary(int currentMonth) {
        return this.baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) object;
        return Double.compare(this.baseSalary, employee.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.baseSalary);
    }

    @Override public BasePlusCommissionEmployee clone() { return (BasePlusCommissionEmployee) super.clone(); }
    @Override public String toString() { return String.format("BasePlusCommissionEmployee [%s]", this.employeeDetails()); }
}
