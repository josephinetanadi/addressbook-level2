package seedu.addressbook.data.person;

public class PostalCode {
    public final String Value;

    public PostalCode(String postalCode){
        String trimmedPostalCode = postalCode.trim();
        this.Value = trimmedPostalCode;
    }

    @Override
    public String toString() { return Value; }
}
