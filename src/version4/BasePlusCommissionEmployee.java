package version4;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public BasePlusCommissionEmployee(int id, String name, double sales, double base) {
        this(id, Name.fromString(name), new MyDate(), new MyDate(), sales, base);
    }

    public BasePlusCommissionEmployee(int id, Name name, MyDate birth, MyDate hire,
            double sales, double base) {
        super(id, name, birth, hire, sales);
        this.setBaseSalary(base);
    }

    public double getBaseSalary() { return this.baseSalary; }
    public void setBaseSalary(double value) { this.baseSalary = Math.max(0, value); }
    @Override
    public double computeSalary() {
        return this.baseSalary + super.computeSalary();
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [%s]", this.employeeDetails());
    }
}
