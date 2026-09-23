package version5;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() { this(0, new Name(), new MyDate(), new MyDate(), 0); }
    public CommissionEmployee(int id, String name, double sales) {
        this(id, Name.fromString(name), new MyDate(), new MyDate(), sales);
    }
    public CommissionEmployee(int id, Name name, MyDate birth, MyDate hire, double sales) {
        super(id, name, birth, hire);
        this.setTotalSale(sales);
    }

    public double getTotalSale() { return this.totalSale; }
    public void setTotalSale(double value) { this.totalSale = Math.max(0, value); }
    public double getCommissionRate() {
        if (this.totalSale < 50000) return 0.05;
        if (this.totalSale < 100000) return 0.10;
        if (this.totalSale < 500000) return 0.15;
        return 0.20;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = this.totalSale * this.getCommissionRate();
        return basePay + this.getBirthdayBonus(currentMonth);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) return false;
        CommissionEmployee employee = (CommissionEmployee) object;
        return Double.compare(this.totalSale, employee.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.totalSale);
    }

    @Override public CommissionEmployee clone() { return (CommissionEmployee) super.clone(); }
    @Override public String toString() { return String.format("CommissionEmployee [%s]", this.employeeDetails()); }
}
