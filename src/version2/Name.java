package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
        this("N/A", "", "N/A");
    }

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName);
    }

    public Name(String firstName, String middleName, String lastName) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
    }

    public static Name fromString(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return new Name();
        }

        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) {
            return new Name(parts[0], "", "");
        }
        if (parts.length == 2) {
            return new Name(parts[0], parts[1]);
        }

        StringBuilder middle = new StringBuilder();
        for (int i = 1; i < parts.length - 1; i++) {
            if (i > 1) {
                middle.append(" ");
            }
            middle.append(parts[i]);
        }

        return new Name(parts[0], middle.toString(), parts[parts.length - 1]);
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