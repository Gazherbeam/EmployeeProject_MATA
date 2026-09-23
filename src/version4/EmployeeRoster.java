package version4;

public class EmployeeRoster {
    private final Employee[] employees;
    private int size;

    public EmployeeRoster(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Roster capacity must be positive");
        }
        this.employees = new Employee[capacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.employees.length;
    }

    public boolean isFull() {
        return this.size == this.employees.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(Employee employee) {
        if (employee == null || this.isFull()) {
            return false;
        }
        this.employees[this.size++] = employee;
        return true;
    }

    public Employee get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid roster index: " + index);
        }
        return this.employees[index];
    }

    public boolean removeById(int employeeId) {
        for (int index = 0; index < this.size; index++) {
            if (this.employees[index].getEmpID() == employeeId) {
                int elementsToMove = this.size - index - 1;
                if (elementsToMove > 0) {
                    System.arraycopy(this.employees, index + 1, this.employees, index, elementsToMove);
                }
                this.employees[--this.size] = null;
                return true;
            }
        }
        return false;
    }

    public int countByType(Class<? extends Employee> employeeType) {
        int count = 0;
        for (int index = 0; index < this.size; index++) {
            if (employeeType.isInstance(this.employees[index])) {
                count++;
            }
        }
        return count;
    }

    public double computeSalary(Employee employee) {
        if (employee instanceof BasePlusCommissionEmployee) {
            return ((BasePlusCommissionEmployee) employee).computeSalary();
        }
        if (employee instanceof CommissionEmployee) {
            return ((CommissionEmployee) employee).computeSalary();
        }
        if (employee instanceof HourlyEmployee) {
            return ((HourlyEmployee) employee).computeSalary();
        }
        if (employee instanceof PieceWorkerEmployee) {
            return ((PieceWorkerEmployee) employee).computeSalary();
        }
        return 0.0;
    }

    public double totalPayroll(int targetMonth) {
        double total = 0.0;
        for (int index = 0; index < this.size; index++) {
            Employee employee = this.employees[index];
            total += this.computeSalary(employee) + employee.getBirthdayBonus(targetMonth);
        }
        return total;
    }

    public Employee[] toArray() {
        Employee[] snapshot = new Employee[this.size];
        System.arraycopy(this.employees, 0, snapshot, 0, this.size);
        return snapshot;
    }
}
