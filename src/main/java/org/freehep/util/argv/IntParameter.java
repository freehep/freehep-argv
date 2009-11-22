// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

/**
 * 
 * 
 * @author Mark Donszelmann
 */
public class IntParameter extends NumberParameter {

	public IntParameter(String name, String description) {
		super(name, description);
	}

	public int getInt() {
		return super.getValue().intValue();
	}

}
