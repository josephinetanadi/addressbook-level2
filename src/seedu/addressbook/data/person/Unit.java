package seedu.addressbook.data.person;

public class Unit {
    public final String Value;

    public Unit(String unit){
        String trimmedUnit = unit.trim();
        this.Value = trimmedUnit;
    }

    @Override
    public String toString() { return Value; }
}
