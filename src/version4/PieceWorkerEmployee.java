package version4;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;
    public PieceWorkerEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public PieceWorkerEmployee(int id, String name, int pieces, double rate) {
        this(id, Name.fromString(name), new MyDate(), new MyDate(), pieces, rate);
    }

    public PieceWorkerEmployee(int id, Name name, MyDate birth, MyDate hire,
            int pieces, double rate) {
        super(id, name, birth, hire);
        this.setTotalPiecesFinished(pieces);
        this.setRatePerPiece(rate);
    }

    public int getTotalPiecesFinished() { return this.totalPiecesFinished; }
    public void setTotalPiecesFinished(int value) { this.totalPiecesFinished = Math.max(0, value); }
    public double getRatePerPiece() { return this.ratePerPiece; }
    public void setRatePerPiece(double value) { this.ratePerPiece = Math.max(0, value); }
    public double computeSalary() {
        double basePay = this.totalPiecesFinished * this.ratePerPiece;
        double bonusPay = this.totalPiecesFinished / 100 * 10.0 * this.ratePerPiece;
        return basePay + bonusPay;
    }
    @Override public PieceWorkerEmployee clone() { return (PieceWorkerEmployee) super.clone(); }
    @Override public String toString() { return String.format("PieceWorkerEmployee [%s]", this.employeeDetails()); }
}
