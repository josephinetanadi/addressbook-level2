package seedu.addressbook.data.person;

public class Street {
    public final String Value;

    public Street(String street){
        String trimmedStreet = street.trim();
        this.Value = trimmedStreet;
    }

    @Override
    public String toString() { return Value; }
}
