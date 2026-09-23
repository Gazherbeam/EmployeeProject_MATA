package version4;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;
    public HourlyEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public HourlyEmployee(int id, String name, float hours, double rate) {
        this(id, Name.fromString(name), new MyDate(), new MyDate(), hours, rate);
    }

    public HourlyEmployee(int id, Name name, MyDate birth, MyDate hire,
            float hours, double rate) {
        super(id, name, birth, hire);
        this.setTotalHoursWorked(hours);
        this.setRatePerHour(rate);
    }

    public float getTotalHoursWorked() { return this.totalHoursWorked; }
    public void setTotalHoursWorked(float value) { this.totalHoursWorked = Math.max(0, value); }
    public double getRatePerHour() { return this.ratePerHour; }
    public void setRatePerHour(double value) { this.ratePerHour = Math.max(0, value); }

    public double computeSalary() {
        double regularHours = Math.min(this.totalHoursWorked, 40);
        double overtimeHours = Math.max(0, this.totalHoursWorked - 40);
        return regularHours * this.ratePerHour + overtimeHours * this.ratePerHour * 1.5;
    }

    @Override
    public HourlyEmployee clone() { return (HourlyEmployee) super.clone(); }

    @Override
    public String toString() { return String.format("HourlyEmployee [%s]", this.employeeDetails()); }
}
