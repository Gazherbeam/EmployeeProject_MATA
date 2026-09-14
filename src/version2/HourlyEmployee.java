//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package version2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), 0.0F, 0.0);
    }

    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.setEmpName(empName);
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this(empID, Name.fromString(empName), totalHoursWorked, ratePerHour);
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.setEmpName(empName);
        this.setTotalHoursWorked(totalHoursWorked);
        this.setRatePerHour(ratePerHour);
    }

    public int getEmpID() {
        return this.empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return this.empName;
    }

    public void setEmpName(Name empName) {
        this.empName = (empName == null) ? new Name() : empName;
    }

    public void setEmpName(String empName) {
        this.empName = Name.fromString(empName);
    }

    public float getTotalHoursWorked() {
        return this.totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0.0F) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            this.totalHoursWorked = 0.0F;
        }

    }

    public double getRatePerHour() {
        return this.ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0.0) {
            this.ratePerHour = ratePerHour;
        } else {
            this.ratePerHour = 0.0;
        }

    }

    public double computeSalary() {
        if (this.totalHoursWorked <= 40.0F) {
            return (double)this.totalHoursWorked * this.ratePerHour;
        } else {
            double regularPay = 40.0 * this.ratePerHour;
            double overtimePay = (double)(this.totalHoursWorked - 40.0F) * this.ratePerHour * 1.5;
            return regularPay + overtimePay;
        }
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: %.2f/hr%n", this.empID, this.empName.getFullName(), this.totalHoursWorked, this.ratePerHour);
    }

    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: %.2f, Total Salary: %.2f]", this.empID, this.empName.getFullName(), this.totalHoursWorked, this.ratePerHour, this.computeSalary());
    }
}
