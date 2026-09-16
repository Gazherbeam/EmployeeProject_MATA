package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0.0F, 0.0);
    }

    public HourlyEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), 0.0F, 0.0);
    }

    public HourlyEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0.0F, 0.0);
    }

    public HourlyEmployee(int empID, String empName, float hours, double rate) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), hours, rate);
    }

    public HourlyEmployee(int empID, Name empName, float hours, double rate) {
        this(empID, empName, new MyDate(), new MyDate(), hours, rate);
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate,
                          float hours, double rate) {
        super(empID, empName, birthDate, hireDate);
        this.setTotalHoursWorked(hours);
        this.setRatePerHour(rate);
    }

    public HourlyEmployee(int empID, String empName, MyDate birthDate, MyDate hireDate,
                          float hours, double rate) {
        this(empID, Name.fromString(empName), birthDate, hireDate, hours, rate);
    }

    public float getTotalHoursWorked() {
        return this.totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = Math.max(0.0F, totalHoursWorked);
    }

    public double getRatePerHour() {
        return this.ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = Math.max(0.0, ratePerHour);
    }

    @Override
    public double computeSalary() {
        double regularHours = Math.min(this.totalHoursWorked, 40.0F);
        double overtimeHours = Math.max(0.0F, this.totalHoursWorked - 40.0F);
        return regularHours * this.ratePerHour + overtimeHours * this.ratePerHour * 1.5;
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        HourlyEmployee employee = (HourlyEmployee) object;
        return Float.compare(this.totalHoursWorked, employee.totalHoursWorked) == 0
                && Double.compare(this.ratePerHour, employee.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.totalHoursWorked, this.ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [%s]", this.employeeDetails());
    }
}