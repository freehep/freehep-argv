// Copyright 2004, FreeHEP.
package org.freehep.util.argv;


/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/MissingArgumentException.java a98adf3dfd10 2005/11/19 07:52:18 duns $
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
