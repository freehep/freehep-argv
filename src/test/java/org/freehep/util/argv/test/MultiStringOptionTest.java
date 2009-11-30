// Copyright 2007-2009, FreeHEP.
package org.freehep.util.argv.test;

import junit.framework.Assert;

import org.freehep.util.argv.ArgumentFormatException;
import org.freehep.util.argv.ArgumentParser;
import org.freehep.util.argv.BooleanOption;
import org.freehep.util.argv.MissingArgumentException;
import org.freehep.util.argv.MultiStringOption;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * MultiStringOption test.
 * 
 * @author Mark Donszelmann
 */
public final class MultiStringOptionTest {

	private BooleanOption help;
	private MultiStringOption mso;
	private ArgumentParser parser;

	@Before
	public void setup() {
		help = new BooleanOption("-help", "-h", "Describe command line args",
				true);

		mso = new MultiStringOption("-I", "file", "Description of option");

		parser = new ArgumentParser("StringOptionTest");
		parser.add(help);
		parser.add(mso);
	}

	@Test
	public void singleInclude() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-I", "include1" });
		Assert.assertEquals(1, mso.getValue().size());
		Assert.assertEquals("include1", mso.getValue().get(0));
	}

	@Test(expected = MissingArgumentException.class)
	public void singleIncludeMissing() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-I" });
	}

	@Test
	public void dualInclude() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-I", "include1", "-I", "include2" });
		Assert.assertEquals(2, mso.getValue().size());
		Assert.assertEquals("include1", mso.getValue().get(0));
		Assert.assertEquals("include2", mso.getValue().get(1));
	}

	@Test(expected = MissingArgumentException.class)
	@Ignore
	public void dualIncludeMissingFirst() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-I", "-I", "include2" });
	}

	@Test(expected = MissingArgumentException.class)
	public void dualIncludeMissingSecond() throws MissingArgumentException,
			ArgumentFormatException {
		parser.parse(new String[] { "-I", "include1", "-I" });
	}
}
