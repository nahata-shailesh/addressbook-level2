package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_STREET_INDEX = 1;
    public static final int ADDRESS_UNIT_INDEX = 2;
    public static final int ADDRESS_POSTAL_CODE_INDEX = 3;
    
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final Postal_Code postal_code;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] address_parts = address.split(", ");
        this.block = new Block(address_parts[ADDRESS_BLOCK_INDEX]);
        this.street = new Street(address_parts[ADDRESS_STREET_INDEX]);
        this.unit = new Unit(address_parts[ADDRESS_UNIT_INDEX]);
        this.postal_code = new Postal_Code(address_parts[ADDRESS_POSTAL_CODE_INDEX]);
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    public String getValue() {
    	return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postal_code.getPostal_code();
    }
    
    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return this.getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}