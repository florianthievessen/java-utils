package de.florianthievessen.javautils;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CollectionUtilsTest extends TestCase {

	public CollectionUtilsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CollectionUtilsTest.class);
	}

	@Override
	protected void setUp() throws Exception {

	}

	public void testExtractListOfStringValues() {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < 5; i++) {
			items.add(new Item("title " + i, "description " + i));
		}

		List<String> titles = CollectionUtils.extractListOfAttributeValues(items, "getTitle", String.class);

		assertNotNull(titles);
		assertFalse(titles.isEmpty());
		assertEquals(5, titles.size());
		assertTrue(titles.get(0) instanceof String);
	}

	public void testExtractListOfIntegerValues() {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < 5; i++) {
			items.add(new Item("title " + i, "description " + i, i));
		}

		List<Integer> titles = CollectionUtils.extractListOfAttributeValues(items, "getNumber", Integer.class);

		assertNotNull(titles);
		assertFalse(titles.isEmpty());
		assertEquals(5, titles.size());
		assertTrue(titles.get(0) instanceof Integer);
	}

	public class Item {

		private String title;
		private String description;
		private Integer number;

		public Item(String title, String description) {
			this.title = title;
			this.description = description;
		}

		public Item(String title, String description, Integer number) {
			this.title = title;
			this.description = description;
			this.number = number;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

	}
}
