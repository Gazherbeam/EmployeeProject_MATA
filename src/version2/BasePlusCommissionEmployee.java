//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package version2;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), 0.0, 0.0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.setEmpName(empName);
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this(empID, Name.fromString(empName), totalSale, baseSalary);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.setEmpName(empName);
        this.setTotalSale(totalSale);
        this.setBaseSalary(baseSalary);
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

    public double getTotalSale() {
        return this.totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0.0) {
            this.totalSale = totalSale;
        } else {
            this.totalSale = 0.0;
        }

    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0.0) {
            this.baseSalary = baseSalary;
        } else {
            this.baseSalary = 0.0;
        }

    }

    public double getCommissionRate() {
        if (this.totalSale < 50000.0) {
            return 0.05;
        } else if (this.totalSale < 100000.0) {
            return 0.1;
        } else {
            return this.totalSale < 500000.0 ? 0.15 : 0.2;
        }
    }

    public double computeSalary() {
        double commission = this.totalSale * this.getCommissionRate();
        return this.baseSalary + commission;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: %.2f | Base Salary: %.2f%n", this.empID, this.empName.getFullName(), this.totalSale, this.baseSalary);
    }

    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Sale: %.2f, Base Salary: %.2f, Commission Rate: %.0f%%, Total Salary: %.2f]", this.empID, this.empName.getFullName(), this.totalSale, this.baseSalary, this.getCommissionRate() * 100.0, this.computeSalary());
    }
}
