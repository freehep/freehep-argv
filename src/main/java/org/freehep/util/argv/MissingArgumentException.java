// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

/**
 * 
 * 
 * @author Mark Donszelmann
 */
public class MissingArgumentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5296018960092550727L;

	public MissingArgumentException(String msg) {
		super(msg);
	}
}
