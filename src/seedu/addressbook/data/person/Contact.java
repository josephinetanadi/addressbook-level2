package seedu.addressbook.data.person;

public class Contact {

    public String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public Contact() { }

    public static boolean isValid(String test, String regex) { return test.matches(regex); }

    @Override
    public boolean equals(Object other) { throw new UnsupportedOperationException("This method is to be implemented by child classes"); }

    @Override
    public String toString() { return value; }

    @Override
    public int hashCode() { return value.hashCode(); }

    public boolean isPrivate() { return isPrivate; }
}
