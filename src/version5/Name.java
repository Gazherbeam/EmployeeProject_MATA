package version5;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() { this("N/A", "", "N/A"); }
    public Name(String firstName, String lastName) { this(firstName, "", lastName); }
    public Name(String firstName, String middleName, String lastName) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
    }

    public static Name fromString(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) return new Name();
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) return new Name(parts[0], "", "");
        if (parts.length == 2) return new Name(parts[0], parts[1]);
        StringBuilder middle = new StringBuilder();
        for (int index = 1; index < parts.length - 1; index++) {
            if (index > 1) middle.append(" ");
            middle.append(parts[index]);
        }
        return new Name(parts[0], middle.toString(), parts[parts.length - 1]);
    }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String value) { this.firstName = value != null && !value.trim().isEmpty() ? value.trim() : "N/A"; }
    public String getMiddleName() { return this.middleName; }
    public void setMiddleName(String value) { this.middleName = value == null ? "" : value.trim(); }
    public String getLastName() { return this.lastName; }
    public void setLastName(String value) { this.lastName = value != null && !value.trim().isEmpty() ? value.trim() : "N/A"; }
    public String getFullName() {
        String givenName = this.middleName.isEmpty() ? this.firstName : this.firstName + " " + this.middleName;
        return givenName + ", " + this.lastName;
    }

    @Override public Name clone() { try { return (Name) super.clone(); } catch (CloneNotSupportedException exception) { throw new AssertionError(exception); } }
    @Override public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Name)) return false;
        Name name = (Name) object;
        return Objects.equals(this.firstName, name.firstName)
                && Objects.equals(this.middleName, name.middleName)
                && Objects.equals(this.lastName, name.lastName);
    }
    @Override public int hashCode() { return Objects.hash(this.firstName, this.middleName, this.lastName); }
    @Override public String toString() { return this.getFullName(); }
}
