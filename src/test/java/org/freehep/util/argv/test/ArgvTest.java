// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv.test;

import java.util.List;

import junit.framework.Assert;

import org.freehep.util.argv.ArgumentFormatException;
import org.freehep.util.argv.ArgumentParser;
import org.freehep.util.argv.BooleanOption;
import org.freehep.util.argv.DoubleOption;
import org.freehep.util.argv.IntOption;
import org.freehep.util.argv.ListParameter;
import org.freehep.util.argv.MissingArgumentException;
import org.freehep.util.argv.StringOption;
import org.freehep.util.argv.StringParameter;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for Argv package.
 * 
 * @author Mark Donszelmann
 */
public final class ArgvTest {

	private BooleanOption help;
	private StringOption dst;
	private DoubleOption scale;
	private IntOption page;
	private StringParameter file;
	private ListParameter files;

	private ArgumentParser parser;

	@Before
	public void setup() {
		help = new BooleanOption("-help", "Describe command line args", true);
		dst = new StringOption("-dest", "destination", "localhost",
				"Destination for request tests");
		scale = new DoubleOption("-scale", "factor", 1.0,
				"Scale output by factor");
		page = new IntOption("-page", "#", 1, "Display page #");
		file = new StringParameter("File", "InputFile");
		files = new ListParameter("Files", "Additional Input Files");

		parser = new ArgumentParser("ArgvTest");
		parser.add(dst);
		parser.add(help);
		parser.add(scale);
		parser.add(page);
		parser.add(file);
		parser.add(files);
	}

	@Test(expected = MissingArgumentException.class)
	public void testFileExpected() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] {});
	}

	@Test
	public void testHelp() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-help" });
		Assert.assertTrue(help.getValue());
	}

	@Test
	public void testStringOption() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-dest", "SomeNode", "SomeFile" });
		Assert.assertEquals("SomeNode", dst.getValue());
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test
	public void testStringOptionDefault() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "SomeFile" });
		Assert.assertEquals("localhost", dst.getValue());
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test
	public void testDoubleOption() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-scale", "4.5", "SomeFile" });
		Assert.assertEquals(4.5, scale.getValue().doubleValue(), 0.0001);
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test
	public void testDoubleOptionDefault() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "SomeFile" });
		Assert.assertEquals(1.0, scale.getValue().doubleValue(), 0.0001);
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test(expected = ArgumentFormatException.class)
	public void testDoubleOptionFormat() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-scale", "String", "SomeFile" });
	}

	@Test
	public void testIntOption() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-page", "4", "SomeFile" });
		Assert.assertEquals(4, page.getValue().intValue());
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test
	public void testIntOptionDefault() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "SomeFile" });
		Assert.assertEquals(1, page.getValue().intValue());
		Assert.assertEquals("SomeFile", file.getValue());
	}

	@Test(expected = ArgumentFormatException.class)
	public void testIntOptionFormat() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-page", "String", "SomeFile" });
	}

	@Test
	public void testExtra() throws MissingArgumentException,
			ArgumentFormatException {
		List<String> extra = parser.parse(new String[] { "SomeFile", "Extra1",
				"Extra2" });
		Assert.assertEquals("SomeFile", file.getValue());
		Assert.assertEquals(2, files.getValue().size());
		Assert.assertEquals("Extra1", files.getValue().get(0));
		Assert.assertEquals("Extra2", files.getValue().get(1));
	}
}
