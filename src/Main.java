// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;

public class Main {
    public Main() {
    }

    public class Main {
        public Main() {
        }

        public static void main(String[] var0) {
            System.out.println("--- Hourly Employee Test ---");
            HourlyEmployee var1 = new HourlyEmployee();
            var1.setEmpID(101);
            var1.setEmpName("Jack Sparrow");
            var1.setTotalHoursWorked(45.0F);
            var1.setRatePerHour((double)200.0F);
            HourlyEmployee var2 = new HourlyEmployee(102, "John Cruz", 40.0F, (double)180.0F);
            System.out.println("displayHourlyEmployee:\n");
            var1.displayHourlyEmployee();
            var2.displayHourlyEmployee();
            System.out.println("\ntoString:");
            System.out.println(var1);
            System.out.println(var2);
            System.out.println("\n--- Piece Worker Employee Test ---");
            PieceWorkerEmployee var3 = new PieceWorkerEmployee();
            var3.setEmpID(201);
            var3.setEmpName("Johnny Depp");
            var3.setTotalPiecesFinished(250);
            var3.setRatePerPiece((double)15.0F);
            PieceWorkerEmployee var4 = new PieceWorkerEmployee(202, "Joseph Joestar", 350, (double)12.0F);
            System.out.println("displayPieceWorkerEmployee:\n");
            var3.displayPieceWorkerEmployee();
            var4.displayPieceWorkerEmployee();
            System.out.println("\ntoString:");
            System.out.println(var3);
            System.out.println(var4);
            System.out.println("\n--- Commission Employee Test ---");
            CommissionEmployee var5 = new CommissionEmployee();
            var5.setEmpID(301);
            var5.setEmpName("Davy Jones");
            var5.setTotalSale((double)75000.0F);
            CommissionEmployee var6 = new CommissionEmployee(302, "Marco Martinzes", (double)150000.0F);
            System.out.println("displayCommissionEmployee\n");
            var5.displayCommissionEmployee();
            var6.displayCommissionEmployee();
            System.out.println("\ntoString: ");
            System.out.println(var5);
            System.out.println(var6);
            System.out.println("\n--- Base Plus Commission Employee Test ---");
            BasePlusCommissionEmployee var7 = new BasePlusCommissionEmployee();
            var7.setEmpID(401);
            var7.setEmpName("Marilyn Monroe");
            var7.setTotalSale((double)120000.0F);
            var7.setBaseSalary((double)10000.0F);
            BasePlusCommissionEmployee var8 = new BasePlusCommissionEmployee(402, "Star Butterfly", (double)600000.0F, (double)15000.0F);
            System.out.println("displayBasePlusCommissionEmployee");
            var7.displayBasePlusCommissionEmployee();
            var8.displayBasePlusCommissionEmployee();
            System.out.println("\ntoString: ");
            System.out.println(var7);
            System.out.println(var8);
        }
    }