// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

/**
 * Exception to handle options such as -version or -help which need to bail out
 * from the parsing loop.
 * 
 * @author Mark Donszelmann
 */
public class BailOutException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8748945748952662967L;

	public BailOutException() {
		super();
	}
}
