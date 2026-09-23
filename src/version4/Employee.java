package version4;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, String empName, MyDate birthDate, MyDate hireDate) {
        this(empID, Name.fromString(empName), birthDate, hireDate);
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate hireDate) {
        this.setEmpID(empID);
        this.setEmpName(empName);
        this.setBirthDate(birthDate);
        this.setHireDate(hireDate);
    }

    public int getEmpID() {
        return this.empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return this.empName.clone();
    }

    public void setEmpName(Name empName) {
        this.empName = empName == null ? new Name() : empName.clone();
    }

    public void setEmpName(String empName) {
        this.setEmpName(Name.fromString(empName));
    }

    public MyDate getBirthDate() {
        return this.birthDate.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate == null ? new MyDate() : birthDate.clone();
    }

    public MyDate getHireDate() {
        return this.hireDate.clone();
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate == null ? new MyDate() : hireDate.clone();
    }

    public double getBirthdayBonus(int targetMonth) {
        return this.birthDate.getMonth() == targetMonth ? 5000.0 : 0.0;
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = this.empName.clone();
            copy.birthDate = this.birthDate.clone();
            copy.hireDate = this.hireDate.clone();
            return copy;
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }

    protected boolean sameEmployee(Employee employee) {
        return this.empID == employee.empID
            && Objects.equals(this.empName, employee.empName)
                && Objects.equals(this.birthDate, employee.birthDate)
                && Objects.equals(this.hireDate, employee.hireDate);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return this.sameEmployee((Employee) object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), this.empID, this.empName, this.birthDate, this.hireDate);
    }

    protected String employeeDetails() {
        return String.format("ID: %d, Name: %s, DOB: %s, Hired: %s",
            this.empID, this.empName, this.birthDate.toDisplayString(),
            this.hireDate.toDisplayString());
    }

    @Override
    public String toString() {
        return String.format("Employee [%s]", this.employeeDetails());
    }
}
