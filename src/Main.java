//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package version1;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("--- Hourly Employee Test ---");
        HourlyEmployee hourly1 = new HourlyEmployee();
        hourly1.setEmpID(101);
        hourly1.setEmpName("Jack Sparrow");
        hourly1.setTotalHoursWorked(45.0F);
        hourly1.setRatePerHour(200.0);
        HourlyEmployee hourly2 = new HourlyEmployee(102, "John Cruz", 40.0F, 180.0);
        System.out.println("displayHourlyEmployee:\n");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();
        System.out.println("\ntoString:");
        System.out.println(hourly1);
        System.out.println(hourly2);
        System.out.println("\n--- Piece Worker Employee Test ---");
        PieceWorkerEmployee piece1 = new PieceWorkerEmployee();
        piece1.setEmpID(201);
        piece1.setEmpName("Johnny Depp");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.0);
        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, "Joseph Joestar", 350, 12.0);
        System.out.println("displayPieceWorkerEmployee:\n");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();
        System.out.println("\ntoString:");
        System.out.println(piece1);
        System.out.println(piece2);
        System.out.println("\n--- Commission Employee Test ---");
        CommissionEmployee commission1 = new CommissionEmployee();
        commission1.setEmpID(301);
        commission1.setEmpName("Davy Jones");
        commission1.setTotalSale(75000.0);
        CommissionEmployee commission2 = new CommissionEmployee(302, "Marco Martinzes", 150000.0);
        System.out.println("displayCommissionEmployee\n");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();
        System.out.println("\ntoString: ");
        System.out.println(commission1);
        System.out.println(commission2);
        System.out.println("\n--- Base Plus Commission Employee Test ---");
        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee();
        base1.setEmpID(401);
        base1.setEmpName("Marilyn Monroe");
        base1.setTotalSale(120000.0);
        base1.setBaseSalary(10000.0);
        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee(402, "Star Butterfly", 600000.0, 15000.0);
        System.out.println("displayBasePlusCommissionEmployee");
        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();
        System.out.println("\ntoString: ");
        System.out.println(base1);
        System.out.println(base2);
    }
}
