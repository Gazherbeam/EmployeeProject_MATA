// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package version3;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int var1, int var2, int var3) {
        this.setDate(var1, var2, var3);
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int var1) {
        if (this.isValidDate(var1, this.month, this.year)) {
            this.day = var1;
        } else {
            this.day = 1;
        }

    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int var1) {
        if (this.isValidDate(this.day, var1, this.year)) {
            this.month = var1;
        } else {
            this.month = 1;
        }

    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int var1) {
        if (this.isValidDate(this.day, this.month, var1)) {
            this.year = var1;
        } else {
            this.year = 2000;
        }

    }

    public void setDate(int var1, int var2, int var3) {
        if (this.isValidDate(var1, var2, var3)) {
            this.day = var1;
            this.month = var2;
            this.year = var3;
        } else {
            this.day = 1;
            this.month = 1;
            this.year = 2000;
        }

    }

    public boolean isLeapYear() {
        return this.isLeapYearValue(this.year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MyDate)) {
            return false;
        }

        MyDate date = (MyDate) object;
        return this.day == date.day
                && this.month == date.month
                && this.year == date.year;
    }

    @Override
    public int hashCode() {
        int result = this.day;
        result = 31 * result + this.month;
        result = 31 * result + this.year;
        return result;
    }

    private boolean isLeapYearValue(int var1) {
        return var1 % 4 == 0 && var1 % 100 != 0 || var1 % 400 == 0;
    }

    private boolean isValidDate(int var1, int var2, int var3) {
        if (var3 >= 1 && var2 >= 1 && var2 <= 12 && var1 >= 1) {
            int var4 = 31;
            switch (var2) {
                case 2:
                    var4 = this.isLeapYearValue(var3) ? 29 : 28;
                    break;
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                default:
                    var4 = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    var4 = 30;
            }

            return var1 <= var4;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }

    public String toDisplayString() {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return String.format("%02d %s %04d", this.day, monthNames[this.month - 1], this.year);
    }
}

