// Copyright 2007-2009, FreeHEP.
package org.freehep.util.argv.test;

import org.freehep.util.argv.ArgumentFormatException;
import org.freehep.util.argv.ArgumentParser;
import org.freehep.util.argv.BooleanOption;
import org.freehep.util.argv.MissingArgumentException;
import org.freehep.util.argv.StringOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StringOption test.
 *
 * @author Mark Donszelmann
 */ 
public final class StringOptionTest {

	private BooleanOption help;
	private StringOption so1, so2, so3;
	private ArgumentParser parser;
	
	@Before
	public void setup() {
        help = new BooleanOption("-help", "-h", "Describe command line args", true );

        so1 =  new StringOption("-so1", "option", "Description of option" );
        so2 =  new StringOption("-so2", "option", "default", "Description of option" );
        so3 =  new StringOption("-so3", "-s", "option", "default", "Description of option" );
        
        parser = new ArgumentParser("StringOptionTest");
        parser.add( help );
        parser.add( so1 );
        parser.add( so2 );
        parser.add( so3 );		
	}
	
	@Test
    public void testS01() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {"-so1", "so1"});
		Assert.assertEquals("so1", so1.getValue());		
    }

	@Test (expected=MissingArgumentException.class)
    public void testS01missingArgument() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {"-so1"});
    }

	@Test
    public void testS02() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {"-so2", "so2"});
		Assert.assertEquals("so2", so2.getValue());		
    }

	@Test
    public void testS02defaultValue() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {});
		Assert.assertEquals("default", so2.getValue());		
    }
	
	@Test
    public void testS03() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {"-so3", "so3"});
		Assert.assertEquals("so3", so3.getValue());		
    }

	@Test
    public void testS03short() throws MissingArgumentException, ArgumentFormatException {		
		parser.parse(new String[] {"-s", "so3"});
		Assert.assertEquals("so3", so3.getValue());		
    }
}
