package seedu.addressbook.data.tag;

import org.omg.CORBA.PRIVATE_MEMBER;

import seedu.addressbook.data.person.Person;

public class Tagging {

	Person person;
	Tag tag;
	String tagSymbol;
	
	private static final String ADD_SYMBOL = "+";
	private static final String REMOVE_SYMBOL = "-";
	
	private enum OperationType {
		ADD,
		REMOVE
	}
	
	public Tagging(Person person, Tag tag, OperationType opType) {
		this.person = person;
		this.tag = tag;
		
		if(opType == OperationType.ADD)
			tagSymbol = ADD_SYMBOL;
		else if (opType == OperationType.REMOVE)
			tagSymbol = REMOVE_SYMBOL;
	}
	
	@Override
	public String toString() {
		return tagSymbol + " " + person.getName() + " " + tag.tagName;
	}
}
