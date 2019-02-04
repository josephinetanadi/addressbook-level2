package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Objects;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";
    public static final String UNIT_VALIDATION_REGEX = "#\\d+-\\d+";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d{6}";

    //public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] parts = trimmedAddress.split(", ");
        for(String part : parts) {
            if(part.matches(POSTALCODE_VALIDATION_REGEX)) { this.postalCode = new PostalCode(part); }
            else if(part.matches(UNIT_VALIDATION_REGEX)) { this.unit = new Unit(part); }
            else if(part.matches(BLOCK_VALIDATION_REGEX)) { this.block = new Block(part); }
            else { this.street = new Street(part); }
        }

        if(this.block == null) { this.block = new Block(""); }
        if(this.street == null) { this.street = new Street(""); }
        if(this.unit == null) { this.unit = new Unit(""); }
        if(this.postalCode == null) { this.postalCode = new PostalCode(""); }
        //this.value = trimmedAddress;
    }

    public Block getBlock() { return block; }

    public Street getStreet() { return street; }

    public Unit getUnit() { return unit; }

    public PostalCode getPostalCode() { return postalCode; }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) { return test.matches(ADDRESS_VALIDATION_REGEX); }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getBlock());
        if(getBlock().value != "") { builder.append(", "); }
        builder.append(getStreet());
        if(getStreet().value != "") { builder.append(", "); }
        builder.append(getUnit());
        if(getUnit().value != "") { builder.append(", "); }
        builder.append(getPostalCode());
        if(builder.toString().endsWith(", ")) { return builder.toString().substring(0, builder.toString().length()-2); }
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address
                && this.block.equals(((Address) other).getBlock())
                && this.street.equals(((Address) other).getStreet())
                && this.unit.equals(((Address) other).getUnit())
                && this.postalCode.equals(((Address) other).getPostalCode())); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, street, unit, postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
