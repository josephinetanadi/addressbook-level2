package seedu.addressbook.data.person;

public class Street {
    public final String value;

    public Street(String street){
        String trimmedStreet = street.trim();
        this.value = trimmedStreet;
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() { return value.hashCode(); }
}
