package version5;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() { this(1, 1, 2000); }
    public MyDate(int day, int month, int year) { this.setDate(day, month, year); }
    public int getDay() { return this.day; }
    public int getMonth() { return this.month; }
    public int getYear() { return this.year; }

    public void setDate(int day, int month, int year) {
        if (valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            this.day = 1;
            this.month = 1;
            this.year = 2000;
        }
    }

    public boolean isLeapYear() { return leap(this.year); }
    private static boolean leap(int year) { return year % 4 == 0 && year % 100 != 0 || year % 400 == 0; }
    private static boolean valid(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) return false;
        int[] days = {31, leap(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= days[month - 1];
    }

    @Override public MyDate clone() { try { return (MyDate) super.clone(); } catch (CloneNotSupportedException exception) { throw new AssertionError(exception); } }
    @Override public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MyDate)) return false;
        MyDate date = (MyDate) object;
        return this.day == date.day && this.month == date.month && this.year == date.year;
    }
    @Override public int hashCode() { return 31 * (31 * this.day + this.month) + this.year; }
    public String toDisplayString() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return String.format("%02d %s %04d", this.day, months[this.month - 1], this.year);
    }
    @Override public String toString() { return String.format("%02d/%02d/%04d", this.day, this.month, this.year); }
}
