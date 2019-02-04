package seedu.addressbook.data.person;

public class Block {
    public final String Value;

    public Block(String block){
        String trimmedBlock = block.trim();
        this.Value = trimmedBlock;
    }

    @Override
    public String toString(){ return Value; }
}
