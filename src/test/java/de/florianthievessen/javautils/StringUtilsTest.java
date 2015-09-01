package de.florianthievessen.javautils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StringUtilsTest extends TestCase {

	public StringUtilsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(StringUtilsTest.class);
	}

	@Override
	protected void setUp() throws Exception {

	}

	public void testPluralizeGeneralWords() {
		assertEquals("item", StringUtils.pluralize("item", 1));
		assertEquals("items", StringUtils.pluralize("item", 2));
	}

	public void testPluralizeWordsEndingInS() {
		assertEquals("bus", StringUtils.pluralize("bus", 1));
		assertEquals("buses", StringUtils.pluralize("bus", 2));
	}

	public void testPluralizeWordsEndingInX() {
		assertEquals("box", StringUtils.pluralize("box", 1));
		assertEquals("boxes", StringUtils.pluralize("box", 2));
	}

	public void testPluralizeWordsEndingInZ() {
		assertEquals("quiz", StringUtils.pluralize("quiz", 1));
		assertEquals("quizzes", StringUtils.pluralize("quiz", 2));
	}

	public void testPluralizeWordsEndingInCH() {
		assertEquals("pitch", StringUtils.pluralize("pitch", 1));
		assertEquals("pitches", StringUtils.pluralize("pitch", 2));
	}

	public void testPluralizeWordsEndingInSH() {
		assertEquals("wish", StringUtils.pluralize("wish", 1));
		assertEquals("wishes", StringUtils.pluralize("wish", 2));
	}

	public void testPluralizeWordsEndingInY() {
		assertEquals("penny", StringUtils.pluralize("penny", 1));
		assertEquals("pennies", StringUtils.pluralize("penny", 2));
	}

	public void testPluralizeIrregularWords() {
		assertEquals("man", StringUtils.pluralize("man", 1));
		assertEquals("men", StringUtils.pluralize("man", 2));
	}

}
