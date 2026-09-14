//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package version1;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.setTotalSale(totalSale);
    }

    public int getEmpID() {
        return this.empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public double computeSalary() {
        double commissionRate;
        if (this.totalSale < 50000.0) {
            commissionRate = 0.05;
        } else if (this.totalSale < 100000.0) {
            commissionRate = 0.1;
        } else if (this.totalSale < 500000.0) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.2;
        }

        return this.totalSale * commissionRate;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: %.2f%n", this.empID, this.empName, this.totalSale);
    }

    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Sale: %.2f, Total Salary: %.2f]", this.empID, this.empName, this.totalSale, this.computeSalary());
    }
}
