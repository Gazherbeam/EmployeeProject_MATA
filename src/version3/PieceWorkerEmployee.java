package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this(empID, empName, new MyDate(), new MyDate(), 0, 0.0);
    }

    public PieceWorkerEmployee(int empID, String empName, int pieces, double rate) {
        this(empID, Name.fromString(empName), new MyDate(), new MyDate(), pieces, rate);
    }

    public PieceWorkerEmployee(int empID, Name empName, int pieces, double rate) {
        this(empID, empName, new MyDate(), new MyDate(), pieces, rate);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate,
                               int pieces, double rate) {
        super(empID, empName, birthDate, hireDate);
        this.setTotalPiecesFinished(pieces);
        this.setRatePerPiece(rate);
    }

    public int getTotalPiecesFinished() {
        return this.totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(0, totalPiecesFinished);
    }

    public double getRatePerPiece() {
        return this.ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = Math.max(0.0, ratePerPiece);
    }

    @Override
    public double computeSalary() {
        double basePay = this.totalPiecesFinished * this.ratePerPiece;
        double bonusPay = (this.totalPiecesFinished / 100) * 10.0 * this.ratePerPiece;
        return basePay + bonusPay;
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        PieceWorkerEmployee employee = (PieceWorkerEmployee) object;
        return this.totalPiecesFinished == employee.totalPiecesFinished
                && Double.compare(this.ratePerPiece, employee.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.totalPiecesFinished, this.ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [%s]", this.employeeDetails());
    }
}