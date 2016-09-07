package seedu.addressbook.common;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UtilsTest {

	private Utils utils;
	
	@Before
	public void setup() {
		utils = new Utils();
	}
	
	@Test
	public void check_null_object() {
		boolean checkValue = utils.isAnyNull(new Object(), null);
		assertEquals(true, checkValue);
	}
	
	@Test
	public void check_nonNull_object() {
		boolean checkValue = utils.isAnyNull(new Object());
		assertEquals(false, checkValue);
	}
	
	@Test
	public void check_all_unique_elements() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		boolean checkValue = utils.elementsAreUnique(list);
		assertTrue(checkValue);		
	}
	
	@Test
	public void check_non_unique_elements() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(8);
		list.add(7);
		
		boolean checkValue = utils.elementsAreUnique(list);
		assertFalse(checkValue);		
	}
}
