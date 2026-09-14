package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
        this("N/A", "", "N/A");
    }

    public Name(String var1, String var2) {
        this(var1, "", var2);
    }

    public Name(String var1, String var2, String var3) {
        this.setFirstName(var1);
        this.setMiddleName(var2);
        this.setLastName(var3);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String var1) {
        this.firstName = var1 != null && !var1.trim().isEmpty() ? var1.trim() : "N/A";
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String var1) {
        this.middleName = var1 == null ? "" : var1.trim();
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String var1) {
        this.lastName = var1 != null && !var1.trim().isEmpty() ? var1.trim() : "N/A";
    }

    public String getFullName() {
        return this.middleName != null && !this.middleName.isEmpty() ? this.firstName + " " + this.middleName + " " + this.lastName : this.firstName + " " + this.lastName;
    }

    public String getInitials() {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.firstName.charAt(0));
        if (this.middleName != null && !this.middleName.isEmpty()) {
            var1.append(this.middleName.charAt(0));
        }

        var1.append(this.lastName.charAt(0));
        return var1.toString().toUpperCase();
    }

    public String toString() {
        return this.getFullName();
    }
}