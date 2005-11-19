// Copyright 2004, FreeHEP.
package org.freehep.util.argv;


/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/ArgumentFormatException.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */ 
public class ArgumentFormatException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6677826455427890342L;

	public ArgumentFormatException(String msg) {
        super(msg);
    }
}
